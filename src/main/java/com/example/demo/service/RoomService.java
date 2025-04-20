package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RoomDto;
import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;

	private RoomDto convertEntityToDto(Room room) {
		return new RoomDto(
				room.getId(),
				room.getFloor(),
				room.getRoomNumber(),
				room.getRoomType(),
				room.getCapacity(),
				room.getDescription(),
				room.getImageUrl(),
				room.getName(),
				room.getStatus(),
				room.getPrice());
	}

	private List<RoomDto> convertEntityListToDto(List<Room> rooms) {
		return rooms.stream()
				.map(room -> {
					return this.convertEntityToDto(room);
				}).collect(Collectors.toList());
	}

	public List<RoomDto> getAllRooms() {
		return convertEntityListToDto(roomRepository.findAll());
	}
}
