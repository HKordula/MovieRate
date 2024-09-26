package org.example.movierate.repository;


import org.example.movierate.entity.Series;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SeriesRepo extends MongoRepository<Series, String> {

}
