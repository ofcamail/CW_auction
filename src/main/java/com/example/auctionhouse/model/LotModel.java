package com.example.auctionhouse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class LotModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String title;
    private String description;
    private Integer startPrice;
    private Integer bidPrice;
    @OneToMany(mappedBy = "lotModel")
    private List<BidModel> bidModels;
}