package com.perye.strategy.duck.behavior.fly;

public class FlyRocketPowered implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("FlyRocketPowered");
    }
}
