package com.example.ExcelSpring.repo;

import com.example.ExcelSpring.modal.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}