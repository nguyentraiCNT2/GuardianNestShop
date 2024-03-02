package com.guardiannestshop.backend.service;

import com.guardiannestshop.backend.dto.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoveListService{
  List<LoveListDTO> getAll(Pageable pageable);
  int totalItem();
  LoveListDTO getByLovelistid(Long lovelistid);
    List<LoveListDTO> getByUserid(String userid, Pageable pageable);
    List<LoveListDTO> getByLovelistname(String lovelistname, Pageable pageable);
    void deleteByLovelistid(Long lovelistid);
    void createLoveList(LoveListDTO loveListDTO);
    void updateLoveList(LoveListDTO loveListDTO);
}
