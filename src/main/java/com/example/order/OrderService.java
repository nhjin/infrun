package com.example.order;

public interface OrderService {

    Order createOrder(Long member, String itemName, int itemPrice);
}
