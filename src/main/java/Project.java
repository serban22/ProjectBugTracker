import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer projectId;

    String projectName;
    String shortName;
    String projectDescription;
    //Integer statusId;

    @ManyToOne
    @JoinColumn(name = "statusId")
    Status varStatus;

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", varStatus=" + varStatus.statusId +
                '}';
    }
}
