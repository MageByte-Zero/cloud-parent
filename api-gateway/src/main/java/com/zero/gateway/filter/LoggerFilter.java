package com.zero.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static com.zero.common.constant.TokenConstant.ACCESS_TOKEN;

/**
 * 链路数据中添加自定义数据
 */
@Component
public class LoggerFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Tracer tracer;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String accessToken = request.getParameter(ACCESS_TOKEN);

        tracer.addTag("operator", accessToken);
        logger.info("trackId={}", tracer.getCurrentSpan().traceIdString());
        return null;
    }
}