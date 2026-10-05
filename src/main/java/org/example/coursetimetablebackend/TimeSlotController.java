package org.example.coursetimetablebackend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time-slots")
@CrossOrigin
public class TimeSlotController {

    private final TimeSlotRepository repository;

    public TimeSlotController(TimeSlotRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TimeSlot> getTimeSlots() {
        return repository.findAll();
    }

    @PostMapping
    public TimeSlot addTimeSlot(@RequestBody TimeSlot timeSlot) {
        return repository.save(timeSlot);
    }

    @PutMapping("/{id}")
    public TimeSlot updateTimeSlot(
            @PathVariable int id,
            @RequestBody TimeSlot timeSlot) {

        TimeSlot existingTimeSlot =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Time slot not found"));

        existingTimeSlot.setDay(timeSlot.getDay());
        existingTimeSlot.setTimeSlot(timeSlot.getTimeSlot());

        return repository.save(existingTimeSlot);
    }

    @DeleteMapping("/{id}")
    public void deleteTimeSlot(@PathVariable int id) {
        repository.deleteById(id);
    }
}