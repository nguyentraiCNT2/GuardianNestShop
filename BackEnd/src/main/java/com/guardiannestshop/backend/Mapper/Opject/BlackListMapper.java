package com.guardiannestshop.backend.Mapper.Opject;

import com.guardiannestshop.backend.dto.BlackListDTO;
import com.guardiannestshop.backend.entity.BlackListEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class BlackListMapper {
    private final ModelMapper modelMapper;


    public BlackListMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BlackListDTO maptoDTO (BlackListEntity entity){
        BlackListDTO dto = new BlackListDTO();
        dto.setBalcklistid(entity.getBalcklistid());
        dto.setBlacklistname(entity.getBlacklistname());
        dto.setBlacklistdate(entity.getBlacklistdate());
        dto.setUserid(entity.getUserid().getUserid());
        return dto;
    }
    public BlackListEntity maptoEntity (BlackListDTO dto){
        BlackListEntity entity = new BlackListEntity();
        entity.setBalcklistid(dto.getBalcklistid());
        entity.setBlacklistname(dto.getBlacklistname());
        entity.setBlacklistdate(dto.getBlacklistdate());
        return entity;
    }
}
