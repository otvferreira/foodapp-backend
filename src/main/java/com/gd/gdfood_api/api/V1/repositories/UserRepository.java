package com.gd.gdfood_api.api.V1.repositories;

import com.gd.gdfood_api.api.V1.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    Optional<User> findByRestaurant(Long id);

}
