package com.kshama.choretracker;

public class Chore {
    private int id;
    private String name;
    private String assignedTo;
    private boolean completed;

    public Chore(int id, String name, String assignedTo) {
        this.id = id;
        this.name = name;
        this.assignedTo = assignedTo;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    public void markPending() {
        completed = false;
    }

    public void display() {
        String status = completed ? "Completed" : "Pending";
        System.out.printf("%-5d %-28s %-20s %-12s%n",
                id, name, assignedTo, status);
    }
}
