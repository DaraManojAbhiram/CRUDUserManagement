package com.crud.backend.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class UserDto {
    private int id;

    @NotNull
    private String fullName;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Phone number should start with 6-9 and contain exactly 10 digits")
    private String phoneNumber;
}
