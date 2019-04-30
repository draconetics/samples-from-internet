package com.umsss.users.application.controller;

import com.umsss.users.api.input.TeacherInput;
import com.umsss.users.application.model.domain.Teacher;
import com.umsss.users.application.service.TeacherCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Santiago Mamani
 */

@RequestMapping(value = Constants.BasePath.TEACHERS)
@RestController
@RequestScope
public class TeacherController {

    @Autowired
    private TeacherCreateService teacherCreateService;

    @RequestMapping(method = RequestMethod.POST)
    public Teacher createTeacher(@RequestBody TeacherInput input) {
        teacherCreateService.setInput(input);
        teacherCreateService.execute();

        return teacherCreateService.getTeacher();
    }
}
