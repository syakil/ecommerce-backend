package com.belajar.ecommerce.dto;

import lombok.Data;

import java.util.*;

@Data
public class ResponseData<T> {
    private Boolean status;
    private List<String> messages= new ArrayList<>();
    private T data;
}
