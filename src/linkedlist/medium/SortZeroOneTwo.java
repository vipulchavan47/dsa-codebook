package linkedlist.medium;

public class SortZeroOneTwo {
    /*
    static Node segregate(Node head) {
        // add your code here
        if(head == null || head.next == null){
            return head;
        }
        int zeroCounter = 0;
        int oneCounter = 0;
        int twoCounter = 0;

        Node temp = head;

        while(temp != null){
            if(temp.data == 0){
                zeroCounter++;
            }
            else if(temp.data == 1){
                oneCounter++;
            }
            else{
                twoCounter++;
            }
            temp = temp.next;
        }
        temp = head;

        for(int i=0;i<zeroCounter;i++){
            temp.data = 0;
            temp = temp.next;
        }
        for(int i=0;i<oneCounter;i++){
            temp.data = 1;
            temp = temp.next;
        }
        for(int i=0;i<twoCounter;i++){
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }
    */

    /*
    static Node segregate(Node head) {
        // add your code here
        if (head == null || head.next == null) {
            return head;
        }


        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        Node zero = zeroDummy;
        Node one = oneDummy;
        Node two = twoDummy;


        Node curr = head;
        while(curr != null) {
            if(curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            }
            else if(curr.data == 1) {
                one.next = curr;
                one = one.next;
            }
            else if(curr.data == 2) {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }


        zero.next = oneDummy.next != null ? oneDummy.next : twoDummy.next; // Connect 0s to 1s or 2s
        one.next = twoDummy.next;
        two.next = null;


        return zeroDummy.next;
    }
*/
}
