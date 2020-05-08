package hr.tvz.wauj.vjezbe.app.course;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findAllByStudentJmbag(String jmbag) {
        return courseRepository.findAllByStudents_Jmbag(jmbag).stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }
    
    
    private CourseDTO mapCourseToDTO(Course course){
        return new CourseDTO(course.getName(), course.getNumberOfECTS());
    }
}
