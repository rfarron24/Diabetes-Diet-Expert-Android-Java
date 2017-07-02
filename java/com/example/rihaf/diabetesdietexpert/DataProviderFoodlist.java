package com.example.rihaf.diabetesdietexpert;

/**
 * Created by rihaf on 12/26/2016.
 */
public class DataProviderFoodlist {

    private String name;
    private String porsi;
    private Double porsikal;
    private Double gramkal;
    private String proteincontent;
    private String fatcontent;
    private String carbcontent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPorsi() {
        return porsi;
    }

    public void setPorsi(String porsi) {
        this.porsi = porsi;
    }

    public Double getPorsikal() {
        return porsikal;
    }

    public void setPorsikal(Double porsikal) {
        this.porsikal = porsikal;
    }

    public Double getGramkal() {
        return gramkal;
    }

    public void setGramkal(Double gramkal) {
        this.gramkal = gramkal;
    }

    public String getProteincontent() {
        return proteincontent;
    }

    public void setProteincontent(String proteincontent) {
        this.proteincontent = proteincontent;
    }

    public String getFatcontent() {
        return fatcontent;
    }

    public void setFatcontent(String fatcontent) {
        this.fatcontent = fatcontent;
    }

    public String getCarbcontent() {
        return carbcontent;
    }

    public void setCarbcontent(String carbcontent) {
        this.carbcontent = carbcontent;
    }

    public  DataProviderFoodlist(String name, String porsi, Double porsikal, Double gramkal, String proteincontent, String fatcontent, String carbcontent)
    {
        this.name =name;
        this.porsi =porsi;
        this.porsikal =porsikal;
        this.gramkal =gramkal;
        this.proteincontent =proteincontent;
        this.fatcontent =fatcontent;
        this.carbcontent =carbcontent;

    }


}


