package com.capgemini.placeanorder.service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.placeanorder.dao.BookDao;
import com.capgemini.placeanorder.dao.OrderDao1;
import com.capgemini.placeanorder.entity.BookInfo;
import com.capgemini.placeanorder.entity.OrderInfo;
@Transactional
@Service
public class BookService 
{
	@Autowired
	BookDao bookDao;
	@Autowired
	OrderDao1 orderDao1;
	
	 public boolean addBook(BookInfo bookInfo)
		{
			return bookDao.save(bookInfo) != null;
		}
	 
	 public boolean addOrder(OrderInfo orderInfo)
		{
			return orderDao1.save(orderInfo) != null;
		}
}
