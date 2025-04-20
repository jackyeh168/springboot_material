package com.example.demo.dto;

import lombok.Data;

@Data
public class RoomDto {
    private Long roomId;
    private Long floor;
    private Long roomNumber;
    private String roomType;
    private Long capacity;
    private String description;
    private String imageUrl;
    private String name;
    private String status;
    private Number price;

    public RoomDto() {
    }

    public RoomDto(
            Long roomId,
            Long floor,
            Long roomNumber,
            String roomType,
            Long capacity,
            String description,
            String imageUrl,
            String name,
            String status,
            Number price) {
        this.roomId = roomId;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.capacity = capacity;
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
        this.status = status;
        this.price = price;
    }
}
