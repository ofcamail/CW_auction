package com.example.auctionhouse.repository;

import com.example.auctionhouse.model.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<BidModel,Long> {
    @Query(value = "SELECT * FROM bid_model WHERE lot_model_id = ?1 ORDER BY bid_date LIMIT 1", nativeQuery = true)
    BidModel getFirstBidderInfo(Long lotId);

    @Query(value = "SELECT * FROM bid_model WHERE lot_model_id = ?1 ORDER BY bid_date DESC LIMIT 1", nativeQuery = true)
    BidModel getLastBidderInfo(Long lotId);

    @Query(value = "SELECT COUNT(s) FROM  bid_model s WHERE lot_model_id = ?1",nativeQuery = true)
    Integer getCountBidByLotId(Long lotId);
}