
package com.qapitol.automationqa.api.pojo;

import java.util.HashMap;
import java.util.Map;

public class Attachment_ {

    private String ts;
    private String title;
    private String titleLink;
    private Boolean titleLinkDownload;
    private ImageDimensions imageDimensions;
    private String imagePreview;
    private String imageUrl;
    private String imageType;
    private Integer imageSize;
    private String type;
    private String description;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleLink() {
        return titleLink;
    }

    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    public Boolean getTitleLinkDownload() {
        return titleLinkDownload;
    }

    public void setTitleLinkDownload(Boolean titleLinkDownload) {
        this.titleLinkDownload = titleLinkDownload;
    }

    public ImageDimensions getImageDimensions() {
        return imageDimensions;
    }

    public void setImageDimensions(ImageDimensions imageDimensions) {
        this.imageDimensions = imageDimensions;
    }

    public String getImagePreview() {
        return imagePreview;
    }

    public void setImagePreview(String imagePreview) {
        this.imagePreview = imagePreview;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public Integer getImageSize() {
        return imageSize;
    }

    public void setImageSize(Integer imageSize) {
        this.imageSize = imageSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
