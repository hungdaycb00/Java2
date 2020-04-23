package test23_4;

public class book {
    private int id;
    private String title;
    private String author;
    private String category;
    private float price;
    private int qty;
    private String date;
//public book(int id, String title, String author, String category, float price, int qty){
//    this.id = id;
//    this.title = title;
//    this.author = author;
//    this.category = category;
//    this.price = price;
//    this.qty = qty;
//
//}
    public void setPrice(float price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getQty() {
        return qty;
    }

    public float getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
