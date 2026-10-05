package org.example.coursetimetablebackend;

import jakarta.persistence.*;

@Entity
@Table(name = "time_slot")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slotId;

    private String day;

    @Column(name = "time_slot")
    private String timeSlot;

    public TimeSlot() {
    }

    public TimeSlot(String day, String timeSlot) {
        this.day = day;
        this.timeSlot = timeSlot;
    }

    public int getSlotId() {
        return slotId;
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
