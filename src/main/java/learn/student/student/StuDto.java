package learn.student.student;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StuDto(
    String name,
    String email,
    int age,
    @JsonProperty("schoolId")
    Long schoolId
) {
}
