package dio.me.service;

import dio.me.domain.models.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
