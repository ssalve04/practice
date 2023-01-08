package net.exceptionhandler.exceptionhandlerdemo.repository;

import net.exceptionhandler.exceptionhandlerdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByid(Integer userId);
}
