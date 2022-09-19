package com.backend.birdmeal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyOrderResponseDto {

    private Long orderSeq;
    private Long userSeq;
    private int orderPrice;
    private LocalDateTime orderDate;
    private String orderFirstName;
    private Long orderCnt;
    private String productThumbnailImg;

}
