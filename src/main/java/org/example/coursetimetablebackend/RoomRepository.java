package org.example.coursetimetablebackend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}