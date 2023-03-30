
package model;

import utils.Utils;

import java.util.Objects;

public class Product {
    private static int count = 1;

    private int id;
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.id = count;
        this.name = name;
        this.price = price;
        Product.count += 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    public String toString(){
    return "Id: " + getId()
            + "\nName: " + getName()
            + "\nPrice: " + Utils.doubleToString(getPrice());
    }
}
