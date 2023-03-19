package com.regent.response;

import java.util.List;

public class ResponseData {
    private List<String> callingCodes;

    public ResponseData() {
    }

    public ResponseData(final List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(final List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }
}
