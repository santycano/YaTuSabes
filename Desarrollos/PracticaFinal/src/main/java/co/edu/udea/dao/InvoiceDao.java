package co.edu.udea.dao;

import co.edu.udea.model.Invoice;
import org.springframework.data.repository.CrudRepository;


public interface InvoiceDao extends CrudRepository<Invoice, Integer>{

}
