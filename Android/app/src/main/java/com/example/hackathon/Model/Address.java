package com.example.hackathon.Model;

public class Address {

    private String street;
    private String plz;
    private String city;
    private Coordinates coordinates;

    public Address(String street, String plz, String city, Coordinates coordinates) {
        this.street = street;
        this.plz = plz;
        this.city = city;
        this.coordinates = coordinates;
    }

    public String getStreet() {
        return street;
    }

    public String getPlz() {
        return plz;
    }

    public String getCity() {
        return city;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
