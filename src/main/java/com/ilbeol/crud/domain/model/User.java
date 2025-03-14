package com.ilbeol.crud.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@Table(schema = "public", name = "users")
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private BigInteger rut;
    private String dv;
    private LocalDate birthDate;
    private String emailAddress;
    private String password;
}
