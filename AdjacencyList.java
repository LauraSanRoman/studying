import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class AdjacencyList {
  Node nodes[];
  int length;
  AdjacencyList (Node nodes[]){
    this.nodes = nodes;
    this.length = nodes.length;
  }
  private static class Node {
    private int value;
    private Node neighbors[];
    Node(int value, Node neighbors[]){
      this.value = value;
      this.neighbors = neighbors;
    };
  }
  public static void callerBFS(AdjacencyList list){
    Queue<Node> x = new LinkedList<Node>();
    Map<Integer, Boolean> visitedList = new HashMap<Integer,Boolean>();
    x.add(list.nodes[0]);
    BFS(list.nodes[0],visitedList,x);
  }
  private static void BFS(Node n, Map<Integer,Boolean> visitedList, Queue<Node> x){
    while(x.poll() != null){
      visitedList.put(n.value,true);
      System.out.println(n.value);
      for (int i = 0;i <n.neighbors.length ;i++ ) {
        if (visitedList.get(n.neighbors[i].value) == null ||visitedList.get(n.neighbors[i].value) == false) {
          x.add(n.neighbors[i]);
        }
      }
      BFS(x.peek(),visitedList,x);
    }
  }
  public static void main(String[] args) {
    Node[] nodeArray = new Node[0];
    Node two = new Node(2,nodeArray);
    Node five = new Node(5, nodeArray);
    Node four = new Node(4,nodeArray);
    Node six = new Node(6, nodeArray);

    Node[] nodeArray3 = {four};
    Node three = new Node(3,nodeArray3);
    Node[] nodeArray2 = {two, five,six};
    Node seven = new Node(7,nodeArray2);
    Node[] nodeArray1 = {three,seven};
    Node one = new Node(1,nodeArray1);



    Node listOfNodes[] = {one,two,three,four,five,six,seven};
    AdjacencyList nodesList = new AdjacencyList(listOfNodes);
    callerBFS(nodesList);
  }
}
