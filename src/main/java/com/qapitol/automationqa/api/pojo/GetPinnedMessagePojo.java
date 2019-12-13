
package com.qapitol.automationqa.api.pojo;

import java.util.HashMap;
import java.util.Map;

public class GetPinnedMessagePojo {

    private Message message;
    private Boolean success;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
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
