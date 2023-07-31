package threeoceans.fitness.ru.accounts.schedule.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="participants")
@Data
@NoArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private ClubEvent clubEvent;

    @Column(name = "subscription_id")
    private Long subscriptionID;


}
