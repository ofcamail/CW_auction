package com.example.auctionhouse.service;

import com.example.auctionhouse.dto.Bid;
import com.example.auctionhouse.model.BidModel;
import com.example.auctionhouse.model.LotModel;
import com.example.auctionhouse.repository.BidRepository;
import com.example.auctionhouse.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class BidService {
    private final MappingUtils mappingUtils;
    private final BidRepository bidRepository;
    private final LotRepository lotRepository;

    @Autowired
    public BidService(MappingUtils mappingUtils, BidRepository bidRepository, LotRepository lotRepository) {
        this.mappingUtils = mappingUtils;
        this.bidRepository = bidRepository;
        this.lotRepository = lotRepository;
    }

    public Bid createBid(Long lotId, Bid bid) {
        BidModel bidModel = mappingUtils.mapFromBidDTO(bid);
        bidModel.setBidDate(LocalDateTime.now());
        bidModel.setLotModel(lotRepository.findById(lotId).orElse(null));
        bidRepository.save(bidModel);
        return mappingUtils.mapToBidDTO(bidModel);
    }

    public Bid getFirstBidderInfo(Long lotId) {
        return mappingUtils.mapToBidDTO(bidRepository.getFirstBidderInfo(lotId));
    }

    public Bid getLastBidderInfo(Long lotId) {
        return mappingUtils.mapToBidDTO(bidRepository.getLastBidderInfo(lotId));
    }

    public Integer getCountBidByLotId(Long lotId) {
        return bidRepository.getCountBidByLotId(lotId);
    }
}