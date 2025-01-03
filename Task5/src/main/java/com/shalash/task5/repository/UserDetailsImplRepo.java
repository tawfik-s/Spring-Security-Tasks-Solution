package com.shalash.task5.repository;

import com.shalash.task5.enitity.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDetailsImplRepo extends JpaRepository<UserDetailsImpl, Long> {

    Optional<UserDetailsImpl> findByEmail(String email);

}
