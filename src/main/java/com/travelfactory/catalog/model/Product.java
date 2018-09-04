package com.travelfactory.catalog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class Product {

    @Id
    private String id;

    private String idProduct;
    private String name;
    private String roomNumber;

    private Vendor vendor;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate catalogDate;


    public Product() {
    }

    public Product(String idProduct, String name, String roomNumber, Vendor vendor, LocalDate catalogDate) {
        this.idProduct = idProduct;
        this.name = name;
        this.roomNumber = roomNumber;
        this.vendor = vendor;
        this.catalogDate = catalogDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public LocalDate getCatalogDate() {
        return catalogDate;
    }

    public void setCatalogDate(LocalDate catalogDate) {
        this.catalogDate = catalogDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(idProduct, product.idProduct) &&
                Objects.equals(name, product.name) &&
                Objects.equals(roomNumber, product.roomNumber) &&
                Objects.equals(vendor, product.vendor) &&
                Objects.equals(catalogDate, product.catalogDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProduct, name, roomNumber, vendor, catalogDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", idProduct='" + idProduct + '\'' +
                ", name='" + name + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", vendor=" + vendor +
                ", catalogDate=" + catalogDate +
                '}';
    }
}
