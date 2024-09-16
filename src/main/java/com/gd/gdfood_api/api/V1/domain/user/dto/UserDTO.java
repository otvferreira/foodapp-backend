package com.gd.gdfood_api.api.V1.domain.user.dto;

import java.util.UUID;

public record UserDTO(String name, String email, String password, String image, String phoneNumber, Long restaurant) {
}
