
package com.qapitol.automationqa.api.pojo;

import java.util.HashMap;
import java.util.Map;

public class Email {

    private String address;
    private Boolean verified;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
}
