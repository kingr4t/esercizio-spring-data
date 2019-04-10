package it.thinkopen.restservices;

import it.thinkopen.restservices.model.Student;
import it.thinkopen.restservices.repository.StudentCustomRepository;
import it.thinkopen.restservices.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TestController {

    private final StudentCustomRepository studentCustomRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public TestController(StudentCustomRepository studentCustomRepository, StudentRepository studentRepository) {
        this.studentCustomRepository = studentCustomRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/test")
    Collection<Student> getStudents() {
        return studentCustomRepository.getStudentsByName("Francesco", "Arciello");
    }

    @RequestMapping("/test2")
    Collection<Student> getStudents2() {
        return studentRepository.finder("Francesco");
    }

    @RequestMapping("/test3")
    Collection<Student> getStudents3() {
        return studentRepository.finderCF("RCLFNC83A26H703I");
    }

    @RequestMapping("/test4")
    Collection<Student> getStudents4() {
        return studentRepository.finderCF2("RCLFNC83A26H703I");
    }


}
