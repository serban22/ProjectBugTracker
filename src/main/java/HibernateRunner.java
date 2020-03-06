public class HibernateRunner {
    public static void main(String[] args) {
        ItemService itemService = ItemService.getInstance();
        Item newItem = new Item();
        newItem.itemTitle = "Vorbasareala";
        newItem.itemDescription = "Cand iti place sa vorbesti prea mult.";
        itemService.createItem(newItem);
        itemService.updateItem(newItem);
        System.out.println(newItem);
        itemService.deleteItem(newItem);
        Item item = itemService.getItem(2);
        System.out.println(item.itemTitle);

        CommentService commentService = CommentService.getInstance();
        Comment newComment = new Comment();
        newComment.commentText = "Cel mai misto curs de Java.";
        commentService.createComment(newComment);
        commentService.updateComment(newComment);
        System.out.println(newComment);
        commentService.deleteComment(newComment);
        Comment comment = commentService.getComment(3);
        System.out.println(comment.commentText);

        ProjectService projectService = ProjectService.getInstance();
        Project newProject = new Project();
        newProject.projectName = "JavaBuch69";
        newProject.projectDescription = "A 69-a grupa de Java de la SDA.";
        newProject.shortName = "JB69";
        projectService.createProject(newProject);
        projectService.updateProject(newProject);
        System.out.println(newProject);
        projectService.deleteProject(newProject);
        Project project = projectService.getProject(5);
        System.out.println(project.projectName + ", " +
                project.projectDescription + ", " + project.shortName);

        StatusService statusService = StatusService.getInstance();
        Status newStatus = new Status();
        newStatus.statusName = "Work in progress.";
        statusService.createStatus(newStatus);
        statusService.updateStatus(newStatus);
        System.out.println(newStatus);
        statusService.deleteStatus(newStatus);
        Status status = statusService.getStatus(1);
        System.out.println(status.statusId + ", " + status.statusName);

        TypeService typeService = TypeService.getInstance();
        Type newType = new Type();
        newType.typeName = "Semi-open";
        typeService.createType(newType);
        typeService.updateType(newType);
        System.out.println(newType);
        typeService.deleteType(newType);
        Type type = typeService.getType(4);
        System.out.println(type.typeName);

        HibernateUtil.shutdown();
    }
}
