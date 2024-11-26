package Stack;
import java.util.Stack;

public class NextGreaterElement {
    private static int[] getResult(int[] inp) {
        int l = inp.length;
        Stack<Integer> stack = new Stack();
        int[] res = new int[l];
        for(int i = l-1; i >= 0; i--) {
            int num = inp[i];
            while(!stack.empty() && stack.peek() <= num) {
                stack.pop();
            }
            if(!stack.empty()){
                res[i] = stack.peek();
            }
            else {
                res[i] = -1;
            }
            stack.push(num);
        }
        return res;
    }
    private static void printRes(int[] res) {
        for(int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] input1 = {3,10,4,2,1,2,6,1,7,2,9};
        printRes(getResult(input1)); 
        int[] input2 = {5,7,1,7,6,0};
        printRes(getResult(input2));
    }
}
