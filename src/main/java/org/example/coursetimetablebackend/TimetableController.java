package org.example.coursetimetablebackend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetable")
@CrossOrigin
public class TimetableController {

    private final TimetableRepository repository;

    public TimetableController(TimetableRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Timetable> getTimetable() {
        return repository.findAll();
    }

    @PostMapping
    public Timetable addTimetable(@RequestBody Timetable timetable) {
        return repository.save(timetable);
    }

    @PutMapping("/{id}")
    public Timetable updateTimetable(
            @PathVariable int id,
            @RequestBody Timetable timetable) {

        Timetable existingTimetable =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Timetable not found"));

        existingTimetable.setCourseId(timetable.getCourseId());
        existingTimetable.setRoomId(timetable.getRoomId());
        existingTimetable.setDay(timetable.getDay());
        existingTimetable.setTimeSlot(timetable.getTimeSlot());

        return repository.save(existingTimetable);
    }

    @DeleteMapping("/{id}")
    public void deleteTimetable(@PathVariable int id) {
        repository.deleteById(id);
    }
}