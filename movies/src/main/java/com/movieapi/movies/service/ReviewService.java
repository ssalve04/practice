package com.movieapi.movies.service;


import com.movieapi.movies.model.Movie;
import com.movieapi.movies.model.Reviews;
import com.movieapi.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    public ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String imdbId){
        Reviews reviews=  reviewRepository.insert(new Reviews(reviewBody));


        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(reviews))
                .first();

        return reviews;
    }
}
