package learn.student.school;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchMapper {

    SchDto toSchoolDTO(School school);
    School dtoToSchool (SchDto dto);
    List<SchDto> toSchoolDtoList (List<School> schoolList);
}
