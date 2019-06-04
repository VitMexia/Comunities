import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DisjointSet {

    private HashMap<String, String> parent;
    private HashMap<String, Integer> rank;
    public int count;

    public DisjointSet() {

       parent = new HashMap<>();
       rank = new HashMap<>();

    }

    public void addNewDisjointSet(String user )
    {
        if(user != null){
            parent.put(user, user);
            rank.put(user, 0);
        }
    }

    public String find(String user){

        String root = findRoot(user);
        parent.put(user, root);
        return root;

    }

    private String findRoot(String user) {

        String tmp = parent.get(user);

        if(tmp != user){
            return find(tmp);
        }
        else return user;
    }

    public void union(String user1, String user2){

        if(user1.equals(user2)) return;

        String p1 = find(user1);
        String p2 = find(user2);

        if(p1 == null || p2 == null) return;

        if(p1.equals(p2)) return;

        int rankP1 = rank.get(p1);
        int rankP2 = rank.get(p2);

        if(rankP1 > rankP2){
            parent.put(p2,p1);
        }
        else if(rankP2 > rankP1){
            parent.put(p1, p2);
        }
        else{
            parent.put(p1, p2);
            rank.put(p2, ++rankP2);
        }





    }

    public String printALl(){
        return rank.values().toString();
    }

}
