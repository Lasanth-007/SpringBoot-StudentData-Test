package learn.student.student;

import learn.student.school.SchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StuServices {
    private final StuRepository stuRepository;
    private final StuMapper stuMapper;
    private final SchRepository schRepository;

    public StuDto saveStudent(StuDto dto){
    var student = stuMapper.toStudentWithSchool(dto,schRepository);
    var savedStudent = stuRepository.save(student);
    return stuMapper.toDto(savedStudent);
}

    public void delete(Long id){
        stuRepository.deleteById(id);
    }

    public List<StuDto> findAllStudents(){
        List<Student> studentList = stuRepository.findAll();
        return stuMapper.toStuDtoList(studentList);
    }
}
