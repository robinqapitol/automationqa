
package com.qapitol.automationqa.api.pojo;

import java.util.HashMap;
import java.util.Map;

public class Update {

    private String id;
    private String name;
    private String fname;
    private String t;
    private U u;
    private CustomFields customFields;
    private Boolean broadcast;
    private Boolean encrypted;
    private Boolean ro;
    private Boolean sysMes;
    private Boolean _default;
    private String updatedAt;
    private LastMessage lastMessage;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }

    public CustomFields getCustomFields() {
        return customFields;
    }

    public void setCustomFields(CustomFields customFields) {
        this.customFields = customFields;
    }

    public Boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(Boolean broadcast) {
        this.broadcast = broadcast;
    }

    public Boolean getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    public Boolean getRo() {
        return ro;
    }

    public void setRo(Boolean ro) {
        this.ro = ro;
    }

    public Boolean getSysMes() {
        return sysMes;
    }

    public void setSysMes(Boolean sysMes) {
        this.sysMes = sysMes;
    }

    public Boolean getDefault() {
        return _default;
    }

    public void setDefault(Boolean _default) {
        this._default = _default;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LastMessage getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(LastMessage lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
