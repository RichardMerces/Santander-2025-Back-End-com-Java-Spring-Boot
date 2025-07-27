package dio.me.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dio.me.domain.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
