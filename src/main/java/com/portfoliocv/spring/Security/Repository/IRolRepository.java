
package com.portfoliocv.spring.Security.Repository;

import com.portfoliocv.spring.Security.Entity.Rol;
import com.portfoliocv.spring.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
