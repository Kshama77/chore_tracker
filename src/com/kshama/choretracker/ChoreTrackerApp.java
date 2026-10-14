package com.kshama.choretracker;

import java.util.ArrayList;
import java.util.Scanner;

public class ChoreTrackerApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Chore> chores = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("==================================");
        System.out.println("       CHORE TRACKER");
        System.out.println("  Keep everyday tasks organized!");
        System.out.println("==================================");

        while (running) {
            showMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    addChore();
                    break;
                case 2:
                    viewChores();
                    break;
                case 3:
                    completeChore();
                    break;
                case 4:
                    removeChore();
                    break;
                case 5:
                    showSummary();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thanks for using Chore Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Please choose a valid menu option.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\\n------------- MENU -------------");
        System.out.println("1. Add a chore");
        System.out.println("2. View all chores");
        System.out.println("3. Mark a chore as completed");
        System.out.println("4. Delete a chore");
        System.out.println("5. View completion summary");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
    }

    private static void addChore() {
        System.out.print("Enter chore name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Chore name cannot be empty.");
            return;
        }

        System.out.print("Assigned to (enter a name): ");
        String assignedTo = scanner.nextLine().trim();
        if (assignedTo.isEmpty()) {
            assignedTo = "Unassigned";
        }

        chores.add(new Chore(nextId++, name, assignedTo));
        System.out.println("Chore added successfully!");
    }

    private static void viewChores() {
        if (chores.isEmpty()) {
            System.out.println("No chores yet. Add your first chore!");
            return;
        }

        printHeader();
        for (Chore chore : chores) {
            chore.display();
        }
    }

    private static void completeChore() {
        if (chores.isEmpty()) {
            System.out.println("There are no chores to complete yet.");
            return;
        }

        viewChores();
        int id = readInt("Enter the chore ID to mark completed: ");
        Chore chore = findChoreById(id);

        if (chore == null) {
            System.out.println("No chore found with that ID.");
        } else if (chore.isCompleted()) {
            System.out.println("That chore is already completed.");
        } else {
            chore.markCompleted();
            System.out.println("Great job! Chore marked as completed.");
        }
    }

    private static void removeChore() {
        if (chores.isEmpty()) {
            System.out.println("There are no chores to delete.");
            return;
        }

        viewChores();
        int id = readInt("Enter the chore ID to delete: ");
        Chore chore = findChoreById(id);

        if (chore == null) {
            System.out.println("No chore found with that ID.");
        } else {
            chores.remove(chore);
            System.out.println("Chore deleted successfully.");
        }
    }

    private static void showSummary() {
        int completed = 0;
        for (Chore chore : chores) {
            if (chore.isCompleted()) {
                completed++;
            }
        }

        int total = chores.size();
        int pending = total - completed;
        double percentage = total == 0 ? 0 : (completed * 100.0 / total);

        System.out.println("\\n-------- CHORE SUMMARY --------");
        System.out.println("Total chores     : " + total);
        System.out.println("Completed chores : " + completed);
        System.out.println("Pending chores   : " + pending);
        System.out.printf("Completion rate  : %.1f%%%n", percentage);
        System.out.println("-------------------------------");
    }

    private static Chore findChoreById(int id) {
        for (Chore chore : chores) {
            if (chore.getId() == id) {
                return chore;
            }
        }
        return null;
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static void printHeader() {
        System.out.printf("%-5s %-28s %-20s %-12s%n",
                "ID", "CHORE", "ASSIGNED TO", "STATUS");
        System.out.println("---------------------------------------------------------------------");
    }
}
