package com.travelfactory.catalog.service;

import com.travelfactory.catalog.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DirectoryMonitorService {

    @Autowired
    private CSVReaderService csvReaderService;

    @Autowired
    private IProductService productService;

    @Value("${pathCSV}")
    private String pathCSV;

    @Async
    public void parseCSVFiles() {


        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            File folder = new File(pathCSV);
            File[] listOfFiles = folder.listFiles();

            List<Product> listProducts = new ArrayList<>();

            if(listOfFiles.length > 0) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {

                        try {
                            listProducts = csvReaderService.readFile(file);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        productService.addProducts(listProducts);
                    }

                    file.delete();
                }

            }
        }
    }

}
