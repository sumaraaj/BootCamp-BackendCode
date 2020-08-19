package com.capgemini.placeanorder.service;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.capgemini.placeanorder.dao.OrderDao;
import com.capgemini.placeanorder.dao.OrderDao1;
import com.capgemini.placeanorder.entity.OrderInfo;
import com.capgemini.placeanorder.exception.OrderException;
@Transactional
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderDao1 orderDao1;
	@Override
	public String deleteOrder(Integer orderId) throws OrderException {
		if (orderDao.deleteOrder(orderId))
			return "Order Deleted Sucessfully";
		else
			throw new OrderException("Order not Found.");

	}

	@Override 
	public String updateQuantity(Integer orderId, Integer quantity) throws OrderException{
		if (Objects.isNull(orderId))
			throw new OrderException("No such order id");
		Optional<OrderInfo> optionalOrder = orderDao1.findById(orderId);
		if (optionalOrder.isPresent()) {
				orderDao1.updateQuantity(quantity, orderId);
				return "Order Updated Successfully";
		}
		else throw new OrderException("Order not found");
	}
}
