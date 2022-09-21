package com.perye.strategy.weapon.behavior;

public class BowAndArrowBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("弓箭射击");
    }
}
