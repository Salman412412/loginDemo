package learn.laitech.java.salman.exercise.login.domain.Entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @ToString
@Entity @Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;
    private String name;
    private String family;
    private String address;
}
