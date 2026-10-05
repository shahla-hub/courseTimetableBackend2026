package org.example.coursetimetablebackend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<Timetable, Integer> {
}
