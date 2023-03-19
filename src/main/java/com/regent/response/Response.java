package com.regent.response;

import java.util.List;

public class Response {
    private List<ResponseData> data;

    public Response(final List<ResponseData> data) {
        this.data = data;
    }

    public Response() {
    }

    public List<ResponseData> getData() {
        return data;
    }

    public void setData(final List<ResponseData> data) {
        this.data = data;
    }
}
