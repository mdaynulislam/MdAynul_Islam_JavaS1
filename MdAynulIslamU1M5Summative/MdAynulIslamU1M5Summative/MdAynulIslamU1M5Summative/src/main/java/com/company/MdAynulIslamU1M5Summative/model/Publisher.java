package com.company.MdAynulIslamU1M5Summative.model;

import java.util.Objects;

public class Publisher {
    //properties of publisher table in Camel Case

    private int publisherId;//auto increment primary key,
    private String name;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
    private String email;


    //Getters and Setters

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //equal and hashcode
    // selecting the fields that must not be null


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisherId == publisher.publisherId &&
                name.equals(publisher.name) &&
                street.equals(publisher.street) &&
                city.equals(publisher.city) &&
                state.equals(publisher.state) &&
                postalCode.equals(publisher.postalCode) &&
                phone.equals(publisher.phone) &&
                email.equals(publisher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId, name, street, city, state, postalCode, phone, email);
    }
}
