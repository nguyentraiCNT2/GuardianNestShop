package com.guardiannestshop.backend.service;

import com.guardiannestshop.backend.dto.BlackListDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlackListService {
    List<BlackListDTO> getAll(Pageable pageable);
    int totalItem();
    BlackListDTO getByBalcklistid(Long balcklistid);
    List<BlackListDTO>getByBlacklistname(String blacklistname, Pageable pageable);
    List<BlackListDTO> getByUserid(String userid, Pageable pageable);
    void deleteByBalcklistid(Long balcklistid);
    void createBalcklist(BlackListDTO blackListDTO);
    void updateBalcklist(BlackListDTO blackListDTO);
}
