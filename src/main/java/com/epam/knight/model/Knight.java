package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;
import java.util.ArrayList;
import java.util.List;

public class Knight {

    private List<Ammunition> ammunition;

    public Knight() {
        this.ammunition = new ArrayList<>();
    }

    public Ammunition[] getAmmunition() {
        return ammunition.toArray(new Ammunition[0]);
    }

    public void equip(Ammunition element) {
        this.ammunition.add(element);
    }

    public int calculateAmmunitionWeight() {
        int totalWeight = 0;
        for (Ammunition a : ammunition) {
            totalWeight += a.getWeight();
        }
        return totalWeight;
    }

    public int calculateAmmunitionCost() {
        int totalCost = 0;
        for (Ammunition a : ammunition) {
            totalCost += a.getCost();
        }
        return totalCost;
    }

    public int calculateAmmunitionDamage() {
        int totalDamage = 0;
        for (Ammunition a : ammunition) {
            if (a instanceof com.epam.knight.model.ammunition.weapon.Weapon) {
                totalDamage += ((com.epam.knight.model.ammunition.weapon.Weapon) a).damage();
            }
        }
        return totalDamage;
    }

    public int calculateAmmunitionProtection() {
        int totalProtection = 0;
        for (Ammunition a : ammunition) {
            if (a instanceof com.epam.knight.model.ammunition.armor.Armor) {
                totalProtection += ((com.epam.knight.model.ammunition.armor.Armor) a).protection();
            }
        }
        return totalProtection;
    }
}
