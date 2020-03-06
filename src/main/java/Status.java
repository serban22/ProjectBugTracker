import javax.persistence.*;
import java.util.List;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer statusId;

    String statusName;

    @OneToMany(mappedBy = "varStatus")
    List<Project> statusProject;

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                ", statusProject=" + statusProject +
                '}';
    }
}
