package com.manikarthi25.service;

import com.manikarthi25.dto.OrderDTO;
import com.manikarthi25.exception.OrderException;

public interface IOrderService {

	String getWelcomeMesage(String name);
	
	boolean placeOrder(OrderDTO orderDTO) throws OrderException;
	
	boolean cancelOrder(Integer orderId) throws OrderException;;
	
	boolean deleteOrder(Integer orderId) throws OrderException;;

}
