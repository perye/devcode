package com.perye.strategy.duck.behavior.quack;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("什么都不做，不会叫");
    }
}
