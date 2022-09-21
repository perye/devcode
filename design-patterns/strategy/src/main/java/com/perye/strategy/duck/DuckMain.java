package com.perye.strategy.duck;

import com.perye.strategy.duck.behavior.fly.FlyRocketPowered;
import com.perye.strategy.duck.entity.Duck;
import com.perye.strategy.duck.entity.MallardDuck;

public class DuckMain {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.setFlyBehavior(new FlyRocketPowered());
        duck.display();
        duck.performFly();
        duck.performQuack();
    }
}
