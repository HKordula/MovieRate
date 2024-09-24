package org.example.movierate.mapper;

import org.example.movierate.dto.SeriesDto;
import org.example.movierate.entity.Series;

public class SeriesMapper {
    public static SeriesDto mapToSeriesDto(Series series) {
        return new SeriesDto(
                series.getId(),
                series.getTitle(),
                series.getDescription(),
                series.getReleaseYear(),
                series.getSeasons(),
                series.getRating(),
                series.getGenres(),
                series.getCast(),
                series.getPlatform()
        );
    }

    public static Series mapToSeries(SeriesDto seriesDto) {
        return new Series(
                seriesDto.getId(),
                seriesDto.getTitle(),
                seriesDto.getDescription(),
                seriesDto.getReleaseYear(),
                seriesDto.getSeasons(),
                seriesDto.getRating(),
                seriesDto.getGenres(),
                seriesDto.getCast(),
                seriesDto.getPlatform()
        );
    }
}

