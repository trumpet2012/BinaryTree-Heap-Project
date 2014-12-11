import java.util.Random;

/**
 * Heap implementation by William Trent Holliday
 * Data Structures - Fall 2014
 * Dr. Youming Li
 */
public class Heap{
    public int count; // var to store index of last element in heap
    private int[] heapArray;

    public Heap(int[] arr){
        count = 0;
        // initalize the heap array
        heapArray = new int[arr.length];
        // loop through the given array and add them to the heap
        for(int i=0; i<arr.length; i++){
            addElement(arr[i]);
        }
    }

    /**
     * Adds the specified integer to the last position in the heap.
     *
     * @param ele the integer value to add to the heap
     */
    private void addElement(int ele){
        heapArray[count] = ele;
        count++;
        heapifyAdd();
    }

    /**
     * Put the heap into proper heap order.
     *
     */
    private void heapifyAdd(){
        int temp;
        int next = count -1;
        while(next != 0 && heapArray[next] < heapArray[(next-1)/2]){
            temp = heapArray[next];
            heapArray[next]=heapArray[(next-1)/2];
            heapArray[(next-1)/2] = temp;
            next = (next-1)/2;
        }
    }

    /**
     * Gets the smallest value in the heap, which is the root of the tree
     *
     * @return the smallest value in the heap
     */
    private int removeMin(){
        int min = heapArray[0];
        heapArray[0] = heapArray[count-1];
        count--;
        if(count > 0)
            heapifyRemove(0); // Put in proper heap order
        return min;
    }

    /**
     * Puts the heap into proper heap order, since we just removed the root node.
     *
     * @param nodeIndex the position in the tree to look at
     */
    private void heapifyRemove(int nodeIndex){
        int leftChildIndex, rightChildIndex, minIndex, tmp;
        leftChildIndex = 2*nodeIndex+1;
        rightChildIndex = 2*nodeIndex+2;
        if (rightChildIndex >= count) {
            if (leftChildIndex >= count)
                return;
            else
                minIndex = leftChildIndex;
        } else {
            if (heapArray[leftChildIndex] <= heapArray[rightChildIndex])
                minIndex = leftChildIndex;
            else
                minIndex = rightChildIndex;
        }
        if (heapArray[nodeIndex] > heapArray[minIndex]) {
            tmp = heapArray[minIndex];
            heapArray[minIndex] = heapArray[nodeIndex];
            heapArray[nodeIndex] = tmp;
            heapifyRemove(minIndex);
        }
    }

    /**
     * Helper method to return the number of elements in the heap
     *
     * @return integer value representing size of heap
     */
    public int getCount(){
        return count;
    }

    public static void main(String[] args){
        System.out.println("====Heap====");
        int[] testArr = new int[40];
        Random random = new Random();
        System.out.println("---Initial Array---");
        for(int i=0; i<testArr.length; i++){
            testArr[i]=random.nextInt(1000);
            System.out.print(testArr[i]+" ");
        }
        Heap heap = new Heap(testArr);

        int count = heap.getCount();
        System.out.println("\n---Heap Sorted---");
        for(int i=0; i<count; i++){
            System.out.print(heap.removeMin() + " ");
        }
    }
}
