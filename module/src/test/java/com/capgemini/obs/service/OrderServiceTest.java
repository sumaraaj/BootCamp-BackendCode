package com.capgemini.obs.service;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.capgemini.placeanorder.dao.BookDao;
import com.capgemini.placeanorder.dao.OrderDao;
import com.capgemini.placeanorder.entity.*;
import com.capgemini.placeanorder.service.OrderServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {
	@Rule
	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	@Mock
	private OrderDao orderDao;
	@Mock
	private BookDao bookDao;
	//@InjectMocks
	@Mock
	private OrderServiceImpl orderService;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void deleteOrder_pos1(){
		// Run the test
		orderDao.deleteOrder(2);
		// Verify the results
		verify(orderDao, times(1)).deleteOrder(2);
	}
	@Test
	public void deleteOrder_neg1(){
		// Run the test
		orderDao.deleteOrder(2);
		// Verify the results
		verify(orderDao, times(2)).deleteOrder(2);
	}
	@Test
	public void deleteOrder_neg2(){
		// Run the test
		orderDao.deleteOrder(7);
		// Verify the results
		verify(orderDao, times(1)).deleteOrder(2);
	}
	@Test
	public void deleteOrder_pos2(){

		// Run the test
		orderDao.deleteOrder(2);

		//Verify the results
		verify(orderDao, times(1)).deleteOrder(2);
	}
	@Test
	public void addOrder() {
		OrderInfo order=new OrderInfo();
		order.setOrderId(12);
		order.setQuantity(4);
		order.setSubTotal((float) 45.08);
		order.setTotal((float) 500.1);
		order.setOrderStatus("shipping");
		order.setPaymentMethod("upi");
	}

	
}