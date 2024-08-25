package com.belajar.ecommerce.dto;

import java.util.*;

public class ResponseData<T> {
    private Boolean status;
    private List<String> messages= new ArrayList<>();
    private T data;


}
