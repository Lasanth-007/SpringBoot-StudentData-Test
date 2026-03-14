package learn.student.student;

import learn.student.school.SchRepository;
import learn.student.school.School;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SchRepository.class})
public interface StuMapper {


    Student toStudent (StuDto dto);

    @Mapping(target = "school",source = "schoolId")
    default Student toStudentWithSchool(StuDto dto, @Context SchRepository schRepository){
        System.out.println("Incoming school id: "+dto.schoolId());
        Student student = toStudent(dto);

        if (dto.schoolId()!=null){
            School school = schRepository.findById(dto.schoolId())
                    .orElseThrow(()-> new IllegalArgumentException("School not found: "+ dto.schoolId()));
            student.setSchool(school);
        }
        return student;
    }

    @Mapping(target = "schoolId", source = "school.id")  // ← this line does the magic
    StuDto toDto(Student student);

    @Mapping(target = "schoolId", source = "school.id")
    List<StuDto> toStuDtoList(List<Student> studentList);
}
