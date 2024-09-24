package org.example.movierate.repository;

import com.mongodb.client.MongoClient;
import org.example.movierate.entity.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;

@Component
public class SearchRepoImpl implements SearchRepo{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Series> findByText(String text) {
        final List<Series> series = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("movies");
        MongoCollection<Document> collection = database.getCollection("movies");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("title", "description", "genres", "cast")))),
                new Document("$sort",
                        new Document("rating", -1L)),
                new Document("$limit", 5L)));

        result.forEach(doc -> series.add(mongoConverter.read(Series.class,doc)));

        return series;
    }
}
