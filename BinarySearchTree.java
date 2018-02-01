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
    public BinarySearchTree(){
      root = null;
    }
    public BinarySearchTree(int arr[]){
      root = new Node(arr[0],null);
      for (int i = 1;i < arr.length ; i++ ) {
        addItemToTree(arr[i],this.root);
      }
    }; // constructor
    private class Node {
      private int value;
      private Node left;
      private Node right;
      private Node parent;
      Node (int value,Node parent) {
        this.value = value;
        left = null;
        right = null;
        parent = parent;
      };
    }
    public Node returnMin() {
        Node minNode = this.root;
        for (minNode = root;minNode.left != null ;minNode = minNode.left ) {
        }
        if(minNode.value == this.root.value){
          this.root = remove(minNode.value, root);
        }else{
          remove(minNode.value, root);
        }
        System.out.println(minNode.value);
        return minNode;
    };

    private Node remove(int value, Node root){
      if(root == null){
        return null;
      }
      if(root.value < value){
        root.right = remove(value,root.right);
      }
      if(root.value > value){
        root.left = remove(value, root.left);
      }
      if(root.right != null){
        return root.right;
      }else{
        return remove(value,root.right);
      }
    }

    private void addItemToTree(int value, Node n){
      if( value < n.value ){
        if(n.left == null){
          n.left = new Node(value,n);
        }else{
          addItemToTree(value,n.left);
        }
      } else{
        if(n.right == null){
          n.right = new Node(value,n);
        }else{
          addItemToTree(value,n.right);
        }
      }
    }
    public static void main(String[] args) {
      int listOfValues[] = {3,1,5,4,9,10,2,6,7,8};
      BinarySearchTree tree = new BinarySearchTree(listOfValues);
      while(tree.root != null){
        tree.returnMin();
      }
    }
}
