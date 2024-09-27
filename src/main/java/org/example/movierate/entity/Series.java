package org.example.movierate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Series {
    @Id
    @Field("_id")
    private ObjectId id;
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
