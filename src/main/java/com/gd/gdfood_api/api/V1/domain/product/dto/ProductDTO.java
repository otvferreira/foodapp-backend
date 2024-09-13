package com.gd.gdfood_api.api.V1.domain.product.dto;

import java.math.BigDecimal;

public record ProductDTO(String name, String description, /*BigDecimal value,*/ Long restaurantId, String image) {
}
