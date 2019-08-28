package com.company.MdAynulIslamU1M5Summative.model;

import java.util.Objects;

public class Author {

    //properties of author table using Camel case

    private int authorId;// auto increment primary key,
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
    private String email;

    //Getters and Setters

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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


    // equal and hashcode
    // selecting the fields that must not be null
    //in this case all of it

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId &&
                firstName.equals(author.firstName) &&
                lastName.equals(author.lastName) &&
                street.equals(author.street) &&
                city.equals(author.city) &&
                state.equals(author.state) &&
                postalCode.equals(author.postalCode) &&
                phone.equals(author.phone) &&
                email.equals(author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, firstName, lastName, street, city, state, postalCode, phone, email);
    }
}
