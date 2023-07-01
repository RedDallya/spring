
package com.portfoliocv.spring.Security.Service;

import com.portfoliocv.spring.Security.Entity.Rol;
import com.portfoliocv.spring.Security.Enums.RolNombre;
import com.portfoliocv.spring.Security.Repository.IRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
        
    }   
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
