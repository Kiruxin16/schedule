package threeoceans.fitness.ru.schedule.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="club_events")
@Data
@NoArgsConstructor
public class ClubEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="discipline")
    private String discipline;

    @Column(name="coach_name")
    private String coachName;


    @Column(name="event_date")
    private LocalDate eventDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "finish_time")
    private LocalTime finishTime;

    @ManyToOne
    @JoinColumn(name="hall_id")
    private Hall hall;

    @Column(name="comments")
    private String comments;


    @CreationTimestamp
    @Column(name ="created_at")
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name ="updated_at" )
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "clubEvent",cascade =CascadeType.PERSIST)
    private List<Participant> participants;



}
