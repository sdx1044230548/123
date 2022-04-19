package com.example.eurekazuulclient.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        //共四种 pre post routing error
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //值越小越早执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行run () 方法中的逻辑
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            log.warn("token is empty!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            try {
                ctx.getResponse().getWriter().write("token is empty！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("ok");
        return null;
    }
}
