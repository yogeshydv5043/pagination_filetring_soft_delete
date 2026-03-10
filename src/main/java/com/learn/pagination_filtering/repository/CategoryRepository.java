package com.learn.pagination_filtering.repository;

import com.learn.pagination_filtering.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByCategoryNameIgnoreCase(String name);

    boolean existsByCategoryNameIgnoreCase(String name);
}
