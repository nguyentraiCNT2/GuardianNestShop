package com.guardiannestshop.backend.service.impl;

import com.guardiannestshop.backend.Mapper.Opject.*;
import com.guardiannestshop.backend.dto.*;
import com.guardiannestshop.backend.entity.*;
import com.guardiannestshop.backend.repository.*;
import com.guardiannestshop.backend.service.*;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoveListIMPL implements LoveListService {
    @Autowired
    private final LoveListRepository loveListRepository;
    private UserRepository userRepository;
    private ProductsRepository productsRepository;
    private ModelMapper modelMapper;
    private LoveListMapper loveListMapper;


    public LoveListIMPL(LoveListRepository loveListRepository, UserRepository userRepository, ProductsRepository productsRepository, ModelMapper modelMapper, LoveListMapper loveListMapper) {
        this.loveListRepository = loveListRepository;
        this.userRepository = userRepository;
        this.productsRepository = productsRepository;
        this.modelMapper = modelMapper;
        this.loveListMapper = loveListMapper;
    }

    @Override
    public List<LoveListDTO> getAll(Pageable pageable) {
        List<LoveListDTO> results = new ArrayList<>();
        List<LoveListEntity> loveListEntities = loveListRepository.findAll(pageable).getContent();
        for (LoveListEntity item: loveListEntities
        ) {
            LoveListDTO DTO = modelMapper.map(item,LoveListDTO.class);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) loveListRepository.count();
    }

    @Override
    public LoveListDTO getByLovelistid(Long lovelistid) {
        try {
            LoveListEntity loveList = loveListRepository.findByLovelistid(lovelistid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + lovelistid));
            return loveListMapper.maptoDTO(loveList);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<LoveListDTO> getByUserid(String userid, Pageable pageable) {
        List<LoveListDTO> results = new ArrayList<>();
        List<LoveListEntity> loveListEntities = loveListRepository.findByUserid(userid,pageable);
        for (LoveListEntity item: loveListEntities
        ) {
            LoveListDTO DTO = loveListMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<LoveListDTO> getByLovelistname(String lovelistname, Pageable pageable) {
        List<LoveListDTO> results = new ArrayList<>();
        List<LoveListEntity> loveListEntities = loveListRepository.findByLovelistname(lovelistname,pageable);
        for (LoveListEntity item: loveListEntities
        ) {
            LoveListDTO DTO = loveListMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public void deleteByLovelistid(Long lovelistid) {
        loveListRepository.deleteByLovelistid(lovelistid);
    }

    @Override
    public void createLoveList(LoveListDTO loveListDTO) {
        if ( loveListDTO != null) {
            LoveListEntity loveList = loveListMapper.maptoEntity(loveListDTO);
            UserEntity user = userRepository.findByUserid(loveListDTO.getUserid()).orElse(null);
            if (loveList != null) {
                loveList.setUserid(user);
                loveListRepository.save(loveList);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateLoveList(LoveListDTO loveListDTO) {
        LoveListEntity existingLoveList  = loveListRepository.findByLovelistid(loveListDTO.getLovelistid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(loveListDTO, existingLoveList);
        loveListRepository.save(existingLoveList);
    }
}
