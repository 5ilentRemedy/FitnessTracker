package pl.wsb.fitnesstracker.statistics.api;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Statistics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Statistics {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Nullable
    //private Long id;
    //private int totalTrainings;
    //private double totalDistance;
    //private int totalCaloriesBurned;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "totalTrainings")
    private int totalTrainings;

    @Nullable
    @Column(name = "totalDistance")
    private double totalDistance;

    @Column(name = "totalCaloriesBurned")
    private long totalCaloriesBurned;

    public Statistics(int totalTrainings, double totalDistance, int totalCaloriesBurned) {
        this.totalTrainings = totalTrainings;
        this.totalDistance = totalDistance;
        this.totalCaloriesBurned = totalCaloriesBurned;
    }
}