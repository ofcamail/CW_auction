package com.example.auctionhouse.repository;

import com.example.auctionhouse.model.LotModel;
import com.example.auctionhouse.model.Status;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface LotRepository extends PagingAndSortingRepository<LotModel,Long> {
    List<LotModel> findLotModelsByStatus(Pageable pageable, Status status);
    List<LotModel> findBy();
}