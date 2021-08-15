package solux.woodong.web.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solux.woodong.web.domain.user.User;
import solux.woodong.web.domain.user.UserRepository;
import solux.woodong.web.dto.user.UserSaveDto;
import solux.woodong.web.dto.user.UserUpdateDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveDto saveDto) {
        return userRepository.save(saveDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 유저 없음"));
        user.update(userUpdateDto.getName());
        return id;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
