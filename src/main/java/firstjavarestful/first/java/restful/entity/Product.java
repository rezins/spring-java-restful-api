package firstjavarestful.first.java.restful.entity;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {

    @Id
    String id;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    Long price;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "createdAt")
    Date createdAt;

    @Column(name = "updatedAt")
    Date updatedAt;

    public Product(String id, String name, Long price, Integer quantity, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
