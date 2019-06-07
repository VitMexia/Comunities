import java.util.HashSet;

public class Vertex {

    public int id;
    public int rank;
    public HashSet<Integer> userID;

    public Vertex(int id){
        this.id = id;
        userID = new HashSet<>();
        rank = 0;
    }
}
