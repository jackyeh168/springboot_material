package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "material_room")
@Data
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private Long floor;

	@Column(nullable = false)
	private Long roomNumber;

	@Column
	private String roomType;

	@Column(nullable = false)
	private Long capacity;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String imageUrl;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String status;

	@Column(nullable = false)
	private BigDecimal price;
}
