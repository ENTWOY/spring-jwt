package com.jwt.services;

import com.jwt.dto.CategoryDTO;
import com.jwt.dto.SaveCategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService
{
    Page<CategoryDTO> findAll(Pageable pageable);
    Optional<CategoryDTO> findOneById(Long id);
    CategoryDTO createOne(SaveCategoryDTO saveCategoryDto);
    CategoryDTO updateOneById(Long id, SaveCategoryDTO saveCategoryDto);
    CategoryDTO disableOneById(Long id);
}
