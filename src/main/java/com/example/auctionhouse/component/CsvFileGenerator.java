package com.example.auctionhouse.component;

import com.example.auctionhouse.dto.FullLot;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Component
public class CsvFileGenerator {
    public void exportLotsToCsv(List<FullLot> fullLots, Writer writer) {
        try {
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
            for (FullLot fullLot : fullLots) {
                if (fullLot.getLastBid() != null) {
                    printer.printRecord(fullLot.getId(), fullLot.getTitle(), fullLot.getStatus(),
                            fullLot.getLastBid().getBidderName(), fullLot.getCurrentPrice());
                } else {
                    printer.printRecord(fullLot.getId(), fullLot.getTitle(), fullLot.getStatus(),"Lots not found", fullLot.getCurrentPrice());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}