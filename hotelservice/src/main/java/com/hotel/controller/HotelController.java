package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;


@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/save")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		Hotel savedHotel = hotelService.createUser(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
	}
	
	@GetMapping("/get/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable int hotelId)
	{
		Hotel hotel = hotelService.getHotel(hotelId);
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping("get/all")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> allHotels = hotelService.getAllHotels();
		return ResponseEntity.ok(allHotels);
	}
	
	

}
