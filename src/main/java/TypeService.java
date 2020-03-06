import org.hibernate.Session;
import org.hibernate.Transaction;

public class TypeService {
    private static TypeService instance;

    private TypeService() {

    }

    public static TypeService getInstance() {
        if (instance == null) {
            instance = new TypeService();
        }
        return instance;
    }

    public void createType(Type type) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(type);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Type getType(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Type type = session.find(Type.class, id);
            return type;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void updateType(Type type) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(type);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteType(Type type) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(type);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
