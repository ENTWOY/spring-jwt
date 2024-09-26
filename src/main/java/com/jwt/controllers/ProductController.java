package com.jwt.controllers;

import com.jwt.dto.ProductDTO;
import com.jwt.dto.SaveProductDTO;
import com.jwt.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        Page<ProductDTO> products = productService.findAll(pageable);

        if (products.hasContent()) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findOneById(@PathVariable Long id) {
        Optional<ProductDTO> productDto = productService.findOneById(id);

        if (productDto.isPresent()) {
            return ResponseEntity.ok(productDto.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createOne(@RequestBody @Valid SaveProductDTO saveProductDto) {
        ProductDTO productDto = productService.createOne(saveProductDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateOneById(@PathVariable Long id, @RequestBody @Valid SaveProductDTO saveProductDto) {
        ProductDTO productDto = productService.updateOnyById(id, saveProductDto);
        return ResponseEntity.ok(productDto);
    }

    // en lugar de eliminar un producto, lo deshabilitamos (DISABLED)
    @PutMapping("/{id}/disabled")
    public ResponseEntity<ProductDTO> disableOneById(@PathVariable Long id) {
        ProductDTO productDto = productService.disableOneById(id);
        return ResponseEntity.ok(productDto);
    }
}