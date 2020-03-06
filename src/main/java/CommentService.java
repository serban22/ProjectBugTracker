import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentService {
    private static CommentService instance;

    private CommentService() {

    }

    public static CommentService getInstance() {
        if (instance == null) {
            instance = new CommentService();
        }
        return instance;
    }

    public void createComment(Comment comment) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(comment);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Comment getComment(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Comment comment = session.find(Comment.class, id);
            return comment;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void updateComment(Comment comment) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(comment);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteComment(Comment comment) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(comment);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}