package com.travelfactory.catalog.service;

import com.travelfactory.catalog.model.Product;
import com.travelfactory.catalog.model.Vendor;
import com.travelfactory.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public boolean addProduct(Product product) {
        Product productAdded = productRepository.save(product);
        if(productAdded == null) {
            return false;
        }

        return true;
    }

    @Override
    public void addProducts(Iterable<Product> products) {
        productRepository.saveAll(products);
    }

    @Override
    public Product getProductByVendorAndDateAndIdProduct(Vendor vendor, LocalDate catalogDate, String idProduct) {
        return productRepository.findByVendorAndCatalogDateAndIdProduct(vendor, catalogDate, idProduct);
    }
}
