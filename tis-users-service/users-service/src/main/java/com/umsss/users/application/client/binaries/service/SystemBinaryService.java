package com.umsss.users.application.client.binaries.service;

import com.umsss.users.application.client.binaries.model.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Santiago Mamani
 */
@Service
public class SystemBinaryService {

    @Autowired
    private SystemBinaryClient client;

    public Binary uploadBinary(MultipartFile multipartFile) {
        return client.uploadBinary(multipartFile);
    }
}
