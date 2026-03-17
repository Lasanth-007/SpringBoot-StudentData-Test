package learn.student.student;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) //skip null fields in JSON
public record PatchStudentDto(
       // no @NotNull — null means "don't change school"
        String name,
        String email,
        Integer age,
        Long schoolId
) {
}
