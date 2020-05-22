package co.edu.udea.controller;

import java.util.List;

import co.edu.udea.dao.InvoiceDao;
import co.edu.udea.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceDao dao;

	@PostMapping("/saveInv")
	public String bookTicket(@RequestBody List<Invoice> invoices) {
		dao.save(invoices);
		return "ticket booked : " + invoices.size();
	}

	@GetMapping("/getInvoices")
	public List<Invoice> getTickets() {
		return (List<Invoice>) dao.findAll();
	}

}
