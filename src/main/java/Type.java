import javax.persistence.*;
import java.util.List;

@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer typeId;
    String typeName;

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}

