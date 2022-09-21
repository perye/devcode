package com.perye.strategy.duck.entity;

import com.perye.strategy.duck.behavior.fly.FlyWithWings;
import com.perye.strategy.duck.behavior.quack.Squeak;

public class RubberDuck extends Duck {

    public RubberDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("display--RubberDuck");
    }
}
