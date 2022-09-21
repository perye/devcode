package com.perye.strategy.weapon.behavior;

public class KnifeBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("匕首");
    }
}
