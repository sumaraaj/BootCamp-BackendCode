package com.capgemini.placeanorder.service;
import com.capgemini.placeanorder.exception.OrderException;

public interface OrderService {
	 String deleteOrder(Integer orderId) throws OrderException;
 	 String updateQuantity(Integer orderId, Integer quantity) throws OrderException;

}
