package co.edu.udea.Schema;

import co.edu.udea.model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private ArrayList <DataItem> dataItem;
    private String paymentType;
    private float taxAmount;
    private float total;
    private ArrayList unds;


    public Payment(ArrayList<DataItem> dataItem, String paymentType, ArrayList unds) {
        this.dataItem = dataItem;
        this.paymentType = paymentType;
        this.unds = unds;
    }

    public void totalPay(){
        taxes();
        float priceAcomulation = 0;
        for (int i = 0; i < dataItem.size(); i++) {
            priceAcomulation = priceAcomulation + ((Float)unds.get(i) * dataItem.get(i).getPrice());
        }
        total = priceAcomulation + taxAmount;
    }

    private void taxes(){
        for (int j = 0; j < dataItem.size(); j++) {
            taxAmount = (float) (taxAmount + (dataItem.get(j).getPrice() * 0.08));
        }
    }

    public ArrayList<DataItem> getDataItem() {
        return dataItem;
    }

    public void setDataItem(ArrayList<DataItem> dataItem) {
        this.dataItem = dataItem;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(float taxAmount) {
        this.taxAmount = taxAmount;
    }
}
