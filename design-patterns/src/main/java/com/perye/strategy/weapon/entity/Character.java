package com.perye.strategy.weapon.entity;

import com.perye.strategy.weapon.behavior.WeaponBehavior;

public abstract class Character {

    WeaponBehavior weaponBehavior;

    public abstract void fight();

    public void performFight(){
        weaponBehavior.useWeapon();
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
