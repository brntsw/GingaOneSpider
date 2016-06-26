package br.com.bruno.gingaonespider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by techresult on 03/06/2016.
 */
public class SpiderMagazine {

    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("dates")
    private List<Dates> dates;
    @JsonProperty("prices")
    private List<Price> prices;
    @JsonProperty("pageCount")
    private Integer pageCount;
    @JsonProperty("thumbnail")
    private Thumbnail thumb;
    @JsonProperty("images")
    private List<ImageSpider> images;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Dates> getDates() {
        return dates;
    }

    public void setDates(List<Dates> dates) {
        this.dates = dates;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Thumbnail getThumb() {
        return thumb;
    }

    public void setThumb(Thumbnail thumb) {
        this.thumb = thumb;
    }

    public List<ImageSpider> getImages() {
        return images;
    }

    public void setImages(List<ImageSpider> images) {
        this.images = images;
    }
}
