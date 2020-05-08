package hr.tvz.wauj.vjezbe.app.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class StudentServiceImpl implements StudentService {

    private static final int YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED = 26;
    
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> findByJMBAG(final String JMBAG) {
        return studentRepository.findByJMBAG(JMBAG).map(this::mapStudentToDTO);
    }

    @Override
    public Optional<StudentDTO> save(final StudentCommand studentCommand) {
        return studentRepository.save(mapCommandToStudent(studentCommand)).map(this::mapStudentToDTO);
    }

    @Override
    public Optional<StudentDTO> update(final String JMBAG, final StudentCommand updatedStudentCommand) {
        return studentRepository.update(JMBAG, mapCommandToStudent(updatedStudentCommand)).map(this::mapStudentToDTO);
    }

    @Override
    public void deleteByJMBAG(final String JMBAG) {
        studentRepository.deleteByJMBAG(JMBAG);
    }

    private Student mapCommandToStudent(final StudentCommand studentCommand) {
        return new Student(studentCommand.getFirstName(), studentCommand.getLastName(), studentCommand.getJmbag(), studentCommand.getDateOfBirth(), studentCommand.getNumberOfECTS());
    }
    
    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(student.getJmbag(), student.getNumberOfECTS(), shouldTuitionBePayed(student.getDateOfBirth()));
    }
    
    private boolean shouldTuitionBePayed(LocalDate dateOfBirth){
        return dateOfBirth.plusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED).isBefore(LocalDate.now());
    }
}
