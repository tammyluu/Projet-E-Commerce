package com.example.ecommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class OrderDTO {

    private Long consumerId;
    private LocalDateTime dateOrder;
}
