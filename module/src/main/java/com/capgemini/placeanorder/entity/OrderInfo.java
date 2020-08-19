package com.capgemini.placeanorder.entity;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
@Entity
@Table(name="OrderInfo")
public class OrderInfo {
@Id
@Column(name="orderId")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
@SequenceGenerator(sequenceName = "order_sequence", allocationSize = 1, name = "order_seq")
private Integer orderId;
@Column(name="quantity")
private Integer quantity;
@Column(name="subTotal")
private Float subTotal;
@Column(name="total")
private Float total;
@Column(name="orderStatus")
private String orderStatus;
@Column(name="orderDate")
private Date orderDate;
@Column(name="paymentMethod")
@Length(min=2, max=16)
private String paymentMethod;
@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
@Fetch(value = FetchMode.SUBSELECT)
@JoinColumn(name = "orderid")
private List<BookInfo> BookInfo;
@Override
public String toString() {
	return "OrderInfo [orderId=" + orderId + ", quantity=" + quantity + ", subTotal=" + subTotal + ", total=" + total
			+ ", orderStatus=" + orderStatus + ",orderDate="+orderDate+", paymentMethod=" + paymentMethod + ", BookInfo=" + BookInfo + "]";
}


public OrderInfo(Integer orderId, Integer quantity, Float subTotal, Float total, String orderStatus,Date orderDate,
		@NotEmpty(message = "PaymentMethod is mandatory") @Length(min = 2, max = 16) String paymentMethod,
		List<com.capgemini.placeanorder.entity.BookInfo> bookInfo) {
	super();
	this.orderId = orderId;
	this.quantity = quantity;
	this.subTotal = subTotal;
	this.total = total;
	this.orderStatus = orderStatus;
	this.orderDate=orderDate;
	this.paymentMethod = paymentMethod;
	BookInfo = bookInfo;
}


public Date getOrderDate() {
	return orderDate;
}


public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}


public Integer getOrderId() {
	return orderId;
}


public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}


public Integer getQuantity() {
	return quantity;
}


public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}


public Float getSubTotal() {
	return subTotal;
}


public void setSubTotal(Float subTotal) {
	this.subTotal = subTotal;
}


public Float getTotal() {
	return total;
}


public void setTotal(Float total) {
	this.total = total;
}


public String getOrderStatus() {
	return orderStatus;
}


public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}


public String getPaymentMethod() {
	return paymentMethod;
}


public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}


public List<BookInfo> getBookInfo() {
	return BookInfo;
}


public void setBookInfo(List<BookInfo> bookInfo) {
	BookInfo = bookInfo;
}


public OrderInfo() {
	super();
	// TODO Auto-generated constructor stub
}



}
