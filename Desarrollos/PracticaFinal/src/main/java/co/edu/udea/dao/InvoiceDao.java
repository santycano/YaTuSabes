package co.edu.udea.dao;

        import co.edu.udea.model.Invoice;
        import org.springframework.data.repository.CrudRepository;

        import java.util.List;


public interface InvoiceDao extends CrudRepository<Invoice, Integer>{
}
