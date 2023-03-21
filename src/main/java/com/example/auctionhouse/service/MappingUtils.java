package com.example.auctionhouse.service;

import com.example.auctionhouse.dto.Bid;
import com.example.auctionhouse.dto.CreateLot;
import com.example.auctionhouse.dto.FullLot;
import com.example.auctionhouse.dto.Lot;
import com.example.auctionhouse.model.BidModel;
import com.example.auctionhouse.model.LotModel;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {
    public FullLot mapToFullLotDTO(LotModel lotModel) {
        FullLot dto = new FullLot();
        dto.setId(lotModel.getId());
        dto.setStatus(lotModel.getStatus());
        dto.setTitle(lotModel.getTitle());
        dto.setDescription(lotModel.getDescription());
        dto.setStartPrice(lotModel.getStartPrice());
        dto.setBidPrice(lotModel.getBidPrice());
        return dto;
    }

    public BidModel mapFromBidDTO(Bid dto) {
        BidModel bid = new BidModel();
        bid.setBidDate(dto.getBidDate());
        bid.setBidderName(dto.getBidderName());
        return bid;
    }

    public Bid mapToBidDTO(BidModel bid) {
        Bid dto = new Bid();
        dto.setId(bid.getId());
        dto.setBidDate(bid.getBidDate());
        dto.setBidderName(bid.getBidderName());
        return dto;
    }

    public Lot mapToLotDTO(LotModel lotModel) {
        Lot dto = new Lot();
        dto.setId(lotModel.getId());
        dto.setStatus(lotModel.getStatus());
        dto.setTitle(lotModel.getTitle());
        dto.setDescription(lotModel.getDescription());
        dto.setStartPrice(lotModel.getStartPrice());
        dto.setBidPrice(lotModel.getBidPrice());
        return dto;
    }

    public LotModel mapFromCreateLotDTO(CreateLot dto) {
        LotModel lotModel = new LotModel();
        lotModel.setTitle(dto.getTitle());
        lotModel.setDescription(dto.getDescription());
        lotModel.setStartPrice(dto.getStartPrice());
        lotModel.setBidPrice(dto.getBidPrice());
        return lotModel;
    }

    public LotModel mapFromFullLotDTO(FullLot dto) {
        LotModel lotModel = new LotModel();
        lotModel.setId(dto.getId());
        lotModel.setStatus(dto.getStatus());
        lotModel.setTitle(dto.getTitle());
        lotModel.setDescription(dto.getDescription());
        lotModel.setStartPrice(dto.getStartPrice());
        lotModel.setBidPrice(dto.getBidPrice());
        return lotModel;
    }
}