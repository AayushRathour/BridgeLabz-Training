package com.employeepayroll.Dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    public DepartmentRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
