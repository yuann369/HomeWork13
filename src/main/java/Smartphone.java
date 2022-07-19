public class Smartphone extends Product {
    private String producer;

    public Smartphone(int id, String name, int cost, String producer) {
        super(id, name, cost);
        this.producer = producer;
    }
}
