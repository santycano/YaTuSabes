package co.edu.udea.Schema;

import co.edu.udea.controller.InvoiceController;
import org.json.*;

import java.util.ArrayList;
import java.util.Date;

public class JsonInvoice {
        private Payment payment;
        private ClientData clientData;
        private InvoiceCode invoiceCode;
        private JSONObject jInv;

        public JsonInvoice() {
        }

        public JSONObject createInvoice(ArrayList<DataItem> dataItems, ArrayList unds){
                jInv = new JSONObject();
                invoiceCode = new InvoiceCode(new Date());
                clientData = new ClientData("10958329-8","Angie Marcela" , "Calle 82#45-23");
                payment = new Payment(dataItems,"Credito",unds);
                jInv.put("paymentType",payment.getPaymentType());
                for (int i = 0; i < payment.getDataItem().size() ; i++) {
                        jInv.put("payment",payment.getDataItem().get(i).getItemId()+"  "+payment.getDataItem().get(i).getPrice());
                }
                jInv.put("totalTax",payment.getTaxAmount());
                jInv.put("total",payment.getTotal());
                jInv.put("address", clientData.getAddres());
                jInv.put("name",clientData.getName());
                jInv.put("nit",clientData.getNit());
                jInv.put("dateInvoice",invoiceCode.getDateInvoice());
                jInv.put("dateInvoice",invoiceCode.getDiancertificade());
                jInv.put("dateInvoice",invoiceCode.getInvoiceNumberCertificade());
                return  jInv;
        }
}
