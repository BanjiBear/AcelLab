package io.acellab.official.service.web.app.startline.Util;

import io.acellab.official.service.web.app.startline.Status.ResponseFactory;
import io.acellab.official.service.web.app.startline.Status.Status;

import java.util.Collections;
import java.util.List;

public class ResponseUtil {

    public static <T> ResponseFactory<T> createResponse(Status status, List<T> resultList) {
        ResponseFactory<T> responseFactory = new ResponseFactory<>();
        responseFactory.setStatus(status);
        responseFactory.setItems(resultList);
        return responseFactory;
    }

    public static <T> ResponseFactory<T> createResponse(Status status, T result) {
        ResponseFactory<T> responseFactory = new ResponseFactory<>();
        responseFactory.setStatus(status);
        if (result != null) {
            responseFactory.setItems(Collections.singletonList(result));
        } else {
            responseFactory.setItems(null);
        }
        return responseFactory;
    }
}
