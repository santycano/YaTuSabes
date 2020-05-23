package co.edu.udea.Schema;

public class DataItem {
    private float price;
    private String itemId;
    private int stock;

    public DataItem(float price, String itemId) {
        this.price = price;
        this.itemId = itemId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
