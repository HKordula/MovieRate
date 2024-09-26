package org.example.movierate.service;

import org.bson.types.ObjectId;
import org.example.movierate.dto.SeriesDto;
import org.example.movierate.entity.Series;
import org.example.movierate.mapper.SeriesMapper;
import org.example.movierate.repository.SearchRepo;
import org.example.movierate.repository.SeriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {

    @Autowired
    SeriesRepo repo;

    @Autowired
    SearchRepo srepo;

    public ResponseEntity<List<Series>> getSeries() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Series>> findByText(String text) {
        return new ResponseEntity<>(srepo.findByText(text), HttpStatus.OK);
    }

    public ResponseEntity<Series> addSeries(Series series) {
        return new ResponseEntity<>(repo.save(series), HttpStatus.OK);
    }

    public ResponseEntity<SeriesDto> updateSeries(String id, SeriesDto updatedSeries) {
        Series series = repo.findById(id).orElseThrow(
                () -> new RuntimeException("Series " + id +" is not exist")
        );

        series.setTitle(updatedSeries.getTitle());
        series.setDescription(updatedSeries.getDescription());
        series.setReleaseYear(updatedSeries.getReleaseYear());
        series.setSeasons(updatedSeries.getSeasons());
        series.setRating(updatedSeries.getRating());
        series.setGenres(updatedSeries.getGenres());
        series.setCast(updatedSeries.getCast());
        series.setPlatform(updatedSeries.getPlatform());

        Series updatedSeriesObj = repo.save(series);

        return new ResponseEntity<>(SeriesMapper.mapToSeriesDto(updatedSeriesObj), HttpStatus.OK);
    }


    //public ResponseEntity<String> deleteSeries(int id) {
    //    Series series;
    //    try {
    //        series = repo.findById(id).orElseThrow(
    //                () -> new Exception("Series not exist")
    //        );
    //    } catch (Exception e) {
    //        throw new RuntimeException(e);
    //    }
    //
    //    return new ResponseEntity<>(repo.deleteById(id), HttpStatus.OK)
    //}


}
