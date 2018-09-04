package com.travelfactory.catalog.service;

import com.travelfactory.catalog.model.Product;
import com.travelfactory.catalog.model.Vendor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderService {

    private DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public List<Product> readFile(File file) {

        int firstSplitter = file.getName().indexOf("-");
        int secondSplitter = file.getName().indexOf(".csv");
        String vendorName = file.getName().substring(0, firstSplitter);
        LocalDate catalogDate = LocalDate.parse(file.getName().substring(firstSplitter+1, secondSplitter), FORMATTER);

        List<Product> listProducts = new ArrayList<>();

        try (
                Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {

            int counter = 0;
            for (CSVRecord csvRecord : csvParser) {

                if(counter++ == 0) {
                    continue;
                }
                // Accessing Values by Column Index
                String IdProduct = csvRecord.get(0);
                String Name = csvRecord.get(1);
                String RoomNumber = csvRecord.get(2);

                listProducts.add(new Product(IdProduct, Name, RoomNumber, new Vendor(vendorName), catalogDate));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listProducts;

    }
}
