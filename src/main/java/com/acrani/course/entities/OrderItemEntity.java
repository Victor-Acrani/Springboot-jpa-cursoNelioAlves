package com.acrani.course.entities;

import com.acrani.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItemEntity() {
    }

    public OrderItemEntity(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public OrderEntity getOrder(){
        return id.getOrder();
    }

    public void setOrder(OrderEntity order){
        this.id.setOrder(order);
    }

    public ProductEntity getProduct(){
        return id.getProduct();
    }

    public void setProduct(ProductEntity product){
        this.id.setProduct(product);
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal(){
        return quantity * price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemEntity orderItemEntity = (OrderItemEntity) o;

        return id != null ? id.equals(orderItemEntity.id) : orderItemEntity.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
