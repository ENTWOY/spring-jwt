package com.jwt.services.impl;

import com.jwt.dto.CategoryDTO;
import com.jwt.dto.SaveCategoryDTO;
import com.jwt.exceptions.ObjectNotFoundException;
import com.jwt.persistance.entities.Category;
import com.jwt.persistance.entities.Status;
import com.jwt.persistance.repositories.CategoryRepository;
import com.jwt.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Page<CategoryDTO> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(category -> mapEntityCategoryToDto(category));
    }

    @Override
    public Optional<CategoryDTO> findOneById(Long id) {
        return categoryRepository.findById(id).map(category -> mapEntityCategoryToDto(category));
    }

    @Override
    public CategoryDTO createOne(SaveCategoryDTO saveCategoryDto) {
        Category category = new Category();
        category.setName(saveCategoryDto.getName());
        category.setStatus(Status.ENABLED);

        categoryRepository.save(category);
        return mapEntityCategoryToDto(category);
    }

    @Override
    public CategoryDTO updateOneById(Long id, SaveCategoryDTO saveCategoryDto) {
        Category categoryFromDB = categoryRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Category not found. Category id: " + id));

        categoryFromDB.setName(saveCategoryDto.getName());

        categoryRepository.save(categoryFromDB);
        return mapEntityCategoryToDto(categoryFromDB);
    }

    @Override
    public CategoryDTO disableOneById(Long id) {
        Category categoryFromDB = categoryRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Category not found. Category id: " + id));

        categoryFromDB.setStatus(Status.DISABLED);

        categoryRepository.save(categoryFromDB);
        return mapEntityCategoryToDto(categoryFromDB);
    }

    private CategoryDTO mapEntityCategoryToDto(Category category) {
        if (category == null) return null;

        CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setName(category.getName());
        categoryDto.setStatus(category.getStatus());

        return categoryDto;
    }
}