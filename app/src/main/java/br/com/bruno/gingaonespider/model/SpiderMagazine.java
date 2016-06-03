package br.com.bruno.gingaonespider.model;

/**
 * Created by techresult on 03/06/2016.
 */
public class SpiderMagazine {

    private String title;
    private String description;
    private String onSaleDate;
    private Integer pageCount;
    private String pathImg;
    private String extensionImg;


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

    public String getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(String onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }


    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

    public String getExtensionImg() {
        return extensionImg;
    }

    public void setExtensionImg(String extensionImg) {
        this.extensionImg = extensionImg;
    }
}
