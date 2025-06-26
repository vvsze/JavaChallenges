package challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayListChallenge {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();
        while (flag) {
            printMenu();
            switch (Integer.parseInt(scanner.nextLine())) {
                default -> flag = false;
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
            }

        }
    }

    public static void printMenu() {
        String menu = """
                Availible options: 
                0 - to shutdown
                1 - to add item(s) to the list
                2 - to remove any items)""";
        System.out.println(menu + " ");
    }

    public static void addItems(ArrayList<String> groceries) {

        System.out.println("Add item(s) [separate items by comma]");
        String[] list = scanner.nextLine().split(",");

        for (String item : list) {
            String trimmedItem = item.trim();
            if (groceries.indexOf(trimmedItem) < 0)
                groceries.add(trimmedItem);
        }

        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries.toString());
    }


    public static void removeItems(ArrayList<String> groceries) {

        System.out.println("Remove item(s) [separate items by comma]");
        String[] list = scanner.nextLine().split(",");

        for (String item : list) {
            String trimmedItem = item.trim();
            groceries.remove(trimmedItem.toLowerCase());
        }

        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries.toString());
    }
}
