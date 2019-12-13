
package com.qapitol.automationqa.api.pojo;

import java.util.HashMap;
import java.util.Map;

public class Url {

    private String url;
    private Boolean ignoreParse;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getIgnoreParse() {
        return ignoreParse;
    }

    public void setIgnoreParse(Boolean ignoreParse) {
        this.ignoreParse = ignoreParse;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
