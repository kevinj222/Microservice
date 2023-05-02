package com.UST.InterviewFeedback.config;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import springfox.documentation.RequestHandler;

import java.util.List;

public class RequestHandlerFilter {
    public List<RequestHandler> filterHandlers(List<RequestHandler> handlers, Predicate<RequestHandler> predicate) {
        List<RequestHandler> filteredHandlers = Lists.newArrayList();
        for (RequestHandler handler : handlers) {
            if (predicate.apply(handler)) {
                filteredHandlers.add(handler);
            }
        }
        return filteredHandlers;
    }
}
