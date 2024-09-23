package org.example.movierate.repository;

import org.example.movierate.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;


public interface SeriesRepo extends MongoRepository<Series, Integer> {

}
