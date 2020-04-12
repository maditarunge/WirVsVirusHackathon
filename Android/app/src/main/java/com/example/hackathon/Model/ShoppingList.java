package com.example.hackathon.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ShoppingList {

    private int id;
    private User creator;
    private LocalDate created;
    private Status status;      //TODO MR 2020-04-09 1900: change bool status in db to enum
    private LocalDate done;
    private int helperId;

    private ArrayList<ShoppingListEntry> entries;

    public ShoppingList(int id, User creator, LocalDate created, Status status, LocalDate done, int helperId, ArrayList<ShoppingListEntry> entries) {
        this(creator, created, status, done, helperId, entries);
        setId(id);
    }

    public ShoppingList(int id, User creator, LocalDate created, Status status, LocalDate done, int helperId) {
        this(id, creator, created, status, done, helperId, new ArrayList<ShoppingListEntry>());
    }

    public ShoppingList(User creator, LocalDate created, Status status, LocalDate done, int helperId, ArrayList<ShoppingListEntry> entries) {
        setCreator(creator);
        setCreated(created);
        setStatus(status);
        setDone(done);
        setHelperId(helperId);
        setEntries(entries);
    }

    public ShoppingList(User creator, LocalDate created, Status status, LocalDate done, int helperId) {
        this(creator, created, status, done, helperId, new ArrayList<ShoppingListEntry>());
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    private void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDate getCreated() {
        return created;
    }

    private void setCreated(LocalDate created) {
        this.created = created;
    }

    public Status getStatus() {
        return status;
    }

    private void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDone() {
        return done;
    }

    private void setDone(LocalDate done) {
        this.done = done;
    }

    public int getHelperId() {
        return helperId;
    }

    private void setHelperId(int helperId) {
        this.helperId = helperId;
    }

    public ArrayList<ShoppingListEntry> getEntries() {
        return entries;
    }

    private void setEntries(ArrayList<ShoppingListEntry> entries) {
        this.entries = entries;
    }
}
