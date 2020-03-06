import org.hibernate.Session;
import org.hibernate.Transaction;

public class StatusService {
    private static StatusService instance;

    private StatusService() {

    }

    public static StatusService getInstance() {
        if (instance == null) {
            instance = new StatusService();
        }
        return instance;
    }

    public void createStatus(Status status) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(status);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Status getStatus(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Status status = session.find(Status.class, id);
            return status;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void updateStatus(Status status) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(status);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteStatus(Status status) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(status);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
