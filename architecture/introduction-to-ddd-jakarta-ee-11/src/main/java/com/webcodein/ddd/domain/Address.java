package com.webcodein.ddd.domain;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    private String street;
    private String city;
    private String zipCode;

    protected Address() {
        // JPA requirement
    }

    public Address(String street, String city, String zipCode) {
        this.street = Objects.requireNonNull(street, "Street must not be null");
        this.city = Objects.requireNonNull(city, "City must not be null");
        this.zipCode = Objects.requireNonNull(zipCode, "ZipCode must not be null");
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(street, address.street) &&
               Objects.equals(city, address.city) &&
               Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, zipCode);
    }
}
