package com.example.auctionhouse.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class BidModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bidderName;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime bidDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private LotModel lotModel;
}