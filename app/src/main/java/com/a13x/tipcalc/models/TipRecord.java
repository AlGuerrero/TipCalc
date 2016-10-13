package com.a13x.tipcalc.models;

//import android.icu.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alejandro on 13/10/2016.
 */
public class TipRecord {
    private double  bill;
    private int tipPercentage;
    private Date timestamp;

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public int getTipPercentage() {
        return tipPercentage;
    }

    public void setTipPercentage(int tipPercentage) {
        this.tipPercentage = tipPercentage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getTip(){
        return bill *(tipPercentage/100d);
    }

    public String getDateformated(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM dd, yyyy HH:mm");
        return simpleDateFormat.format(timestamp);
    }
}
