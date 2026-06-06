package com.week4.devTools.advice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ApiError {

    private LocalDateTime date;
    private String message;
    private HttpStatus httpStatus;

}
