 public class Smartphone extends Product{
    private String vendor;

     protected Smartphone(int id, String title, int price, String vendor) {
         super(id, title, price);
         this.vendor = vendor;
     }



 }