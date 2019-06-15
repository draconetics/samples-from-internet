package com.innova.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.health.models.soap.hos.GetDoctorRequest;
import com.health.models.soap.hos.GetDoctorResponse;
import com.innova.repository.DoctorRepository;

/**
 * Created by Mario Flores
 */

public class DoctorEndpoint {
    private static final String NAMESPACE_URI = "http://health.com/models/soap/hos";

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorEndpoint(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDoctorRequest")
    @ResponsePayload
    public GetDoctorResponse getDoctor(@RequestPayload GetDoctorRequest request) {
        GetDoctorResponse response = new GetDoctorResponse();
        System.out.println("finding doctor..");
        response.setDoctor(doctorRepository.findDoctor(request.getId()));

        return response;
    }
}
