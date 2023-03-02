package com.pwgolf.golfStats.model.api;

import com.pwgolf.golfStats.model.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email) throws Exception;
}
