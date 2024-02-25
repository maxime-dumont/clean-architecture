package org.example.adapters.database.repository;

import org.example.adapters.database.dbo.UserDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserDbo, String> {
}