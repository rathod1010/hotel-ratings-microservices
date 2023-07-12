package com.rating.service;

import java.util.List;

import com.rating.entity.Rating;

public interface RatingService {
	
	Rating createRating(Rating rating);
	
	List<Rating> allRatings();
	
	//get all by userId
	
	List<Rating> getRatingByUserId(int userId);
	
	//get all by hotelId
	
	List<Rating> getRatingByHotelId(int hotelId);

}
