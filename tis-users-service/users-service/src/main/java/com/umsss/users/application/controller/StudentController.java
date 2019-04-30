package com.umsss.users.application.controller;

import com.umsss.users.api.input.StudentInput;
import com.umsss.users.application.model.domain.Student;
import com.umsss.users.application.service.StudentCreateService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Santiago Mamani
 */

@Api(
        tags = "Rest-students-controller",
        description = "Operations over students"
)
@RequestMapping(value = Constants.BasePath.STUDENTS)
@RestController
@RequestScope
public class StudentController {

    @Autowired
    private StudentCreateService studentCreateService;

    @RequestMapping(method = RequestMethod.POST)
    public Student createStudent(@RequestBody StudentInput input) {
        studentCreateService.setInput(input);
        studentCreateService.execute();

        return studentCreateService.getStudent();
    }
}
