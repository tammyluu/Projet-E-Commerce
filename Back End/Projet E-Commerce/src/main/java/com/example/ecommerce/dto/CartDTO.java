package com.example.ecommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartDTO {

    private Long productId;
    private int quantity;

}
