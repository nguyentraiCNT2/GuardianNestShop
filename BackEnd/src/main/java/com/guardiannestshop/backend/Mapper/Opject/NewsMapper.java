package com.guardiannestshop.backend.Mapper.Opject;

import com.guardiannestshop.backend.dto.NewsDTO;
import com.guardiannestshop.backend.entity.NewsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper {
    private final ModelMapper modelMapper;


    public NewsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public NewsDTO maptoDTO (NewsEntity entity){
        NewsDTO dto = new NewsDTO();
        dto.setNewsid(entity.getNewsid());
        dto.setContent(entity.getContent());
        dto.setThumnail(entity.getThumnail());
        dto.setNewsdate(entity.getNewsdate());
        dto.setTitle(entity.getTitle());
        return dto;
    }
    public NewsEntity maptoEntity (NewsDTO dto){
        NewsEntity entity = new NewsEntity();
        entity.setNewsid(dto.getNewsid());
        entity.setContent(dto.getContent());
        entity.setThumnail(dto.getThumnail());
        entity.setNewsdate(dto.getNewsdate());
        entity.setTitle(dto.getTitle());
        return entity;
    }
}
