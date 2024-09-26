package org.example.movierate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.BsonInt32;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class SeriesDto {
    private String Id;
    private String title;
    private String description;
    private int releaseYear;
    private int seasons;
    private BigDecimal rating;
    private String[] genres;
    private String[] cast;
    private String platform;
}
