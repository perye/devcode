package com.perye.strategy.duck.behavior.quack;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("实现鸭子呱呱叫");
    }
}
