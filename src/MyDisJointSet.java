import java.util.*;


public class MyDisJointSet {

    public HashMap<String, Vertex> djsMap;
    public ArrayList<Vertex> idList;
    private HashSet<Vertex> communities;

    int connectioCount = 0;
    int connectioCount2 = 0;

    MaxAvgPair maxAvgPair = new MaxAvgPair();

    public int id = 0;

    private int setCount = -1;

    public MyDisJointSet(){
        djsMap = new HashMap<>();
        idList = new ArrayList<>();
        communities = new HashSet<>();
    }


    public void addConnection(String nameA, String nameB){

        if(!djsMap.containsKey(nameA)) {
            Vertex v = new Vertex(id++);
            djsMap.put(nameA, v);
            idList.add(v.id,v);
        }

        if(!nameB.equals("None") ){


            if (!djsMap.containsKey(nameB)) {
                Vertex v2 = new Vertex(id++);
                djsMap.put(nameB, v2);
                idList.add(v2.id, v2);
            }


            union(djsMap.get(nameA), djsMap.get(nameB));
        }

    }

    private void union(Vertex vertex, Vertex vertex1) {

        vertex1.retweetsFrom.add(vertex);

        connectioCount = 0;

        Vertex vroot = find(vertex);

        connectioCount2 = 0;

        Vertex v1root = find(vertex1);


        if(vroot == v1root) return;

        if(vroot.rank < v1root.rank){

            Vertex tmp = vroot;
            vroot = v1root;
            v1root = tmp;

            if(connectioCount2 >0) {

                vroot.addToConnectionAvg(connectioCount2);

                if (connectioCount2 > maxAvgPair.max) {
                    maxAvgPair.max = connectioCount2;
                    maxAvgPair.comunity = vroot;
                }
            }
        }
        else{

            if(connectioCount >0) {
                vroot.addToConnectionAvg(connectioCount);

                if(connectioCount > maxAvgPair.max){
                    maxAvgPair.max = connectioCount;
                    maxAvgPair.comunity = vroot;
                }
            }

        }

        idList.set(v1root.id, vroot);


        if(vroot.rank == v1root.rank)
            vroot.rank++;

    }


    private Vertex find(Vertex v){

        Vertex tmp = idList.get(v.id);

        while(tmp != v){
            connectioCount++;
            v = tmp;
            tmp = idList.get(v.id);

        }

        return v;
    }




    public int getCommunities(){
        if(setCount == -1) {

            for (Vertex v : idList) {
                if(communities.add(v))
                    v.connectionAvg.refreshAverage();
             }

            setCount = communities.size();
        }
        return setCount;
    }



    public int inSameCommunity(String user1, String user2){

       Vertex v1 = djsMap.get(user1);
       Vertex v2 = djsMap.get(user2);

        Vertex parent = idList.get(v1.id);

        if(parent == idList.get(v2.id))
           return parent.id;
       return -1;
    }




}
