import java.util.HashMap;
import java.util.Map;

public class DisjointSet2 {

    Map<Vertex,Node> elements=new HashMap<Vertex,Node>();

    class Node{

        Long rank;

        Vertex data;

        Node parent;

        Long size;

        public Node(Vertex data){
            rank=0L;
            this.data=data;
            this.parent=this;
            this.size=1L;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public Long getRank() {
            return rank;
        }

        public void setRank(Long rank) {
            this.rank = rank;
        }

        public Vertex getData() {
            return data;
        }

        public void setData(Vertex data) {
            this.data = data;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

    }
    public Node find(Node n){

        Node current=n;

        for(current=n.getParent();current!=current.getParent();current=current.getParent()){}

        if(n.getParent()!=current)
            n.setParent(current);

        return current;
    }

    public void mergeSet(Node u,Node v){

        Node representativeU=find(u);

        Node representativeV=find(v);

        if(representativeU != representativeV){

            int compare = representativeU.getRank().compareTo(representativeV.getRank());

            switch(compare){

                case 1:
                    representativeV.setParent(representativeU);
                    representativeU.setSize(representativeU.getSize()+representativeV.getSize());
                    break;

                case -1:
                    representativeU.setParent(representativeV);
                    representativeV.setSize(representativeV.getSize()+representativeU.getSize());
                    break;
                default:
                    representativeV.setParent(representativeU);
                    representativeU.setSize(representativeU.getSize()+representativeV.getSize());
                    representativeU.setRank(representativeU.getRank()+1);
                    break;
            }
        }
    }



}
