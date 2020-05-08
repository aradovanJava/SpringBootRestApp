package hr.tvz.wauj.vjezbe.app.student;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Profile("test")
@Repository
class AnotherMockStudentRepository implements StudentRepository {

    @Override
    public Set<Student> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Student> findByJMBAG(String JMBAG) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Student> save(Student student) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Student> update(String JMBAG, Student updatedStudent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteByJMBAG(String JMBAG) {
        throw new UnsupportedOperationException();
    }
}
