package com.example.auctionhouse.projection;

import java.time.LocalDateTime;

public interface BidView {
    String getBidderName();

    LocalDateTime getBidDate();
}