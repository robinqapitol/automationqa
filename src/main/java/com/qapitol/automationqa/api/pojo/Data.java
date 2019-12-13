
package com.qapitol.automationqa.api.pojo;

import java.util.HashMap;
import java.util.Map;

public class Data {

    private String userId;
    private String authToken;
    private Me me;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Me getMe() {
        return me;
    }

    public void setMe(Me me) {
        this.me = me;
    }
}
