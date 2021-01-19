package learn.laitech.java.salman.exercise.login.repository;

import learn.laitech.java.salman.exercise.login.domain.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String Username);
}
