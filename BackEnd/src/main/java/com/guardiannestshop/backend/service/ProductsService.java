package com.guardiannestshop.backend.service;

import com.guardiannestshop.backend.dto.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductsService  {
    List<ProductsDTO> getAll(Pageable pageable);
    int totalItem();
    ProductsDTO getByProductsid(Long productsid);
    List<ProductsDTO> getByCore(String core);
    List<ProductsDTO> getByProductname(String productname, Pageable pageable);
    List<ProductsDTO> getByProductprice(String productprice, Pageable pageable);
    List<ProductsDTO> getByProductsview(String productsview, Pageable pageable);
    List<ProductsDTO> getByCategoryLV2id(Long categoryLV2id, Pageable pageable);
    List<ProductsDTO> getByColorid(Long colorid, Pageable pageable);
    List<ProductsDTO> getByCategoryid(Long categoryid, Pageable pageable);
    List<ProductsDTO> getByLoveListid(Long loveListid, Pageable pageable);
    void deleteByProductsid(Long productsid);
    void createProducts(ProductsDTO productsDTO);
    void updateProducts(ProductsDTO productsDTO);
    void uploadImage1(String productname, MultipartFile file) throws IOException;
    void uploadImage2(String productname, MultipartFile file) throws IOException;
    void uploadImage3(String productname, MultipartFile file) throws IOException;
    void uploadImage4(String productname, MultipartFile file) throws IOException;
    void uploadImage5(String productname, MultipartFile file) throws IOException;
}
