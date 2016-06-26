package br.com.bruno.gingaonespider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Bruno on 26/06/2016.
 */
public class ImageSpider {

    @JsonProperty("path")
    private String path;
    @JsonProperty("extension")
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
