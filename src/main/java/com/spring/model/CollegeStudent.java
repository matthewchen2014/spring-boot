package com.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class CollegeStudent {
    @NonNull
    private Integer id;
    private String name;
    private char gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
}
