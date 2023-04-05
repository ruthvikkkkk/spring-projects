package com.example.fileconsumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    @Id
    private Long orderId;

    private Integer totalCost;

    private Integer totalQty;
}
