package com.Portfolio.Portfolio.security.repository;

import com.Portfolio.Portfolio.security.entity.Rol;
import com.Portfolio.Portfolio.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
