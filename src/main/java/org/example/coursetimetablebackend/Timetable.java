package org.example.coursetimetablebackend;

import jakarta.persistence.*;

@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timetableId;

    private int courseId;
    private int roomId;
    private String day;

    @Column(name = "time_slot")
    private String timeSlot;

    public Timetable() {
    }

    public Timetable(int courseId, int roomId, String day, String timeSlot) {
        this.courseId = courseId;
        this.roomId = roomId;
        this.day = day;
        this.timeSlot = timeSlot;
    }

    public int getTimetableId() {
        return timetableId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}
