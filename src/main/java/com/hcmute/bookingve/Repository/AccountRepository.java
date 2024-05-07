package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("SELECT ac FROM Account ac WHERE ac.Username = :username AND ac.Password = :password")
    Account findUserById(String username, String password);
}