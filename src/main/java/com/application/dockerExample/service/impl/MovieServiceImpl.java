package com.application.dockerExample.service.impl;

import com.application.dockerExample.persistence.MovieRepository;
import com.application.dockerExample.persistence.model.Movie;
import com.application.dockerExample.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public Movie create(Movie entity) {
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatedDate(new Date());
        entity.setUpdatedDate(new Date());

        return movieRepository.save(entity);
    }

}
