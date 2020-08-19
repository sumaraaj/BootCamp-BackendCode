package com.capgemini.placeanorder.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.placeanorder.dao.OrderDao1;
import com.capgemini.placeanorder.entity.OrderInfo;
import com.capgemini.placeanorder.exception.OrderException;
import com.capgemini.placeanorder.service.BookService;
import com.capgemini.placeanorder.service.OrderServiceImpl;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	@Autowired
	OrderServiceImpl orderServiceImpl;
	@Autowired
	BookService bookService;
	@DeleteMapping("/deleteOrder/orderId/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId) throws OrderException {
		try {
			orderServiceImpl.deleteOrder(orderId);
			return new ResponseEntity<>("Order Deleted Sucessfully", HttpStatus.OK);
		} catch (Exception exception) {
			throw new OrderException(exception.getMessage());
		}

	}
	@PutMapping("/updateQuantity/orderId/{orderId}/{quantity}") 
	public ResponseEntity<String>updateOrder(@PathVariable Integer orderId, @PathVariable Integer quantity) throws OrderException{
		try { 
			String result=orderServiceImpl.updateQuantity(orderId, quantity);
			return new ResponseEntity<>(result, HttpStatus.OK); 
		}catch (Exception exception) {
			throw new OrderException(exception.getMessage());
		}
	}
	
	
	
	
	@PostMapping("/addOrder")
	public ResponseEntity<String> addOrder(@RequestBody OrderInfo orderInfo) throws OrderException {
		try {
			bookService.addOrder(orderInfo);
			return new ResponseEntity<String>("Order added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new OrderException("ID already exists");
		}
	}
	

}
