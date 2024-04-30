package com.example.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDTO {

    private Long consumerId;
    private LocalDateTime dateOrder;


}
