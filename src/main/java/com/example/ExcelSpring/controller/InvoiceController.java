package com.example.ExcelSpring.controller;

import com.example.ExcelSpring.service.IExcelDataService;
import com.example.ExcelSpring.service.IFileUploaderService;
import com.example.ExcelSpring.repo.InvoiceRepository;
import com.example.ExcelSpring.modal.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/")
public class InvoiceController {
	
	@Autowired
	IFileUploaderService fileService;
	
	@Autowired
	IExcelDataService excelservice;
	
	@Autowired
	InvoiceRepository repo;
	
	@GetMapping
    public String index() {
		return "uploadPage";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file,Model model) {
		System.out.println(file.getOriginalFilename());
        fileService.uploadFile(file);
        model.addAttribute("message",
            "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
		return "uploadPage";
    }
    
    @GetMapping("/saveData")
    public String saveExcelData(Model model) {
    	
    	List<Invoice> excelDataAsList = excelservice.getExcelDataAsList();
    	int noOfRecords = excelservice.saveExcelData(excelDataAsList);
		System.out.println(noOfRecords);
    	model.addAttribute("noOfRecords",noOfRecords);
    	return "success";
    }
}