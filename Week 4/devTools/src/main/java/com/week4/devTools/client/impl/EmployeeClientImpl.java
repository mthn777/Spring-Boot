package com.week4.devTools.client.impl;

import com.week4.devTools.advice.ApiResponse;
import com.week4.devTools.client.EmployeeClient;
import com.week4.devTools.dto.EmployeeDTO;
import com.week4.devTools.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.sql.SQLOutput;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try {
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient
                    .get()
                    .uri("/employee")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOList.getData();
        } catch (Exception e){
            throw new RuntimeException(e);
        }


    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        ApiResponse<EmployeeDTO> employeeDTO = restClient
                .get()
                .uri("/employee/{empid}", employeeId)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        return employeeDTO.getData();
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        try{
            ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTO1 = restClient
                    .post()
                    .uri("/employeee")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        System.out.println(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not create new employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>(){
                    });
            return employeeDTO1.getBody().getData();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }


}
