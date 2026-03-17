package learn.student.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StuController {

    private final StuServices stuServices;

    @PostMapping
    public ResponseEntity<StuDto> saveStudent(
           @RequestBody StuDto dto){
        var savedStudent = stuServices.saveStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @DeleteMapping("/{id}")
    public void DeletebyId(
            @PathVariable("id") Long stId
    ){
        stuServices.delete(stId);
    }

    @GetMapping
    public ResponseEntity<List<StuDto>> findAllStudents(){
         List<StuDto> stuDtoList = stuServices.findAllStudents();
         return ResponseEntity.ok(stuDtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StuDto> updateStudent(
            @PathVariable Long id,
            @RequestBody StuDto stuDto
    ){
       return ResponseEntity.status(HttpStatus.ACCEPTED)
               .body(stuServices.updateStudent(id,stuDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StuDto> patchUpdate(
            @PathVariable Long id,
            @RequestBody PatchStudentDto dto
    ){
       return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(stuServices.patchStudent(id,dto));
    }
}
