package dio.me.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dio.me.domain.models.User;
import dio.me.domain.repository.UserRepository;
import dio.me.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
    // public User create(User userToCreate) {
    //     if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
    //         throw new IllegalArgumentException("This User ID already exists.");
    //     }
    //     return null;
    // }

}
