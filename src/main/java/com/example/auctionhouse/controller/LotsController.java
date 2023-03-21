package com.example.auctionhouse.controller;

import com.example.auctionhouse.dto.*;
import com.example.auctionhouse.model.LotModel;
import com.example.auctionhouse.model.Status;
import com.example.auctionhouse.service.BidService;
import com.example.auctionhouse.service.LotService;
import com.example.auctionhouse.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.Collection;

@RestController
@RequestMapping(name = "lot")
public class LotsController {
    private final LotService lotService;
    private final BidService bidService;

    public LotsController(LotService lotService, BidService bidService) {
        this.lotService = lotService;
        this.bidService = bidService;
    }

    @PostMapping()
    public ResponseEntity<Lot> createLot(@RequestBody CreateLot createLot) {
        return ResponseEntity.ok(lotService.createLot(createLot));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findFullLot(@PathVariable Long id) {
        FullLot fullLot = lotService.findFullLot(id);
        if (fullLot == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Лот не найден");
        }
        return ResponseEntity.ok(fullLot);
    }

    @GetMapping()
    public ResponseEntity<Collection<Lot>> findLotModelsByStatus(Pageable pageable, @RequestParam Status status) {
        return ResponseEntity.ok(lotService.findLotModelsByStatus(pageable, status));
    }

    @PostMapping("/{id}/start")
    public ResponseEntity<String> startAuction(@PathVariable Long id) {
        FullLot fullLot = lotService.findFullLot(id);
        if (fullLot == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Лот не найден");
        }
        if (fullLot.getStatus().equals(Status.STARTED)) {
            return ResponseEntity.ok().build();
        }
        lotService.startAuction(id);
        return ResponseEntity.ok("Лот переведен в статус начато");
    }

    @PostMapping("/{id}/stop")
    public ResponseEntity<String> stopAuction(@PathVariable Long id) {
        FullLot fullLot = lotService.findFullLot(id);
        if (fullLot == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Лот не найден");
        }
        if (fullLot.getStatus().equals(Status.STOPPED)) {
            return ResponseEntity.ok().build();
        }
        lotService.stopAuction(id);
        return ResponseEntity.ok("Лот переведен в статус остановлен");
    }

    @JsonView(View.Internal.class)
    @PostMapping("/{id}/bid")
    public ResponseEntity<?> createBid(@PathVariable Long id, @RequestBody Bid bid) {
        LotModel lot = lotService.getLotModel(id);
        if (lot == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Лот не найден");
        }
        if (lot.getStatus().equals(Status.CREATED) ||
                lot.getStatus().equals(Status.STOPPED)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Лот в неверном статусе");
        }
        return ResponseEntity.ok(bidService.createBid(id, bid));
    }

    @GetMapping("/{id}/first")
    public ResponseEntity<?> getFirstBidderInfo(@PathVariable Long id) {
        FullLot fullLot = lotService.findFullLot(id);
        if (fullLot == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Лот не найден");
        }
        return ResponseEntity.ok(bidService.getFirstBidderInfo(id));
    }
}