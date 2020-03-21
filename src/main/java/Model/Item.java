package Model;

public class Item {

    private long id;
    private String description;
    private int quantity;
    private String unity;       //Maybe use preset unities

    public Item (int id, String description, int quantity, String unity)
    {
        this(description, quantity, unity);
        setId(id);
    }

    public Item (String description, int quantity, String unity)
    {
        setDescription(description);
        setQuantity(quantity);
        setUnity(unity);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }
}
