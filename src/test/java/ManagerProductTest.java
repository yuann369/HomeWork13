import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerProductTest {
    Book book1 = new Book(1, "1984", 2000, "Джордж Оруэлл");
    Book book2 = new Book(2, "Властелин колец", 3500, "Фицджеральд");
    Book book3 = new Book(3, "Великий Гэтсби", 3000, "Дж.Толкин");
    Book book4 = new Book(4, "Гэм", 1600, "Ремарк");
    Smartphone smartphone1 = new Smartphone(5, "Айфон", 80_000, "Apple");
    Smartphone smartphone2 = new Smartphone(6, "Гэлакси", 95_000, "Samsung");


    private RepoProduct repo = new RepoProduct();
    private ManagerProduct manager = new ManagerProduct(repo);


    @Test
    public void addTest() {
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = repo.getAll();
        Product[] expected = {book1, smartphone1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void addExceptionTest() {

        Assertions.assertThrows(AlreadyExistsException.class, () ->
        {
            manager.add(book1);
            manager.add(smartphone1);
            manager.add(book1);

        });
    }

    @Test
    public void find1ProductTest() {
        manager.add(book2);
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("он");
        Product[] expected = {smartphone1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void find2ProductTest() {
        manager.add(book2);
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("о");
        Product[] expected = {book2, smartphone1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void find3ProductTest() {
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Гэ");
        Product[] expected = {book3, book4, smartphone2};

        Assertions.assertArrayEquals(actual, expected);
    }
}
