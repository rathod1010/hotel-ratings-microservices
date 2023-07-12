package com.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
	
	//custom finder methods
	
	List<Rating> findByUserId(int userId);
	
	List<Rating> findByHotelId(int hotelId);

}
