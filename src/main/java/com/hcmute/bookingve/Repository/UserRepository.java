package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query ("SELECT us FROM User us WHERE us.UserId = :id")
    User findUserByUserId(int id);
}
