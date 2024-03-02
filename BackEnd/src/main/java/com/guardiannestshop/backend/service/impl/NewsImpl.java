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
public class NewsImpl implements NewsService {
    @Autowired
    private final NewsRepository newsRepository;
    private ModelMapper modelMapper;
    private NewsMapper newsMapper;


    public NewsImpl(NewsRepository newsRepository, ModelMapper modelMapper, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.modelMapper = modelMapper;
        this.newsMapper = newsMapper;
    }

    @Override
    public List<NewsDTO> getAll(Pageable pageable) {
        List<NewsDTO> results = new ArrayList<>();
        List<NewsEntity> newsEntities = newsRepository.findAll(pageable).getContent();
        for (NewsEntity item: newsEntities
        ) {
            NewsDTO DTO = newsMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) newsRepository.count();
    }

    @Override
    public NewsDTO getByNewsid(Long newsid) {
        try {
            NewsEntity newsEntity = newsRepository.findByNewsid(newsid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + newsid));
            return newsMapper.maptoDTO(newsEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<NewsDTO> getByTitle(String title, Pageable pageable) {
        List<NewsDTO> results = new ArrayList<>();
        List<NewsEntity> newsEntities = newsRepository.findByTitle(title,pageable);
        for (NewsEntity item: newsEntities
        ) {
            NewsDTO DTO = newsMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public void deleteByNewsid(Long newsid) {
        newsRepository.deleteByNewsid(newsid);
    }

    @Override
    public void createNews(NewsDTO newsDTO) {
        if ( newsDTO != null) {
            NewsEntity news = newsMapper.maptoEntity(newsDTO);
            if (news != null) {
                newsRepository.save(news);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateNews(NewsDTO newsDTO) {
        NewsEntity existingNews  = newsRepository.findByNewsid(newsDTO.getNewsid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(newsDTO, existingNews);
        newsRepository.save(existingNews);
    }
}
