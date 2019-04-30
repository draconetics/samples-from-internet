package com.umsss.users.application.client.binaries.service;

import com.umsss.users.application.client.Constants;
import com.umsss.users.application.client.binaries.model.Binary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Santiago Mamani
 */
@FeignClient(name = Constants.BINARIES_SERVICE_NAME)
interface SystemBinaryClient {

    @RequestMapping(
            value = "/system/binaries",
            method = RequestMethod.POST,
            consumes = "multipart/form-data"
    )
    Binary uploadBinary(@PathVariable(value = "multipartFile") MultipartFile file);
}
