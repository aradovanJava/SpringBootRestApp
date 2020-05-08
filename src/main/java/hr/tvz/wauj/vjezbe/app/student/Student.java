package hr.tvz.wauj.vjezbe.app.student;

import hr.tvz.wauj.vjezbe.app.course.Course;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String jmbag;
    private LocalDate dateOfBirth;
    
    @Column(name = "ects_points")
    private Integer numberOfECTS;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private List<Course> courses;
    
    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String jmbag, LocalDate dateOfBirth, Integer numberOfECTS) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.dateOfBirth = dateOfBirth;
        this.numberOfECTS = numberOfECTS;
    }

    public Student(String firstName, String lastName, String jmbag, LocalDate dateOfBirth, Integer numberOfECTS) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.dateOfBirth = dateOfBirth;
        this.numberOfECTS = numberOfECTS;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJmbag() {
        return jmbag;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return jmbag.equals(student.jmbag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jmbag);
    }
}
