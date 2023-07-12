package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createUser(Hotel hotel) {
		
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(int hotelId) {
		
		return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel not found with id "+hotelId));
	}

}
