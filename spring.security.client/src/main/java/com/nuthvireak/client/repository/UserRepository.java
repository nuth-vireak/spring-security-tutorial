package com.nuthvireak.client.repository;

import com.nuthvireak.client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
