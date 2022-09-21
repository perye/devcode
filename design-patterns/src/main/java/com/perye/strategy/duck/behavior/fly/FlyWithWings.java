package com.perye.strategy.duck.behavior.fly;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("实现鸭子飞行");
    }
}
