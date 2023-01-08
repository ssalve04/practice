package net.validation.validation_demo.repository;

import net.validation.validation_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int userId);
}
