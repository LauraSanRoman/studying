// Homework #1: Due Wednesday, January 31st by 8pm EST:
//
// Implement the following in Java:
//
// Node<T> returnMin( Node<T> root ) {
//   // print minimum value
//   // return minimum value and rebalance tree
// }
//
// Function will be called as:
// for(Node<T> iter=min(tree); iter != null; iter=min(tree) );
//
// Expected output: Tree contents in increasing order
//
// You will need to define your own BinarySearchTree class in Java. Follow the template below:

public class BinarySearchTree {
    private Node root;
    public BinarySearchTree(int arr[]){
      root = new Node(arr[0]);
      Node n = this.root;
      for (int i = 1;i < arr.length ; i++ ) {
        addItemToTree(arr[i],this.root);
      }
    }; // constructor
    private class Node {
      private int value;
      private Node left;
      private Node right;
      Node (int value) {
        this.value = value;
        left = null;
        right = null;
      };
    }
    public Node returnMin( Node root) {
      // get minimum value ( furthest most left leaf)
      Node returnNode = new Node(-1);
      for (Node n = root;n != null ; n = n.left ) {
        returnNode = n;
      };
      System.out.println(returnNode.value);
      return returnNode;
    };

    private void addItemToTree(int value, Node n){
      if( value < n.value ){
        if(n.left == null){
          n.left = new Node(value);
        }else{
          addItemToTree(value,n.left);
        }
      } else{
        if(n.right == null){
          n.right = new Node(value);
        }else{
          addItemToTree(value,n.right);
        }
      }
    }
    public static void main(String[] args) {
      int listOfValues[] = {8,3,10,1,6,4,7,14,13};
      BinarySearchTree tree = new BinarySearchTree(listOfValues);
      tree.returnMin(tree.root);
      tree.returnMin(tree.root);

    }
}
