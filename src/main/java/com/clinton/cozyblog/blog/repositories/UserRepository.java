package com.clinton.cozyblog.blog.repositories;

import com.clinton.cozyblog.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
