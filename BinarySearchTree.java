import java.util.Random;

/**
 * Binary Search Tree Implementation by William Trent Holliday
 * Data Structures - Fall 2014
 * Dr. Youming Li
 */
public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree(int[] arr){
        // Add each element to tree
        for(int i=0; i<arr.length; i++){
            addElement(new Node(arr[i]));
        }
    }

    /**
     * Adds the new node to the tree in the appropriate spot
     * @param newNode the node to be added
     */
    @Override
    public void addElement(Node newNode){
        if(isEmpty()) setRoot(newNode);
        else {
            Node current = getRoot();
            int newNodeData = newNode.getData();
            boolean isAdded = false;
            while(!isAdded) {
                if (current.getData() <= newNodeData) {
                    if(current.getRight() == null) {
                        current.addRight(newNode);
                        isAdded = true;
                    }
                    else current = current.getRight();
                }
                else{
                    if(current.getLeft() == null){
                        current.addLeft(newNode);
                        isAdded = true;
                    }
                    else current = current.getLeft();
                }
            }
        }
        super.addElement(newNode);
    }

    /**
     * Does In Order Traversal of the binary search tree to print out the sorted values
     * @param root the node in the tree to look at
     */
    public void inOrderTraverse(Node root){
        if(root != null){
            inOrderTraverse(root.getLeft());
            System.out.print(" " + root.getData());
            inOrderTraverse(root.getRight());
        }
    }

    public static void main(String[] args){
        int[] testArr = new int[40];
        Random random = new Random();
        System.out.println("====Binary Search Tree====");
        System.out.println("---Initial Array---");
        for(int i=0; i<testArr.length; i++){
            testArr[i]=random.nextInt(1000);
            System.out.print(testArr[i]+" ");
        }
        BinarySearchTree bst = new BinarySearchTree(testArr);
        System.out.println("\n---In Order Traversal---");
        bst.inOrderTraverse(bst.getRoot());
        System.out.println();
    }
}
