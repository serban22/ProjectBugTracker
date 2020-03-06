import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectService {
    private static ProjectService instance;

    private ProjectService() {

    }

    public static ProjectService getInstance() {
        if (instance == null) {
            instance = new ProjectService();
        }
        return instance;
    }

    public void createProject(Project project) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(project);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Project getProject(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Project project = session.find(Project.class, id);
            return project;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void updateProject(Project project) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(project);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteProject(Project project) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(project);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}