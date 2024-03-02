package com.guardiannestshop.backend.Mapper.Opject;

import com.guardiannestshop.backend.dto.LoveListDTO;
import com.guardiannestshop.backend.entity.LoveListEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LoveListMapper {
    private final ModelMapper modelMapper;

    public LoveListMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public LoveListDTO maptoDTO (LoveListEntity entity){
        LoveListDTO dto = new LoveListDTO();
        dto.setListdate(entity.getListdate());
        dto.setLovelistid(entity.getLovelistid());
        dto.setLovelistname(entity.getLovelistname());
        dto.setUserid(entity.getUserid().getUserid() != null ? entity.getUserid().getUserid() : null);
        return dto;
    }
    public LoveListEntity maptoEntity (LoveListDTO dto){
        LoveListEntity entity = new LoveListEntity();
        entity.setListdate(dto.getListdate());
        entity.setLovelistid(dto.getLovelistid());
        entity.setLovelistname(dto.getLovelistname());
        return entity;
    }
}
