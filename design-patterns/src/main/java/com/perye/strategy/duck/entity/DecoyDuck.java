package com.perye.strategy.duck.entity;

import com.perye.strategy.duck.behavior.fly.FlyNoWay;
import com.perye.strategy.duck.behavior.quack.MuteQuack;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("display--DecoyDuck");
    }
}
