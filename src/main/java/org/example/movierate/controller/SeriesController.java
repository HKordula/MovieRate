package org.example.movierate.controller;

import org.bson.types.ObjectId;
import org.example.movierate.dto.SeriesDto;
import org.example.movierate.entity.Series;
import org.example.movierate.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SeriesController {

    @Autowired
    SeriesService seriesService;

    @PostMapping("/addSeries")
    public ResponseEntity<Series> addSeries(@RequestBody Series series) {
        return seriesService.addSeries(series);
    }

    @GetMapping("/series")
    public ResponseEntity<List<Series>> getSeries() {
        return seriesService.getSeries();
    }

    @GetMapping("/series/{id}")
    public ResponseEntity<Optional<Series>> getSeriesById(@PathVariable ObjectId id) {
        return seriesService.getSeriesById(id);
    }

    @GetMapping("/series/search/{text}")
    public ResponseEntity<List<Series>> getSeries(@PathVariable String text) {
        return seriesService.findByText(text);
    }

    @PutMapping("/series/{id}")
    public ResponseEntity<SeriesDto> updateSeries(@PathVariable ObjectId id, @RequestBody SeriesDto updatedSeries) {
        return seriesService.updateSeries(id, updatedSeries);
    }

    @DeleteMapping("/series/{id}")
    public void deleteSeries(@PathVariable ObjectId id) {
        seriesService.deleteSeries(id);
    }
}
