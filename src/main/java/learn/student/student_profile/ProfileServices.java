package learn.student.student_profile;

import learn.student.student.StuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServices {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private final StuRepository stuRepository;

    public ProfileResponseDto addProfile(ProfileDto dto){
        StudentProfile profile =  profileRepository.save(profileMapper.toProfileWithStudent(dto,stuRepository));
        return profileMapper.toResponseD(profile);
    }

    public List<ProfileDto> getAllProfiles(){
       return profileMapper.toProfileDtoList(profileRepository.findAll());
    }


}
