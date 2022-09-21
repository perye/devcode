package com.perye.strategy.weapon.behavior;

public class SwordBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("用剑");
    }
}
