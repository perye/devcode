package com.perye.strategy.duck.entity;

import com.perye.strategy.duck.behavior.fly.FlyNoWay;
import com.perye.strategy.duck.behavior.quack.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("display--ModelDuck");
    }
}
