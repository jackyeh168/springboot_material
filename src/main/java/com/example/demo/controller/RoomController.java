package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoomDto;
import com.example.demo.entity.Room;
import com.example.demo.service.RoomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@GetMapping
	public List<RoomDto> listRooms(Model model) {
		return roomService.getAllRooms();
	}

	@PostMapping
	public RoomDto createRoom(@RequestBody Room room) {
		return roomService.createRoom(room);
	}

	@PutMapping("/{id}")
	public RoomDto updateRoom(@PathVariable Long id, @RequestBody Room room) {
		return roomService.updateRoom(id, room);
	}

	@DeleteMapping("/{id}")
	public void deleteRoom(@PathVariable Long id) {
		roomService.deleteRoom(id);
	}
}
