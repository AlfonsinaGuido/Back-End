
package com.portfolio.yag.Repository;

import com.portfolio.yag.Entity.About;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAbout extends JpaRepository<About, Integer> {
    
    public Optional <About> findByAbout(String about);
    public boolean existsByAbout(String about);
    
    
}
