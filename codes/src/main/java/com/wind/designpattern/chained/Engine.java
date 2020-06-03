package com.wind.designpattern.chained;

public interface Engine {
    Object execute(EngineChain chain);
}
