package com.alpha74.rest.webserver.springrestweb;

public class HealthStatusBean {

    private String status ;
    public HealthStatusBean(String message)
    {
        this.status = message ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HealthStatusBean{" +
                "status='" + status + '\'' +
                '}';
    }
}
