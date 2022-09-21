package com.perye.strategy.duck.entity;

import com.perye.strategy.duck.behavior.fly.FlyWithWings;
import com.perye.strategy.duck.behavior.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("display--MallardDuck");
    }
}
