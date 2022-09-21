package com.perye.strategy.weapon.behavior;

public class AxeBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("用斧头");
    }
}
