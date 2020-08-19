package com.capgemini.placeanorder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.placeanorder.entity.OrderInfo;

@Repository
public interface OrderDao1 extends JpaRepository<OrderInfo, Integer>{
	@Modifying(clearAutomatically = true)
	@Query("UPDATE OrderInfo orderInfo SET orderInfo.quantity= :quantity WHERE "
			+ "orderInfo.orderId= :orderId")
	 void updateQuantity(@Param("quantity") Integer quantity, @Param("orderId") Integer orderId);
	List<OrderInfo> findByOrderId(Integer orderId);
}
