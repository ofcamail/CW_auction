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

        FullLot dto = mapToLotDTO(lotModel, new FullLot());

        dto.setBidPrice(lotModel.getBidPrice());

        return dto;

    }

    private FullLot mapToLotDTO(LotModel lotModel, FullLot fullLot) {
        return null;
    }


    public BidModel mapFromBidDTO(Bid dto) {

        BidModel bidModel = new BidModel();

        bidModel.setBidDate(dto.getBidDate());

        bidModel.setBidderName(dto.getBidderName());

        return bidModel;

    }



    public Bid mapToBidDTO(BidModel bidModel) {

        Bid dto = new Bid();

        dto.setBidDate(bidModel.getBidDate());

        dto.setBidderName(bidModel.getBidderName());

        return dto;

    }



    public Lot mapToLotDTO(LotModel lotModel) {

        return mapToLotDTO(lotModel, new Lot());

    }



    private <T extends Lot> T mapToLotDTO(LotModel lotModel, T dto) {

        dto.setId(lotModel.getId());

        dto.setStatus(lotModel.getStatus());

        dto.setTitle(lotModel.getTitle());

        dto.setDescription(lotModel.getDescription());

        dto.setStartPrice(lotModel.getStartPrice());

        return dto;

    }



    public LotModel mapToLotModel(CreateLot dto) {

        LotModel lotModel = new LotModel();

        lotModel.setTitle(dto.getTitle());

        lotModel.setDescription(dto.getDescription());

        lotModel.setStartPrice(dto.getStartPrice());

        lotModel.setBidPrice(dto.getBidPrice());

        return lotModel;

    }



    public LotModel mapToLotModel(Lot dto) {

        LotModel lotModel = mapToLotModel(dto, new LotModel());

        lotModel.setId(dto.getId());

        lotModel.setStatus(dto.getStatus());

        lotModel.setBidPrice(dto.getBidPrice());

        return lotModel;

    }



    private <T extends LotModel> T mapToLotModel(Lot dto, T lotModel) {

        lotModel.setTitle(dto.getTitle());

        lotModel.setDescription(dto.getDescription());

        lotModel.setStartPrice(dto.getStartPrice());

        return lotModel;

    }

}