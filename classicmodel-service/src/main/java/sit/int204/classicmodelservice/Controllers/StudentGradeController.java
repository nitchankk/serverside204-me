package sit.int204.classicmodelservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.classicmodelservice.Service.StudentGradeService;
import sit.int204.classicmodelservice.models.Student;

@RestController
@RequestMapping("/api/student-grades")
public class StudentGradeController {
    @Autowired
    private StudentGradeService service;
    @GetMapping("")
    public Student getGrade(@RequestBody Student student) {
        return service.getGrade(student);
    }
}
