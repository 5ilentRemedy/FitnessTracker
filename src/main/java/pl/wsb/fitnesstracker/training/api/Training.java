package pl.wsb.fitnesstracker.training.api;

import lombok.Getter;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Getter
public class Training {
/*
    private Long id;

    private User user;

    private Date startTime;

    private Date endTime;

    private ActivityType activityType;

    private double distance;

    private double averageSpeed;
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "startTime", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "endTime")
    private LocalDateTime endTime;

    @Column(name = "activityType")
    private String activityType;

    @Column(name = "distance")
    private double distance;

    @Column(name = "averageSpeed")
    private double averageSpeed;

    public Training(
            final User user,
            final LocalDateTime startTime,
            final LocalDateTime endTime,
            final String activityType,
            final double distance,
            final double averageSpeed) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }
}