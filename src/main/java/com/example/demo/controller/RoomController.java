package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoomDto;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@GetMapping("/rooms")
	public List<RoomDto> listRooms(Model model) {
		return roomService.getAllRooms();
	}
}
