package com.jwt.services;

import com.jwt.dto.ProductDTO;
import com.jwt.dto.SaveProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService
{
    Page<ProductDTO> findAll(Pageable pageable);
    Optional<ProductDTO> findOneById(Long id);
    ProductDTO createOne(SaveProductDTO saveProductDto);
    ProductDTO updateOnyById(Long id, SaveProductDTO saveProductDto);
    ProductDTO disableOneById(Long id);
}
