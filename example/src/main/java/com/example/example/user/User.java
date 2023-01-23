package com.example.example.user;
import com.example.example.location.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @SequenceGenerator(
//            name="user_sequence",
//            sequenceName="user_sequence",
//            allocationSize=1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "user_sequence"
//    )
    private Long user_id;
    private String firstname;
    private String lastname;

   @ManyToOne(targetEntity = Location.class)
   @JoinColumn(name = "location_id",referencedColumnName = "location_id")
   private Location location_id;

    private String email;

}
