package stack.easy;
/*
You are keeping the scores for a baseball game with strange rules.
At the beginning of the game, you start with an empty record.

You are given a list of strings operations,
where operations[i] is the ith operation you must apply to the record and is one of the following:

An integer x.   Record a new score of x.
'+'.            Record a new score that is the sum of the previous two scores.
'D'.            Record a new score that is the double of the previous score.
'C'.            Invalidate the previous score, removing it from the record.

Return the sum of all the scores on the record after applying all the operations.
 */
import java.util.Stack;

public class BaseBallGame
{
    public int calPoints(String[] operations) {
        int result = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i<operations.length; i++) {
            int score = 0;
            String op = operations[i];

            if (op.charAt(0) >= '0' && op.charAt(0) <= '9' || op.charAt(0) == '-') {
                score = Integer.parseInt(op);
                st.push(score);
            }
            else if (op.charAt(0) == '+') {
                int last = st.pop();
                int secondLast = st.peek();
                int curr = last + secondLast;
                st.push(last);
                st.push(curr);
            }
            else if (op.charAt(0) == 'D') {
                int last = st.peek();
                score = last * 2;
                st.push(score);
            }
            else {
                st.pop();
            }
        }

        while (!st.isEmpty()) {
            result += st.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        BaseBallGame sol = new BaseBallGame();

        String[] operations = {"5", "2", "C", "D", "+"};
        int result = sol.calPoints(operations);

        System.out.println("Output: " + result); // Expected: 30
    }
}
