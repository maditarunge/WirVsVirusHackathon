package Model;

import Model.Enums.Status;
import java.util.List;

public class ShoppingList {

    private long id;
    private User user;
    private List<Item> items;
    private Status status;

    public ShoppingList(long id, User user, List<Item> items, Status status)
    {
        this(user, items, status);
        setId(id);
    }

    public ShoppingList(User user, List<Item> items, Status status)
    {
        setUser(user);
        setItems(items);
        setStatus(status);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void add(Item item)
    {
        items.add(item);
    }

    public void addAll(List<Item> items)
    {
        this.items.addAll(items);
    }

    public void remove(Item item)
    {
        items.remove(item);
    }

    public void remove(String description)
    {
        for (int i = 0; i < items.size();)
        {
            if (items.get(i).getDescription().equals(description))
            {
                items.remove(i);
            }
            else
            {
                i++;
            }
        }
    }
}
