
package com.portfolio.yag.Repository;

import com.portfolio.yag.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkills extends JpaRepository<Skills, Integer>{
    public Optional<Skills> findByNameSkill(String nameSkill);
    public boolean existsByNameSkill(String nameSkill);
    
    
}

