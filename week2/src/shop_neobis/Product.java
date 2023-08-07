package shop_neobis;
import java.util.Objects;

public class Product {
    private String name;
    private int price;
    private int amount;

    public Product(String name, String price, int amount) { // constructor
        this.name = name;
        this.price = Integer.parseInt(price);
        this.amount = amount;
    }
    public String getName() { //getter
        return name;
    }

    public void setName(String name) { //setter
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price=price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount=amount;
    }

    public String toString() {
        return "Уверены ли вы купить " + amount + " штук " + name + " за " + price*amount + " тг";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, amount);
    }
}

