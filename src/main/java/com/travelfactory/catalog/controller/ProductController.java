package com.travelfactory.catalog.controller;

import com.travelfactory.catalog.dto.ProductDto;
import com.travelfactory.catalog.model.Product;
import com.travelfactory.catalog.model.Vendor;
import com.travelfactory.catalog.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/catalog")
public class ProductController {

    @Autowired
    private IProductService productService;

    private DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

//    @PostMapping
//    public boolean addProduct(@RequestBody ProductDto productDto) {
//
//        Vendor vendor = new Vendor(productDto.getVendor());
//        Product product = new Product(
//                productDto.getId(),
//                productDto.getName(),
//                productDto.getRoomNumber(),
//                vendor,
//                productDto.getCatalogDate());
//
//        return productService.addProduct(product);
//    }

    @GetMapping("/{vendorName}/{catalogDate}/{idProduct}")
    public ProductDto getProductByVendorAndDateAndId(@PathVariable String vendorName,
                                                     @PathVariable String catalogDate,
                                                     @PathVariable String idProduct) {

        Vendor vendor = new Vendor(vendorName);
        LocalDate dateResult = LocalDate.parse(catalogDate, FORMATTER);

        Product product =  productService.getProductByVendorAndDateAndIdProduct(vendor, dateResult, idProduct);

        ProductDto productDto = ProductDto
                .builder()
                .id(product.getIdProduct())
                .name(product.getName())
                .roomNumber(product.getRoomNumber())
                .build();

        return productDto;

    }



}
