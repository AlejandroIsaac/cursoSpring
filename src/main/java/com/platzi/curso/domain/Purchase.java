package com.platzi.curso.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {
    private int idPurchase;
    private int idClient;
    private LocalDateTime date;
    private String paymentMethod;
    private String comments;
    private String state;
    private List<ItemPurchase> items;

    public List<ItemPurchase> getItems() {
        return items;
    }

    public void setItems(List<ItemPurchase> items) {
        this.items = items;
    }
//Getter and Setters

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
