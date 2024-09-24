package org.example.movierate.repository;

import org.example.movierate.entity.Series;

import java.util.List;

public interface SearchRepo {
    List<Series> findByText(String text);
}
