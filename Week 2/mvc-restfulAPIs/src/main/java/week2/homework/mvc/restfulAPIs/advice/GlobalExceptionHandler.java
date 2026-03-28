package week2.homework.mvc.restfulAPIs.advice;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import week2.homework.mvc.restfulAPIs.exception.ResourseNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourseNotFoundException exception){
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalException(Exception exception){
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<?>> handlePrimeNumberException(ConstraintViolationException exception){
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .httpStatus(HttpStatus.NOT_ACCEPTABLE)
                .build();
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();

        ApiError apiError = ApiError.builder()
                .message("Invalid Inputs")
                .httpStatus(HttpStatus.BAD_REQUEST)
                .subErrors(errors)
                .build();

        return buildResponseEntity(apiError);
    }

    public ResponseEntity<ApiResponse<?>> buildResponseEntity(ApiError apiError){
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getHttpStatus());
    }

}
