package com.shalash.task4;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsImplementationEntityRepository extends JpaRepository<UserDetailsImplementationEntity, Long> {

    UserDetailsImplementationEntity findByEmail(String email);

}
