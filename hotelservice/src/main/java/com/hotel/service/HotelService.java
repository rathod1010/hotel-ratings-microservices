package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {
	
	Hotel createUser(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotel(int hotelId);
	

}
