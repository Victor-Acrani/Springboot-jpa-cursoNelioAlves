package com.acrani.course.repositories;

import com.acrani.course.entities.OrderItemEntity;
import com.acrani.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
