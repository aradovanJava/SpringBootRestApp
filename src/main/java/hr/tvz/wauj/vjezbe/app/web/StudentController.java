package hr.tvz.wauj.vjezbe.app.web;

import hr.tvz.wauj.vjezbe.app.student.StudentCommand;
import hr.tvz.wauj.vjezbe.app.student.StudentDTO;
import hr.tvz.wauj.vjezbe.app.student.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }
    
    @GetMapping("/{JMBAG}")
    public ResponseEntity<StudentDTO> getStudentByJMBAG(@PathVariable final String JMBAG){
        return studentService.findByJMBAG(JMBAG)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }
    
    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody final StudentCommand command){
        return studentService.save(command)
                .map(
                        studentDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(studentDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }
    
    @PutMapping("/{JMBAG}")
    public ResponseEntity<StudentDTO> update(@PathVariable String JMBAG, @Valid @RequestBody final StudentCommand updateStudentCommand){
        return studentService.update(JMBAG, updateStudentCommand)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{JMBAG}")
    public void delete(@PathVariable String JMBAG){
        studentService.deleteByJMBAG(JMBAG);
    }
    
}
