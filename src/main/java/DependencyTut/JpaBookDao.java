package DependencyTut;

public class JpaBookDao implements BookDao {

    @Override
    public void saveBook(String author, String title) {
        System.out.println("JPA");
    }
}
