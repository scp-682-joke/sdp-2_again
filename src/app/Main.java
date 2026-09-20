package app;

import logistics.*;
import ui.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Delivery mode (ROAD / SEA): ");
        String deliveryModeInput = scanner.nextLine().trim().toUpperCase();

        Logistics logistics = selectLogistics(deliveryModeInput);
        if (logistics == null) {
            System.err.println("Error: Unsupported or invalid delivery mode specified!");
            return;
        }

        System.out.print("UI platform (WINDOWS / MACOS): ");
        String platformInput = scanner.nextLine().trim().toUpperCase();

        GUIFactory guiFactory = selectGUIFactory(platformInput);
        if (guiFactory == null) {
            System.err.println("Error: Unsupported or invalid UI platform specified!");
            return;
        }

        System.out.println("----------------------------------------");
        DeliveryApplication app = new DeliveryApplication(guiFactory, logistics);
        app.run("laboratory equipment", "Astana");
        System.out.println("----------------------------------------");
    }

    private static Logistics selectLogistics(String mode) {
        return switch (mode) {
            case "ROAD" -> new RoadLogistics();
            case "SEA" -> new SeaLogistics();
            default -> null;
        };
    }

    private static GUIFactory selectGUIFactory(String platform) {
        return switch (platform) {
            case "WINDOWS" -> new WindowsFactory();
            case "MACOS" -> new MacOSFactory();
            default -> null;
        };
    }
}