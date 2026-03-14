package learn.student.student_profile;

import learn.student.student.StuRepository;
import learn.student.student.Student;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    StudentProfile toProfile(ProfileDto dto);

    @Mapping(target = "student",source = "studentId")
    default StudentProfile toProfileWithStudent(ProfileDto dto, @Context StuRepository stuRepository){
        StudentProfile studentProfile = toProfile(dto);

        if (dto.studentId()!=null){
            Student student = stuRepository.findById(dto.studentId())
                    .orElseThrow(()->new IllegalArgumentException("NOT FOUND STUDENT ID"+dto.studentId()));

            studentProfile.setStudent(student);
        }
        return studentProfile;
    }

    @Mapping(target = "studentId", source = "student.id")
    ProfileDto toDto (StudentProfile studentProfile);

    @Mapping(target = "studentId", source = "student.id")
    List<ProfileDto> toProfileDtoList(List<StudentProfile> studentProfiles);

    ProfileResponseDto toResponseD (StudentProfile studentProfile);
}
