package com.manikarthi25.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.manikarthi25.dto.OrderDTO;
import com.manikarthi25.entity.OrderEO;
import com.manikarthi25.exception.OrderException;
import com.manikarthi25.repository.OrderRepo;
import com.manikarthi25.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Override
	public String getWelcomeMesage(String name) {

		if (null == name || name.length() == 0) {
			throw new IllegalArgumentException();
		}
		return "welcome " + name;
	}

	@Override
	public boolean placeOrder(OrderDTO orderDTO) throws OrderException {
		ModelMapper modelMapper = new ModelMapper();
		OrderEO orderEO = modelMapper.map(orderDTO, OrderEO.class);
		orderEO = orderRepo.save(orderEO);

		orderDTO = modelMapper.map(orderEO, OrderDTO.class);
		if (ObjectUtils.isEmpty(orderDTO)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean cancelOrder(Integer orderId) throws OrderException {
		ModelMapper modelMapper = new ModelMapper();
		Optional<OrderEO> optionalOrederEO = orderRepo.findById(orderId);
		OrderEO orderEO = new OrderEO();
		OrderDTO orderDTO = new OrderDTO();
		if (optionalOrederEO.isPresent()) {
			orderEO = optionalOrederEO.get();
			orderEO.setOrderStatus("Cancelled");
			orderEO = orderRepo.saveAndFlush(orderEO);
		}
		orderDTO = modelMapper.map(orderEO, OrderDTO.class);
		if (ObjectUtils.isEmpty(orderDTO)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteOrder(Integer orderId) throws OrderException {
		Optional<OrderEO> optionalOrederEO = orderRepo.findById(orderId);
		if (optionalOrederEO.isPresent()) {
			orderRepo.deleteById(orderId);
		}
		if (ObjectUtils.isEmpty(orderId)) {
			return false;
		}
		return true;
	}

}
