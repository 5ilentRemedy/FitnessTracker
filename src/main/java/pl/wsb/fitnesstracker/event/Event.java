package pl.wsb.fitnesstracker.event;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date",nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private String location;

    public Event(String name, LocalDateTime startDate, String location) {
        this.name = name;
        this.description = name;
        this.startDate = startDate;
        this.endDate = LocalDateTime.now();
        this.location = location;
    }
}