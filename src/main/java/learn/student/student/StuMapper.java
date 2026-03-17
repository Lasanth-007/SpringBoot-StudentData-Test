package learn.student.student;

import learn.student.school.SchRepository;
import learn.student.school.School;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SchRepository.class})
public interface StuMapper {

    @Mapping(target = "school",ignore = true)
    Student toStudent (StuDto dto);


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


    @Mapping(target = "school", ignore = true)
    void updateStudentFromDto(
            StuDto dto,
            @MappingTarget Student entity
    );

    default void updateStudentWithSchool(
            StuDto dto,
            @MappingTarget Student entity,
            @Context SchRepository schRepository

    ){
        updateStudentFromDto(dto,entity);

        if(dto.schoolId()!=null){
            School school = schRepository.findById(dto.schoolId())
                    .orElseThrow(()->new IllegalArgumentException("School not found: " + dto.schoolId()));
            entity.setSchool(school);
        }else {
            entity.setSchool(null);
        }
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromPatch(
            PatchStudentDto dto,
            @MappingTarget Student entity
    );

    default void patchStudentWithSchool(
            PatchStudentDto dto,
            @MappingTarget Student entity,
            @Context SchRepository schRepository
    ){
        updateFromPatch(dto,entity);

        if(dto.schoolId()!=null){
            School school = schRepository.findById(dto.schoolId())
                    .orElseThrow(() -> new IllegalArgumentException("School not found"));
            entity.setSchool(school);
        }
        // if patchDto.schoolId() == null → keep current school (don't null it out)
    }


}
