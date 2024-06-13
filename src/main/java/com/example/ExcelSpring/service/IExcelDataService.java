package com.example.ExcelSpring.service;

import com.example.ExcelSpring.modal.Invoice;

import java.util.List;


public interface IExcelDataService {

	List<Invoice> getExcelDataAsList();
	
	int saveExcelData(List<Invoice> invoices);
}