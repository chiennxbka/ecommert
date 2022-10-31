package com.example.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cartitem")
public class CartItem {

    @Id
    @Column(name="id", nullable=false, unique=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId")
    private Cart cart;

    @Column(name = "quantityOrdered")
    private int quantityOrdered;

    @Column(name = "extraPrice")
    private BigDecimal extraPrice;

    @Column(name = "productCode")
    private String productCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(BigDecimal extraPrice) {
        this.extraPrice = extraPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
