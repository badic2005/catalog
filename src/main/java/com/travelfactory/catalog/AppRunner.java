package com.travelfactory.catalog;

import com.travelfactory.catalog.service.DirectoryMonitorService;
import org.springframework.boot.CommandLineRunner;

public class AppRunner implements CommandLineRunner {

    private final DirectoryMonitorService directoryMonitorService;

    public AppRunner(DirectoryMonitorService directoryMonitorService) {
        this.directoryMonitorService = directoryMonitorService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        directoryMonitorService.parseCSVFiles();
    }
}
