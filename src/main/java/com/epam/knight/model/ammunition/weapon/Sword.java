package com.epam.knight.model.ammunition.weapon;

public class Sword implements Weapon {
    private int weight;
    private int cost;
    private int damage;

    public Sword(int weight, int cost, int damage) {
        this.weight = weight;
        this.cost = cost;
        this.damage = damage;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public int damage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Sword{damage=" + damage + ", weight=" + weight + ", cost=" + cost + "}";
    }
}
