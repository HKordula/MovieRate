package org.example.movierate.controller;

import org.example.movierate.Series;
import org.example.movierate.repository.SearchRepo;
import org.example.movierate.repository.SeriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeriesController {

    @Autowired
    SeriesRepo repo;

    @Autowired
    SearchRepo srepo;

    @GetMapping("/series")
    public List<Series> getSeries()
    {
        return repo.findAll();
    }

    @GetMapping("/series/{text}")
    public List<Series> getSeries(@PathVariable String text)
    {
        return srepo.findByText(text);
    }

    @PostMapping("/addSeries")
    public Series addSeries(@RequestBody Series series) {
        return repo.save(series);
    }

    //@PutMapping("/series/")
    //public Series updateSeries(@RequestBody Series series) {
    //    return repo.
    //}
//
    //@DeleteMapping("/series/{id}")
    //public void deleteSeries(@PathVariable int id) {
    //    repo.deleteById(id);
    //}
}
