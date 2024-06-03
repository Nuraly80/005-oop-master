package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.armor.Helmet;
import com.epam.knight.model.ammunition.weapon.Sword;

public class KnightGenerator {

    public static Knight generateKnight() {
        Knight knight = new Knight();
        knight.equip(new Helmet(10, 20, 30));
        knight.equip(new Sword(20, 30, 10));
        return knight;
    }
}
