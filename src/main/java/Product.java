public class Product {
    protected int id;
    protected String title;
    protected int price;

    public Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    protected int getId() {
        return id;
    }

    protected String getTitle() {
        return title;
    }


}
