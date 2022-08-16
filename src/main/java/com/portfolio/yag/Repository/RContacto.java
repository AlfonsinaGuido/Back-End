
package com.portfolio.yag.Repository;

import com.portfolio.yag.Entity.Contacto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RContacto extends JpaRepository<Contacto, Integer>{
    public Optional<Contacto> findByEmail(String Email);
    public boolean existsByEmail(String email);
}
