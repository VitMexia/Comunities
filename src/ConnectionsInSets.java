
import java.util.ArrayList;

public class ConnectionsInSets {

    private ArrayList<Integer> connectionCount;
    private double connectionAverage;

    public ConnectionsInSets(){
        connectionAverage = 0;
        connectionCount = new ArrayList<>();
    }

    public void addnewCount(int i){
        connectionCount.add(i);

        refreshAverage();
    }

    private void refreshAverage() {

        Integer sum = 0;

        if(!connectionCount.isEmpty()) {
            for (Integer con : connectionCount) {
                sum += con;
            }
            connectionAverage = sum.doubleValue() / connectionCount.size();
        }
    }

    public double getConnectionAvg(){
        return connectionAverage;
    }

}
