
package com.qapitol.automationqa.api.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetRoomPojo {

    private List<Update> update = null;
    private List<Object> remove = null;
    private Boolean success;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Update> getUpdate() {
        return update;
    }

    public void setUpdate(List<Update> update) {
        this.update = update;
    }

    public List<Object> getRemove() {
        return remove;
    }

    public void setRemove(List<Object> remove) {
        this.remove = remove;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
