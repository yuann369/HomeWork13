import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepoProductTest {

    Book book1 = new Book(1, "1984", 2000, "Джордж Оруэлл");
    Book book2 = new Book(2, "Властелин колец", 3500, "Фицджеральд");
    Smartphone smartphone1 = new Smartphone(5, "Айфон", 80_000, "Apple");

    private RepoProduct repo = new RepoProduct();

    @Test
    public void removeIdExceptionTest() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        Assertions.assertThrows(NotFoundException.class, () ->
        {
            repo.removeId(2000);

        });
    }

    @Test
    public void removeIdTest() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);

        Product[] actual = repo.removeId(2);
        Product[] expected = {book1, smartphone1};

        Assertions.assertArrayEquals(actual, expected);
    }

}
