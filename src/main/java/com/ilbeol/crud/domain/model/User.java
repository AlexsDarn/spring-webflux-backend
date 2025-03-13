package com.ilbeol.crud.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(schema = "public", name = "users")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
