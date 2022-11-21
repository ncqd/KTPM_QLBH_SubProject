package com.example.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ProductDTO {
	
	private String id;
	private int productId;
	private String name;
	private String description;
	private BigDecimal price;

}
