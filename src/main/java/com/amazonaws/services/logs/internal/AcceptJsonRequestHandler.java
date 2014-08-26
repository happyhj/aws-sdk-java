package com.amazonaws.services.logs.internal;

import com.amazonaws.client.handler.request.AbstractRequestHandler;
import com.amazonaws.network.type.Request;

public class AcceptJsonRequestHandler extends AbstractRequestHandler {

    @Override
    public void beforeRequest(Request<?> request) {
        request.addHeader("Accept", "application/json");
    }

}
