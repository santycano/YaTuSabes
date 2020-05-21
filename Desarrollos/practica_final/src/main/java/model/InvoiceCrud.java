package model;


import org.springframework.data.repository.CrudRepository;

public interface InvoiceCrud extends CrudRepository<Invoice, Integer> {
}
