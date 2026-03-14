package learn.student.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchController {

    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<SchDto> saveSchool(
            @RequestBody SchDto dto
    ){
        var school = schoolService.saveSchool(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(school);
    }

    @GetMapping
    public ResponseEntity<List<SchDto>> findAllSchool(){
       return ResponseEntity.ok(schoolService.findAllSchool());
    }

    @DeleteMapping("/{id}")
    public void delete(
           @PathVariable("id") Long schoolId){
        schoolService.deleteSchool(schoolId);
        ResponseEntity.status(HttpStatus.GONE);
    }
}
