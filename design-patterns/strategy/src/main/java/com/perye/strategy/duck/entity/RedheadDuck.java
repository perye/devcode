package com.perye.strategy.duck.entity;

import com.perye.strategy.duck.behavior.fly.FlyWithWings;
import com.perye.strategy.duck.behavior.quack.Quack;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("display--RedheadDuck");
    }
}
