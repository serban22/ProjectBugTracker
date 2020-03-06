import javax.persistence.*;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer commentId;
    String commentText;
    //Integer itemId;

    @ManyToOne
    @JoinColumn(name = "itemId")
    Item varItem;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentText='" + commentText + '\'' +
                ", item=" + varItem.itemTitle +
                ", item=" + varItem.itemDescription +
                '}';
    }
}
