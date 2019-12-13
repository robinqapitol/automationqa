
package com.qapitol.automationqa.api.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Me {

	
    private String _id;
    private Services services;
    private List<Email> emails = null;
    private String status;
    private Boolean active;
    private List<String> roles = null;
    private String name;
    private String statusConnection;
    private Double utcOffset;
    private String username;
    private String avatarUrl;
    private Settings settings;

    public String get_Id() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatusConnection() {
        return statusConnection;
    }

    public void setStatusConnection(String statusConnection) {
        this.statusConnection = statusConnection;
    }

    public Double getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Double utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
