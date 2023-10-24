package DataStructures.LinkedList.Problems;

public class RevKGroup {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();
        int  k = 2;
        reverseKGroups(list, k);
        list.display();
    }

    private static void reverseKGroups(LL list, int k) {
        
    }
}
