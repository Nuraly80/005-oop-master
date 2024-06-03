package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.armor.Helmet;
import com.epam.knight.model.ammunition.weapon.Sword;
import com.epam.knight.view.ConsoleView;

import java.util.Arrays;
import java.util.Comparator;

public class KnightApplication {

    private final ConsoleView view;
    private final Knight knight;

    public KnightApplication() {
        this.view = new ConsoleView();
        this.knight = KnightGenerator.generateKnight();
    }

    public static void main(String[] args) {
        KnightApplication application = new KnightApplication();
        application.start();
    }

    private void start() {
        while (true) {
            view.printMainMenu();
            int option = view.readInt();
            switch (option) {
                case 1:
                    printKnightStats();
                    break;
                case 2:
                    showAmmunition();
                    break;
                case 3:
                    equipAmmunition();
                    break;
                case 4:
                    sortAmmunition();
                    break;
                case 5:
                    searchAmmunition();
                    break;
                case 6:
                    view.printMessage("Bye!");
                    return;
                default:
                    view.printMessage("Invalid option. Please try again.");
            }
        }
    }

    private void printKnightStats() {
        view.printMessage("Ammunition cost: " + knight.calculateAmmunitionCost());
        view.printMessage("Ammunition weight: " + knight.calculateAmmunitionWeight());
        view.printMessage("Ammunition damage: " + knight.calculateAmmunitionDamage());
        view.printMessage("Ammunition protection: " + knight.calculateAmmunitionProtection());
    }

    private void showAmmunition() {
        Ammunition[] ammo = knight.getAmmunition();
        for (Ammunition a : ammo) {
            view.printMessage(a.toString());
        }
    }

    private void equipAmmunition() {
        view.printMessage("What kind of ammunition do you want to equip?");
        view.printMessage("1. Sword");
        view.printMessage("2. Helmet");
        int option = view.readInt();
        switch (option) {
            case 1:
                view.printMessage("Input sword weight:");
                int swordWeight = view.readInt();
                view.printMessage("Input sword cost:");
                int swordCost = view.readInt();
                view.printMessage("Input sword damage:");
                int swordDamage = view.readInt();
                knight.equip(new Sword(swordWeight, swordCost, swordDamage));
                break;
            case 2:
                view.printMessage("Input helmet weight:");
                int helmetWeight = view.readInt();
                view.printMessage("Input helmet cost:");
                int helmetCost = view.readInt();
                view.printMessage("Input helmet protection:");
                int helmetProtection = view.readInt();
                knight.equip(new Helmet(helmetWeight, helmetCost, helmetProtection));
                break;
            default:
                view.printMessage("Invalid option. Please try again.");
        }
    }

    private void sortAmmunition() {
        view.printMessage("Choose sort type:");
        view.printMessage("1. Cost");
        view.printMessage("2. Weight");
        int option = view.readInt();
        Ammunition[] ammo = knight.getAmmunition();
        Comparator<Ammunition> comparator;
        switch (option) {
            case 1:
                comparator = Comparator.comparingInt(Ammunition::getCost);
                break;
            case 2:
                comparator = Comparator.comparingInt(Ammunition::getWeight);
                break;
            default:
                view.printMessage("Invalid option. Please try again.");
                return;
        }
        Arrays.sort(ammo, comparator);
        for (Ammunition a : ammo) {
            view.printMessage(a.toString());
        }
    }

    private void searchAmmunition() {
        view.printMessage("Choose search field:");
        view.printMessage("1. Cost");
        view.printMessage("2. Weight");
        int option = view.readInt();
        view.printMessage("Input minimum value:");
        int minValue = view.readInt();
        view.printMessage("Input maximum value:");
        int maxValue = view.readInt();

        Ammunition[] ammo = knight.getAmmunition();
        for (Ammunition a : ammo) {
            int value;
            switch (option) {
                case 1:
                    value = a.getCost();
                    break;
                case 2:
                    value = a.getWeight();
                    break;
                default:
                    view.printMessage("Invalid option. Please try again.");
                    return;
            }
            if (value >= minValue && value <= maxValue) {
                view.printMessage(a.toString());
            }
        }
    }
}

