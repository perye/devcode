package com.perye.strategy.weapon;

import com.perye.strategy.weapon.behavior.AxeBehavior;
import com.perye.strategy.weapon.behavior.BowAndArrowBehavior;
import com.perye.strategy.weapon.entity.Character;
import com.perye.strategy.weapon.entity.King;

public class WeaponMain {

    public static void main(String[] args) {
        Character character = new King();
        character.fight();
        character.setWeaponBehavior(new AxeBehavior());
        character.performFight();
        character.setWeaponBehavior(new BowAndArrowBehavior());
        character.performFight();
    }
}
