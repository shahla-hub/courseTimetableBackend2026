package org.example.coursetimetablebackend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin
public class FacultyController {

    private final FacultyRepository repository;

    public FacultyController(FacultyRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Faculty> getFaculty() {
        return repository.findAll();
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return repository.save(faculty);
    }

    @PutMapping("/{id}")
    public Faculty updateFaculty(
            @PathVariable int id,
            @RequestBody Faculty faculty) {

        Faculty existingFaculty =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Faculty not found"));

        existingFaculty.setFacultyName(
                faculty.getFacultyName());

        existingFaculty.setDepartment(
                faculty.getDepartment());

        return repository.save(existingFaculty);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable int id) {
        repository.deleteById(id);
    }
}