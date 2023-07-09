package java_project1;

public class Toy {
    private static int no;
    int id;
    int weight;
    String name;
    int count;
    { if (no<100) {no=100;}
        no=no+1;
    
    }
    public Toy(int weight, String name, int count) {
        this.weight = weight;
        this.name = name;
        this.count =count;
        this.id=no;
    }
    @Override
    public String toString() {
        return "Toy [id=" + id + ", count=" + count + ", weight=" + weight + ", name=" + name + "]";
    }
    public static int getNo() {
        return no;
    }
}
