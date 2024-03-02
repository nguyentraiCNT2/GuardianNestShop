package com.guardiannestshop.backend.repository;

import com.guardiannestshop.backend.entity.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity,Long> {
    Optional<ProductsEntity> findByProductsid(Long productsid);
    List<ProductsEntity> findByCore(String core);
    List<ProductsEntity> findByProductname(String productname);
    List<ProductsEntity> findByProductname(String productname, Pageable pageable);
    List<ProductsEntity> findByProductprice(String productprice, Pageable pageable);
    List<ProductsEntity> findByProductsview(String productsview, Pageable pageable);
    List<ProductsEntity> findByCategoryLV2id(CategoryLV2Entity categoryLV2, Pageable pageable);
    List<ProductsEntity> findByColorid(ColorEntity color, Pageable pageable);
    List<ProductsEntity> findByCategoryid(CategoryEntity categoryEntity, Pageable pageable);
    List<ProductsEntity> findByLoveListid(LoveListEntity loveList, Pageable pageable);
    void deleteByProductsid(Long productsid);
    ProductsEntity saveAndFlush(ProductsEntity productsEntity);
}
