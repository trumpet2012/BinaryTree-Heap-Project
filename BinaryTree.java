/**
 * Created by William Trent Holliday
 */
public class BinaryTree {
    private Node root;
    private int numNodes;

    public Node getRoot(){
        return this.root;
    }

    public void setRoot(Node root){
        this.root = root;
        this.numNodes++;
    }

    public void addElement(Node newNode){
        this.numNodes++;
    }

    public boolean isEmpty(){
        return numNodes == 0;
    }

    public static class Node{
        private int data;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
            parent = null;
        }
        public void addLeft(Node left){
            this.left = left;
            left.parent = this;
        }
        public void addRight(Node right){
            this.right = right;
            right.parent = this;
        }
        public Node getLeft(){
            return this.left;
        }
        public Node getRight(){
            return this.right;
        }
        public int getData(){
            return this.data;
        }
        public void setData(int data){this.data = data;}
        public Node getParent(){
            return this.parent;
        }

        public String toString(){
            return ""+getData();
        }
    }
}
