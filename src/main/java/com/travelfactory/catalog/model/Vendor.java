package com.travelfactory.catalog.model;

import java.util.Objects;

public class Vendor {
    private String name;

    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vendor)) return false;
        Vendor vendor = (Vendor) o;
        return Objects.equals(name, vendor.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "name='" + name + '\'' +
                '}';
    }
}
