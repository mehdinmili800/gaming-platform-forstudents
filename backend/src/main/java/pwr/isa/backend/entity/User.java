package pwr.isa.backend.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Users")
public class User {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long ID;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @JsonIgnore
    @Builder.Default
    private boolean enabled = false;
}

