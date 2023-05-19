package com.example.auctionhouse.dto;

import com.example.auctionhouse.model.BidModel;
import com.example.auctionhouse.model.Status;
import com.example.auctionhouse.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class FullLot {
    @JsonView(View.Internal.class)
    private Long id;
    @JsonView(View.Internal.class)
    private Status status;
    @JsonView(View.Internal.class)
    private String title;
    @JsonView(View.Public.class)
    private String description;
    @JsonView(View.Public.class)
    private Integer startPrice;
    @JsonView(View.Public.class)
    private Integer bidPrice;
    @JsonView(View.Internal.class)
    private int currentPrice;
    @JsonView(View.Internal.class)
    private Bid lastBid;
}
