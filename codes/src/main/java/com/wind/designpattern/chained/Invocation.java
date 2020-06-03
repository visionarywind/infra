package com.wind.designpattern.chained;

public interface Invocation<Req, Rep> {
    Req getRequest();
    Rep getResponse();
}
