package com.melvin.tmt.model;

public class PuntoVenta {

    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private Ciudad city;

    public PuntoVenta(String name, String address, String latitude, String longitude, Ciudad city) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public Ciudad getCity() {
        return city;
    }
}
