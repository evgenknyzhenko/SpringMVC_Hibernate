

package app.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_TO_ROLE",
            joinColumns = {
            @JoinColumn(name = "FK_ROLE_ID", nullable = false)
    },
            inverseJoinColumns = {
            @JoinColumn(name="FK_USER_ID", nullable = false)
            })
    private List<User> users = new ArrayList<>();


}

