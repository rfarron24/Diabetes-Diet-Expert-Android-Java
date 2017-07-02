package com.example.rihaf.diabetesdietexpert;

/**
 * Created by rihaf on 12/29/2016.
 */
public class dataProviderJournal {

    private String waktumakan;
    private String jenismakan;
    private String porsimakan;
    private Double kalorimakan;
    private String qty;
    private Double total;


    public String getWaktumakan() {
        return waktumakan;
    }

    public void setWaktumakan(String waktumakan) {
        this.waktumakan = waktumakan;
    }

    public String getJenismakan() {
        return jenismakan;
    }

    public void setJenismakan(String jenismakan) {
        this.jenismakan = jenismakan;
    }

    public String getPorsimakan() {
        return porsimakan;
    }

    public void setPorsimakan(String porsimakan) {
        this.porsimakan = porsimakan;
    }

    public Double getKalorimakan() {
        return kalorimakan;
    }

    public void setKalorimakan(Double kalorimakan) {
        this.kalorimakan = kalorimakan;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public  dataProviderJournal(String waktumakan, String jenismakan, String porsimakan, Double kalorimakan, String qty, Double total)
    {
        this.waktumakan =waktumakan;
        this.jenismakan =jenismakan;
        this.porsimakan =porsimakan;
        this.kalorimakan =kalorimakan;
        this.qty =qty;
        this.total =total;



    }
}
