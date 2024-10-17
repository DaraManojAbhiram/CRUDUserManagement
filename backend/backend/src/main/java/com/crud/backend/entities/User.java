package com.crud.backend.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String fullName;

    @Column
    @Email(message = "Email should be valid")
    private String email;

    @Column
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Phone number should start with 6-9 and contain exactly 10 digits")
    private String phoneNumber;

}
