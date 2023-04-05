import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product book1 = new Book(1, "Master and Margarita", 350, "Bulgakov");
    Product book2 = new Book(5, "War and peace", 400, "Tolstoy");
    Product book3 = new Book(8, "White Bim", 200, "Troepolsky");
    Product smartphone1 = new Smartphone(214, "Iphone 10", 80_000, "Apple");
    Product smartphone2 = new Smartphone(64, "Iphone 11", 90_000, "Apple");
    Product smartphone3 = new Smartphone(512, "Iphone14", 100_000, "Apple");

    @Test
    public void shouldSaveAllProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSaveNotProducts() {
        ProductRepository repo = new ProductRepository();
        Product[] expected = {};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveTheOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(book3.getId());
        Product[] expected = {book1, book2, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldRemoveTheTwoProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(book3.getId());
        repo.removeById(smartphone2.getId());
        Product[] expected = {book1, book2, smartphone1, smartphone3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldDeleteAllProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(book1.getId());
        repo.removeById(book2.getId());
        repo.removeById(book3.getId());
        repo.removeById(smartphone1.getId());
        repo.removeById(smartphone2.getId());
        repo.removeById(smartphone3.getId());
        Product[] expected = {};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }
    @Test
    public void shouldNotDeleteTwoProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        repo.removeById(book2.getId());
        repo.removeById(book3.getId());

        repo.removeById(smartphone2.getId());
        repo.removeById(smartphone3.getId());
        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }
    @Test
    public void shouldSaveOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }
    @Test
    public void shouldSaveThreeSomeProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book3);
        repo.save(book3);
        repo.save(book3);

        Product[] expected = {book3, book3, book3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }
    @Test
    public void shouldRemoveAllSmartphone() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        repo.removeById(smartphone1.getId());
        repo.removeById(smartphone2.getId());
        repo.removeById(smartphone3.getId());
        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }
    @Test
    public void shouldNotRemoveOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(book1.getId());
        repo.removeById(book2.getId());
        repo.removeById(book3.getId());
        repo.removeById(smartphone1.getId());
        repo.removeById(smartphone2.getId());

        Product[] expected = {smartphone3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }
}