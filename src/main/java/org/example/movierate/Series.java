package org.example.movierate;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document(collection = "movies")
@Data
public class Series {
    @Id
    private String Id;
    private String title;
    private String description;
    @Field("release_year")
    private int releaseYear;
    private int seasons;
    private BigDecimal rating;
    private String[] genres;
    private String[] cast;
    private String platform;
}
