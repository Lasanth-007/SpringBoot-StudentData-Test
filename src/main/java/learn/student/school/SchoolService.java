package learn.student.school;

import learn.student.student.StuDto;
import learn.student.student.StuRepository;
import learn.student.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchMapper schMapper;
    private final SchRepository schRepository;

    public SchDto saveSchool(SchDto dto){
        var school = schMapper.dtoToSchool(dto);
        var savedSchool = schRepository.save(school);
        return schMapper.toSchoolDTO(savedSchool);
    }

    public List<SchDto> findAllSchool(){
        List<School> schoolList = schRepository.findAll();
        return schMapper.toSchoolDtoList(schoolList);
    }

    public void deleteSchool(Long id){
        schRepository.deleteById(id);
    }

}
