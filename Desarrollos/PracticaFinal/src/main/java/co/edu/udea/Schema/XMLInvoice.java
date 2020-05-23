package co.edu.udea.Schema;

import org.json.JSONObject;
import org.json.XML;

import java.util.ArrayList;

public class XMLInvoice {
    private JsonInvoice jsonInvoice;

    public XMLInvoice() {
        this.jsonInvoice = new JsonInvoice();
    }

    public String convertJsonToXml(ArrayList<DataItem> dataItems,ArrayList unds) {
        return XML.toString(jsonInvoice.createInvoice(dataItems,unds));
    }

}
