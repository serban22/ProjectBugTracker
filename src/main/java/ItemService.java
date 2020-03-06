import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemService {
    private static ItemService instance;

    private ItemService() {

    }

    public static ItemService getInstance() {
        if (instance == null) {
            instance = new ItemService();
        }
        return instance;
    }

    public void createItem(Item item) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Item getItem(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Item item = session.find(Item.class, id);
            return item;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void updateItem(Item item) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(item);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteItem(Item item) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(item);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
