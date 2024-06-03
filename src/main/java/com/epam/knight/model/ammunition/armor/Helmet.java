package com.epam.knight.model.ammunition.armor;

public class Helmet implements Armor {
    private int weight;
    private int cost;
    private int protection;

    public Helmet(int weight, int cost, int protection) {
        this.weight = weight;
        this.cost = cost;
        this.protection = protection;
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
    public int protection() {
        return protection;
    }

    @Override
    public String toString() {
        return "Helmet{protection=" + protection + ", weight=" + weight + ", cost=" + cost + "}";
    }
}
