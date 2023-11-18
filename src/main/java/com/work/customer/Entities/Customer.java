package com.work.customer.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long cid;

    @Column(length = 50)
    private String name;

    @NotNull
    @Column(length = 200)
    private String email;
    private String password;

    @Max(120)
    @Min(0)
    private Integer age;
}
