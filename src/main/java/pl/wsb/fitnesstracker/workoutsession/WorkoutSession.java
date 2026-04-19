package pl.wsb.fitnesstracker.workoutsession;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.training.api.Training;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "workout_session")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
// TODO: Define the Event entity with appropriate fields and annotations
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private int id;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "startLatitude", nullable = false)
    private LocalDateTime startLatitude;

    @Column(name = "startLongitude", nullable = false)
    private LocalDateTime startLongitude;

    @Column(name = "endLatitude", nullable = false)
    private LocalDateTime endLatitude;

    @Column(name = "endLongitude", nullable = false)
    private LocalDateTime endLongitude;

    @Column(name = "altitude", nullable = false)
    private double altitude;

    public WorkoutSession(
            final Training training,
            final LocalDateTime timestamp,
            final LocalDateTime startLatitude,
            final LocalDateTime startLongitude,
            final LocalDateTime endLatitude,
            final LocalDateTime endLongitude,
            final double altitude
            ) {
        this.training = training;
        this.timestamp = timestamp;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
        this.altitude = altitude;

    }
}
