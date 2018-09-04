package com.travelfactory.catalog.repository;

import com.travelfactory.catalog.model.Product;
import com.travelfactory.catalog.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;

public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByVendorAndCatalogDateAndIdProduct(Vendor vendor, LocalDate date, String idProduct);
}
