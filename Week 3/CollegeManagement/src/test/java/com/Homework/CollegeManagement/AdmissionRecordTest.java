package com.Homework.CollegeManagement;

import com.Homework.CollegeManagement.Repositories.StudentRepository;
import com.Homework.CollegeManagement.entities.AdmissionRecord;
import com.Homework.CollegeManagement.entities.Student;
import com.Homework.CollegeManagement.entities.type.AdmissionStatus;
import com.Homework.CollegeManagement.entities.type.Gender;
import com.Homework.CollegeManagement.services.AdmissionRecordService;
import com.Homework.CollegeManagement.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AdmissionRecordTest {

    @Autowired
    private AdmissionRecordService admissionRecordService;

    @Autowired
    private StudentService studentService;

    AdmissionRecord admissionRecord = AdmissionRecord.builder()
            .admissionStatus(AdmissionStatus.PENDING)
            .fees(34000)
            .admissionDate(LocalDate.of(2024, 05, 21))
            .build();



    @Test
    public void testAssignStudentToAdmissionRecord(){

        admissionRecordService.assignStudentToAdmissionRecord(Student.builder().build(), 1L);

    }

}
