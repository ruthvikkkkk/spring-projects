package com.example.reactiveredis.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "icecream")
@Data
@ToString
public class IceCream{

	@Id
	private String flavor;
	private Integer quantity;
	private Double costPerGram;
}
