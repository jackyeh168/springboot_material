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

	public RoomDto createRoom(Room room) {
		return convertEntityToDto(roomRepository.save(room));
	}

	public RoomDto updateRoom(Long id, Room room) {
		Room existingRoom = roomRepository.findById(id).orElse(null);
		if (existingRoom != null) {
			existingRoom.setFloor(room.getFloor());
			existingRoom.setRoomNumber(room.getRoomNumber());
			existingRoom.setRoomType(room.getRoomType());
			existingRoom.setCapacity(room.getCapacity());
			existingRoom.setDescription(room.getDescription());
			existingRoom.setImageUrl(room.getImageUrl());
			existingRoom.setName(room.getName());
			existingRoom.setStatus(room.getStatus());
			existingRoom.setPrice(room.getPrice());

			return convertEntityToDto(roomRepository.save(existingRoom));
		}
		return null;
	}

	public void deleteRoom(Long id) {
		Room room = roomRepository.findById(id).orElse(null);
		if (room != null) {
			roomRepository.delete(room);
		}
		return;
	}
}
