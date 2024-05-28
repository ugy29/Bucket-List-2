import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BucketList {
    private ArrayList<String> items; // Stores bucket list items
    private Scanner scanner; // Used for user input

    // Constructor initializes the bucket list and scanner
    public BucketList() {
        this.items = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Adds an item to the bucket list
    public void addItem(String item) {
        items.add(item);
    }

    // Checks if an item exists in the bucket list
    public boolean sequentialSearch(String item) {
        return items.contains(item);
    }

    // Sorts the bucket list alphabetically
    public void sortList() {
        Collections.sort(items);
    }

    // Prints the original bucket list
    public void printOriginalList() {
        System.out.println("\u001B[96mBucket List\u001B[0m:");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    // Prints the sorted bucket list
    public void printSortedList() {
        System.out.println("\u001B[96mBucket List (Sorted)\u001B[0m:");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    // Handles user interaction
    public void interactWithUser() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Search for an item");
            System.out.println("2. Add a new item");
            System.out.println("3. Finish editing and display bucket list");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter item to search for:");
                    String searchItem = scanner.nextLine();
                    if (sequentialSearch(searchItem)) {
                        System.out.println(searchItem + " is already on the bucket list.");
                    } else {
                        System.out.println(searchItem + " is not on the bucket list.");
                    }
                    break;
                case "2":
                    System.out.println("Enter new item to add to the bucket list:");
                    String newItem = scanner.nextLine();
                    addItem(newItem);
                    System.out.println(newItem + " added to the bucket list.");
                    break;
                case "3":
                    printOriginalList();
                    sortList();
                    printSortedList();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input. Please choose 1, 2, or 3.");
            }
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        System.out.println("\u001B[96m== Bucket List Manager ==\u001B[0m");
        BucketList bucketList = new BucketList();
        bucketList.interactWithUser();
    }
}
