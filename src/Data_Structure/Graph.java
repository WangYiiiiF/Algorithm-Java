package Data_Structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer,Nodes> nodes;
    public HashSet<Edges> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}

//图中某点的描述
class Nodes{
    public int value;
    public int in; //入度
    public int out; //出度
    public ArrayList<Nodes> nexts; //与该点相连的边
    public ArrayList<Edges> edges; //属于该店的边

    public  Nodes(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

//图中某边的描述
class Edges {
    public int weight; //权重
    public Nodes from; //边之起点
    public Nodes to; //边之终点

    public Edges(int weight, Nodes from, Nodes to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
