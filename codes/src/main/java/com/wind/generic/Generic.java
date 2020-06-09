package com.wind.generic;

import java.util.ArrayList;

public class Generic {
    // 这里其实没什么意思，所谓的泛型 -> 纯粹是java编译器的限制
    public void start() {
        testPecs();
    }

    public void testPecs() {
        ArrayList<? extends Derived> elist = new ArrayList<DerivedDerived>() {{ add(new DerivedDerived()); }};
        elist.get(0);
        // elist.add( XX ); // 使用者任何的修改都是不允许的

        ArrayList<? super Derived> slist = new ArrayList<Base>();
        // elist.add(new DerivedDerived());
        slist.add(new DerivedDerived());
        slist.add(new Derived());

        slist.forEach(e -> ((Base)e).print());

        ArrayList<? extends Object> olist = slist;
        olist.stream().forEach(e -> {
            if (e instanceof Base) {
                ((Base)e).print();
            }
        } );
    }

    class Base {
        void print() { System.out.println("I am Base"); }
    }

    class Derived extends Base { void print() { System.out.println("I am Derived"); } }
    class DerivedDerived extends Derived { void print() { System.out.println("I am DerivedDerived"); } }
}
