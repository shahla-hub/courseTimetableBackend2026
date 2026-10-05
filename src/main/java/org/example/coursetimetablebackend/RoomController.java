package org.example.coursetimetablebackend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin
public class RoomController {

    private final RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Room> getRooms() {
        return repository.findAll();
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return repository.save(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(
            @PathVariable int id,
            @RequestBody Room room) {

        Room existingRoom =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Room not found"));

        existingRoom.setRoomName(room.getRoomName());
        existingRoom.setCapacity(room.getCapacity());

        return repository.save(existingRoom);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable int id) {
        repository.deleteById(id);
    }
}