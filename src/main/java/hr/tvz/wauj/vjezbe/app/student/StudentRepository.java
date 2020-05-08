package hr.tvz.wauj.vjezbe.app.student;

import java.util.Optional;
import java.util.Set;

interface StudentRepository {
    
    Set<Student> findAll();
    
    Optional<Student> findByJMBAG(String JMBAG);
    
    Optional<Student> save(Student student);
    
    Optional<Student> update(String JMBAG, Student updatedStudent);
    
    void deleteByJMBAG(String JMBAG);
}
