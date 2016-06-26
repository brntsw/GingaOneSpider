package br.com.bruno.gingaonespider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Bruno on 26/06/2016.
 */
public class Dates {

    @JsonProperty("type")
    private String type;
    @JsonProperty("date")
    private String date;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
