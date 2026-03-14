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

}
