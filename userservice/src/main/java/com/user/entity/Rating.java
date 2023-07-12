package com.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	
	private int ratingId;
	
	private String userId;
	
	private int hotelId;
	
	private int rating;
	
	private String feedback;
	
	private Hotel hotel;
	
	

}
