package com.example.ExcelSpring.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invoice {

	@Id
   @GeneratedValue
	private Long id;
	private String name;
	private Double amount;
	private String number;
	private String receivedDate;
	

}