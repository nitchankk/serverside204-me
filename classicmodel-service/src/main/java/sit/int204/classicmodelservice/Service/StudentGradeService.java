package sit.int204.classicmodelservice.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelservice.models.Student;

@Service
public class StudentGradeService {
    public Student getGrade(Student student) {
        if(student.getScore()==null || student.getScore()>100 || student.getScore()<0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Invalid score !!! (" + student.getScore() + ") !!!");

        }
        return student.calculateGrade();

            }
        }
