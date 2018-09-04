package com.travelfactory.catalog.service;

import com.travelfactory.catalog.model.Product;
import com.travelfactory.catalog.model.Vendor;

import java.time.LocalDate;

public interface IProductService {
    boolean addProduct(Product product);

    void addProducts(Iterable<Product> products);

    Product getProductByVendorAndDateAndIdProduct(Vendor vendor, LocalDate catalogDate, String idProduct);
}
