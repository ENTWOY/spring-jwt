package com.jwt.controllers;

import com.jwt.dto.CategoryDTO;
import com.jwt.dto.SaveCategoryDTO;
import com.jwt.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> findAll(Pageable pageable) {
        Page<CategoryDTO> categories = categoryService.findAll(pageable);

        if (categories.hasContent()) {
            return ResponseEntity.ok(categories);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findOneById(@PathVariable Long id) {
        Optional<CategoryDTO> categoryDto = categoryService.findOneById(id);

        if (categoryDto.isPresent()) {
            return ResponseEntity.ok(categoryDto.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createOne(@RequestBody @Valid SaveCategoryDTO saveCategoryDto) {
        CategoryDTO categoryDto = categoryService.createOne(saveCategoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateOneById(@PathVariable Long id, @RequestBody @Valid SaveCategoryDTO saveCategoryDto) {
        CategoryDTO categoryDto = categoryService.updateOneById(id, saveCategoryDto);
        return ResponseEntity.ok(categoryDto);
    }

    @PutMapping("/{id}/disabled")
    public ResponseEntity<CategoryDTO> disableOneById(@PathVariable Long id) {
        CategoryDTO categoryDto = categoryService.disableOneById(id);
        return ResponseEntity.ok(categoryDto);
    }
}