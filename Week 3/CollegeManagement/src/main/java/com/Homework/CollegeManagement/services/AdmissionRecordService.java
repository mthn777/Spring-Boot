package com.Homework.CollegeManagement.services;

import com.Homework.CollegeManagement.Repositories.AdmissionRecordRepository;
import com.Homework.CollegeManagement.entities.AdmissionRecord;
import com.Homework.CollegeManagement.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmissionRecordService {

    @Autowired
    private AdmissionRecordRepository admissionRecordRepository;



    @Transactional
    public void createAdmissionRecord(AdmissionRecord admissionRecord){
        admissionRecordRepository.save(admissionRecord);
    }


    @Transactional
    public void assignStudentToAdmissionRecord(Student student, Long admissionRecordId){

        AdmissionRecord admissionRecord = admissionRecordRepository.findById(admissionRecordId).orElseThrow();

        admissionRecord.setStudent(student);

        student.setAdmissionRecord(admissionRecord);

    }


}
