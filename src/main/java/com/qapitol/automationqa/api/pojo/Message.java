
package com.qapitol.automationqa.api.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message {

    private String alias;
    private String msg;
    private List<Object> attachments = null;
    private Boolean parseUrls;
    private Boolean groupable;
    private String ts;
    private U u;
    private String rid;
    private String id;
    private String updatedAt;
    private List<Object> mentions = null;
    private List<Object> channels = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public Boolean getParseUrls() {
        return parseUrls;
    }

    public void setParseUrls(Boolean parseUrls) {
        this.parseUrls = parseUrls;
    }

    public Boolean getGroupable() {
        return groupable;
    }

    public void setGroupable(Boolean groupable) {
        this.groupable = groupable;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Object> getMentions() {
        return mentions;
    }

    public void setMentions(List<Object> mentions) {
        this.mentions = mentions;
    }

    public List<Object> getChannels() {
        return channels;
    }

    public void setChannels(List<Object> channels) {
        this.channels = channels;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
