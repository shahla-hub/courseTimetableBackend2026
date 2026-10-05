package org.example.coursetimetablebackend;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    private final AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Admin admin) {

        Optional<Admin> existingAdmin =
                repository.findByUsernameAndPassword(
                        admin.getUsername(),
                        admin.getPassword()
                );

        return existingAdmin.isPresent();
    }
}
