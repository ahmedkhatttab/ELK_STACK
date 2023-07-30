package com.example.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PassportDto {

    private Long id;

    private String passportNumber;

    private String fullName;

    private LocalDateTime dob;
}
