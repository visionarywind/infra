package com.wind.designpattern.chained;

import java.util.ArrayList;
import java.util.List;

public class AbstractEngineChain implements EngineChain {
    private final List<Engine> engines = new ArrayList<>();
    private int index = 0;

    @Override
    public Object doNext() {
        return engines.get(--index).execute(this);
    }

    @Override
    public void addEngine(Engine engine) { engines.add(engine); index = engines.size(); }
}
