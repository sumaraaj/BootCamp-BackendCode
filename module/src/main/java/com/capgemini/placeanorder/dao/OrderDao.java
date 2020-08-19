package com.capgemini.placeanorder.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.capgemini.placeanorder.entity.OrderInfo;
@Repository
public class OrderDao {
	
	@PersistenceContext
	EntityManager em;
	
	public boolean deleteOrder(Integer orderId) {
		OrderInfo order = em.find(OrderInfo.class, orderId);
		if (order != null) {
			em.remove(order);
			return true;
		} else {
			return false;
		}
	}

}
