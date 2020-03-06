import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer itemId;

    String itemTitle;
    String itemDescription;
    //Integer statusId;
    //Integer typeId;

    @ManyToOne
    @JoinColumn(name = "statusId")
    Status varStatus;

    @ManyToOne
    @JoinColumn(name = "typeId")
    Type varType;

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemTitle='" + itemTitle + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", varStatus=" + varStatus.statusName +
                ", varType=" + varType.typeName +
                '}';
    }
}
