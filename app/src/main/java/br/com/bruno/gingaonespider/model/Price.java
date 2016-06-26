package br.com.bruno.gingaonespider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Bruno on 26/06/2016.
 */
public class Price {

    @JsonProperty("type")
    private String type;
    @JsonProperty("price")
    private double price;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
