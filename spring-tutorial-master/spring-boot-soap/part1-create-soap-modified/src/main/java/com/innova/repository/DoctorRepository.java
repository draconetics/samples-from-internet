package com.innova.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.health.models.soap.hos.Doctor;


@Component
public class DoctorRepository {
    private static final Map<Integer, Doctor> emps = new HashMap<>();

    @PostConstruct
    public void init(){
        Doctor doctor1 = new Doctor();
        doctor1.setId(1);
        doctor1.setFirstname("Suzi");
        doctor1.setLastname("Beats");
        doctor1.setEmail("suzi@innova.com");
        doctor1.setJobtitle("Co-Founder");
        emps.put(doctor1.getId(), doctor1);
    }

    public Doctor findDoctor(int id){
        return emps.get(id);
    }
}
