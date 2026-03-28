package com.week2.mvc.mvc.advice;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

//    @Pattern(regexp = "hh:mm:ss | dd-MM-yyyy]")
    private LocalDateTime timestamp;
    private T data;
    private ApiError apiError;

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }
    public ApiResponse(T data) {
        this();
        this.data = data;
    }
    public ApiResponse(ApiError apiError) {
        this();
        this.apiError = apiError;
    }
}
