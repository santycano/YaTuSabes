package co.edu.udea.Schema;

import java.util.Date;
import java.util.Random;

public class InvoiceCode {
    private String diancertificade;
    private String invoiceNumberCertificade;
    private Date dateInvoice;
    private Random random;
    public InvoiceCode(Date dateInvoice) {
        random = new Random();
        this.diancertificade = String.valueOf(random.ints(20));
        this.invoiceNumberCertificade = String.valueOf(random.ints(20));;
        this.dateInvoice = dateInvoice;
    }

    public String getDiancertificade() {
        return diancertificade;
    }

    public String getInvoiceNumberCertificade() {
        return invoiceNumberCertificade;
    }

    public Date getDateInvoice() {
        return dateInvoice;
    }

}
