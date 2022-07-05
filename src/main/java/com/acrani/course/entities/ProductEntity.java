package com.acrani.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class ProductEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String igmUrl;
    @ManyToMany()
    @JoinTable(name = "tb_products_categories",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryEntity> categories = new HashSet<>();
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItemEntity> items = new HashSet<>();

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String description, Double price, String igmUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.igmUrl = igmUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIgmUrl() {
        return igmUrl;
    }

    public void setIgmUrl(String igmUrl) {
        this.igmUrl = igmUrl;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<OrderEntity> getOrders(){
        Set<OrderEntity> orders = new HashSet<>();

        for (OrderItemEntity item: items) {
            orders.add(item.getOrder());
        }
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
