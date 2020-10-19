package com.manikarthi25.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manikarthi25.entity.OrderEO;

@Repository
public interface OrderRepo extends JpaRepository<OrderEO, Integer> {

}
