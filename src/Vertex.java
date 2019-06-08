import java.util.HashSet;

public class Vertex {

    public int id;
    public int rank;
    public HashSet<Vertex> retweetsFrom;
    public ConnectionsInSets connectionAvg;

    public Vertex(int id){
        this.id = id;
        retweetsFrom = new HashSet<>();
        rank = 0;
        connectionAvg = new ConnectionsInSets();
        }

        public void addToConnectionAvg(int i){
            connectionAvg.addnewCount(i);
        }

        public double getConnectionAverage() {
            return connectionAvg.getConnectionAvg();
        }

}
