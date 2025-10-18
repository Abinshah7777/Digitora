package com.agency.digital_agency.Repository;

import com.agency.digital_agency.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Tells Spring that this is a Repository bean
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // That's it! No methods needed here yet.
}