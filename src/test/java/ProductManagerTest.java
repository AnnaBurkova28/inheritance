import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product book1 = new Book(1, "Master and Margarita", 350, "Bulgakov");
    Product book2 = new Book(5, "War and peace", 400, "Tolstoy");
    Product book3 = new Book(8, "White Bim", 200, "Troepolsky");
    Product smartphone1 = new Smartphone(214, "Iphone 10", 80_000, "Apple");
    Product smartphone2 = new Smartphone(64, "Iphone 11", 90_000, "Apple");
    Product smartphone3 = new Smartphone(512, "Iphone14", 100_000, "Apple");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldEmptyRequest() {
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.searchBy("");
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldSearchOneBook() {
        Product[] expected = {book3};
        Product[] actual = manager.searchBy("White Bim");
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void testWhenProductsFound() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product book1 = new Book(1, "Master and Margarita", 350, "Bulgakov");
        Product book2 = new Book(5, "War and peace", 400, "Tolstoy");
        Product book3 = new Book(8, "White Bim", 200, "Troepolsky");

        Product smartphone1 = new Smartphone(214, "Iphone 10", 80_000, "Apple");
        Product smartphone2 = new Smartphone(64, "Iphone 11", 90_000, "Apple");
        Product smartphone3 = new Smartphone(512, "Iphone14", 100_000, "Apple");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] expected = {book3};
        Product[] actual = manager.searchBy("White Bim");

        Assertions.assertArrayEquals(expected,actual);
    }







}