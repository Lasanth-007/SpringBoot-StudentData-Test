package learn.student.student_profile;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileServices profileServices;

    @PostMapping
    public ResponseEntity<ProfileResponseDto> addProfile(
           @RequestBody ProfileDto dto){
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(profileServices.addProfile(dto));
    }
    @GetMapping
    public ResponseEntity<List<ProfileDto>> getAllProfile(){
      return ResponseEntity.ok(profileServices.getAllProfiles());
    }
}
