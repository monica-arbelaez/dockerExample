package com.application.dockerExample.service;

import com.application.dockerExample.persistence.model.Movie;

public interface MovieService {
    Movie create (Movie entity);
}
