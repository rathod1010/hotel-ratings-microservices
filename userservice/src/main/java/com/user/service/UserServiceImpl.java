package com.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Hotel;
import com.user.entity.Rating;
import com.user.entity.User;
import com.user.exception.ResourceNotFoundException;
import com.user.external.services.HotelService;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User createUser(User user) {

//		String randomUserId = UUID.randomUUID().toString();
//		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User getUser(int userId) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id" + userId));
		
		//fetch rating of the above user from RATING SERVICE
		//http://localhost:8012/ratings/get/users/1
		
//	ArrayList<Rating> ratingsOfUser =restTemplate.getForObject("http://localhost:8012/ratings/get/users/"+user.getUserId(), ArrayList.class);	
	Rating[] ratingsOfUser =restTemplate.getForObject("	http://RATING-SERVICE/ratings/get/users/"+user.getUserId(), Rating[].class);
	logger.info("{} ",ratingsOfUser);
	
	List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
	
	//api call to hotel service to get the hotel
	//http://localhost:8011/hotel/get/3
	//set hotel to rating
	//return the rating
	
	List<Rating> ratingList = ratings.stream().map(rating->{
		
//	ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/get/"+rating.getHotelId(), Hotel.class);
//	Hotel hotel = forEntity.getBody();
		Hotel hotel = hotelService.getHotel(rating.getHotelId());
	rating.setHotel(hotel);
	
		return rating;
	}).collect(Collectors.toList());
	
	
	user.setRatings(ratingList);
	
		return user;
	}

//	@Override
//	public User getUser(int userId) {
//
//		return userRepository.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User not found with id" + userId));
//	}
}
