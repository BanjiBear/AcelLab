package io.acellab.official.service.web.app.startline.Status;

import java.util.List;

public class ResponseFactory<T> {
    private Status status;
    private List<T> items;

    public ResponseFactory() {
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return this.status.getStatusMessage();
    }

    public int getStatusCode() {
        return this.status.getStatusCode();
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return this.items;
    }
}