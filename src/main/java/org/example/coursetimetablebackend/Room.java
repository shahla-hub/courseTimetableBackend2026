package org.example.coursetimetablebackend;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    private String roomName;
    private int capacity;

    public Room() {
    }

    public Room(String roomName, int capacity) {
        this.roomName = roomName;
        this.capacity = capacity;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
