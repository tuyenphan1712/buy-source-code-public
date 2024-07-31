package org.example.buysourcecode.repository;

import org.example.buysourcecode.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    @Query("select c from Category c where c.status != 'DELETE'")
    List<Category> findAll();

    @Query("select c from Category c where c.id = :id and c.status != 'DELETE'")
    Category findCategoriesById(@Param("id") String id);

    @Query("select c from Category c where c.status != 'DELETE' and c.slug = :slug")
    Category findCategoryBySlug(@Param("slug") String slug);

}
