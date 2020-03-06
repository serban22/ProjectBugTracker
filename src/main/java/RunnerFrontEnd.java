import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class RunnerFrontEnd {
    public static void main(String[] args) {
        ProjectService projectService = ProjectService.getInstance();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        printWelcomeText();
        Scanner input = new Scanner(System.in);
        printMainMenu();
        int mainMenuChoice = input.nextInt();
        int chooseOption;

        switch (mainMenuChoice) {
            case 1:
                System.out.println("Project menu chosen. Redirecting... ");
                printProjectMenu();
                chooseOption = input.nextInt();
                if (chooseOption < 0 || chooseOption > 4) {
                    System.out.println("That option doesn't exist. Try again.");
                    break;
                } else if (chooseOption == 1) {
                    Transaction transaction = session.beginTransaction();
                    Query query = session.createQuery("from Project");
                    List<Project> projectList = query.list();
                    for (Project listProject : projectList) {
                        System.out.println("Project list: " + listProject.projectId + ", " + listProject.projectName);
                    }
                    transaction.rollback();
                    sessionFactory.close();
                } else if (chooseOption == 2) {
                    Transaction transaction = session.beginTransaction();
                    Query query = session.createQuery("from Project");
                    List<Project> projectList = query.list();
                    for (Project statusProject : projectList) {
                        System.out.println("Project statuses: " + statusProject.varStatus + ", " + statusProject.projectId + ", " + statusProject.projectName);
                    }
                    transaction.rollback();
                    sessionFactory.close();
                } else if (chooseOption == 3) {
                    String newName = input.nextLine();
                    String newDescription = input.nextLine();
                    String newShortName = input.nextLine();
                    Transaction transaction = session.beginTransaction();
                    Project newProject = new Project();
                    newProject.projectName = newName;
                    newProject.projectDescription = newDescription;
                    newProject.shortName = newShortName;
                    projectService.createProject(newProject);
                    session.update(newProject);
                    transaction.commit();
                } else if (chooseOption == 4) {
                    Transaction transaction = session.beginTransaction();
                } else {
                    printMainMenu();
                }
                break;
            case 2:
                System.out.println("Status menu chosen. Redirecting... ");
                printStatusMenu();
                chooseOption = input.nextInt();
                if (chooseOption < 0 || chooseOption > 4) {
                    System.out.println("That option doesn't exist. Try again.");
                    break;
                } else if (chooseOption == 1) {
                    Transaction transaction = session.beginTransaction();
                    Query query = session.createQuery("from Status");
                    List<Status> statusList = query.list();
                    for (Status listStatus : statusList) {
                        System.out.println("List of statuses: " + listStatus.statusId + ", " + listStatus.statusName);
                    }
                    transaction.rollback();
                    sessionFactory.close();
                } else {
                    printMainMenu();
                }
                break;
            case 3:
                System.out.println("Type menu chosen. Redirecting...");
                printTypeMenu();
                chooseOption = input.nextInt();
                if (chooseOption < 0 || chooseOption > 4) {
                    System.out.println("That option doesn't exist. Try again.");
                    break;
                } else if (chooseOption == 1) {
                    Transaction transaction = session.beginTransaction();
                    Query query = session.createQuery("from Type");
                    List<Type> typeList = query.list();
                    for (Type listType : typeList) {
                        System.out.println("List of types: " + listType.typeId + ", " + listType.typeName);
                    }
                    transaction.rollback();
                    sessionFactory.close();
                } else {
                    printMainMenu();
                }
                break;
            default:
                System.out.println("That option doesn't exist. Try again.");
                HibernateUtil.shutdown();
                System.exit(0);
        }
    }

    private static void printWelcomeText() {
        System.out.println("WELCOME TO THE SDA BUG-TRACKING SOFTWARE, VERSION 1.0!\n");
    }

    private static void printMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1. Project menu." + "\n2. Status menu." + "\n3. Type menu.");
        System.out.print("Please choose an option: ");
    }

    private static void printProjectMenu() {
        System.out.println("PROJECTS MENU" + "\n1. List projects." + "\n2. Status of projects." + "\n3. Add project." +
                "\n4. Delete project." + "\n0. Back to main menu.");
        System.out.print("Please choose an option: ");
    }

    private static void printStatusMenu() {
        System.out.println("STATUS MENU" + "\n1. List statuses." + "\n0. Back to main menu.");
        System.out.print("Please choose an option: ");
    }

    private static void printTypeMenu() {
        System.out.println("TYPE MENU" + "\n1. List types." + "\n0. Back to main menu.");
        System.out.print("Please choose an option: ");
    }
}
