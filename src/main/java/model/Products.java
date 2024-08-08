package model;

import java.sql.Date;
import java.util.Objects;

public class Products {
    String Id;
    String name;
    int quantity;
    float price;
    Date date;
    String description;
    String image;
    int cid;

    public Products(String id, String name, int quantity, float price, Date date, String description, String image, int cid) {
        Id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.description = description;
        this.image = image;
        this.cid = cid;
    }

    public Products(String id) {
        Id = id;
    }

    public Products() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Products{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", cid=" + cid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(Id, products.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
