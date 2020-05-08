package hr.tvz.wauj.vjezbe.app.student;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Profile("dev")
@Repository
class MockStudentRepository implements StudentRepository {

    private final Set<Student> MOCKED_STUDENTS = new HashSet<>(
            Arrays.asList(
                    new Student(1L, "Ivo", "Ivić", "0256423323", LocalDate.now().minusYears(27), 120),
                    new Student(2L, "Lucija", "Lucić", "0256423324", LocalDate.now().minusYears(25), 98)
            )
    );
    
    @Override
    public Set<Student> findAll() {
        return MOCKED_STUDENTS;
    }

    @Override
    public Optional<Student> findByJMBAG(final String JMBAG) {
        return MOCKED_STUDENTS.stream().filter(it -> Objects.equals(it.getJmbag(), JMBAG)).findAny();
    }

    @Override
    public Optional<Student> save(final Student student) {
        if(!MOCKED_STUDENTS.contains(student)){
            MOCKED_STUDENTS.add(student);
            return Optional.of(student);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Student> update(final String JMBAG, final Student updatedStudent) {
        boolean exists = MOCKED_STUDENTS.removeIf(
                it -> Objects.equals(it.getJmbag(), JMBAG) && Objects.equals(it.getJmbag(), updatedStudent.getJmbag())
        );
        
        if(exists){
            MOCKED_STUDENTS.add(updatedStudent);
            return Optional.of(updatedStudent);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByJMBAG(final String JMBAG) {
        MOCKED_STUDENTS.removeIf(it -> Objects.equals(it.getJmbag(), JMBAG));
    }
}
