package DataStructures.Stack.Problems;

import java.util.Stack;

public class GameOfTwoStacks {
    public static void main(String[] args) {
        // given two stacks
        // remove items from two such such that the sum does;nt exceed the maxSum
        // find the max number of moves that he can make
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();

        first.add(1);
        first.add(6);
        first.add(4);
        first.add(2);
        first.add(4);
        //
        second.add(5);
        second.add(8);
        second.add(1);
        second.add(2);
        //
        int maxSum = 10;

        int maxMoves = findMaxMoves(first, second, maxSum);
        System.out.println(maxMoves);
        // System.out.println(twoStack(first, second, 0, maxSum, 0));
    }

    // private static int twoStack(Stack<Integer> first, Stack<Integer> second, int sum, int maxSum, int count) {
    //     if (sum > maxSum) {
    //         return count;
    //     }

    //     if (first.isEmpty() || second.isEmpty()) {
    //         return count;
    //     }
    //     Stack<Integer> newFirst = first;
    //     Stack<Integer> newSec = second;
    //     int f = first.pop();
    //     int s = second.pop();
    //     int left = twoStack(newFirst, second, sum + s, maxSum, count++);
    //     int right = twoStack(first, newSec, sum + f, maxSum, count++);

    //     return Math.max(left, right);

    // }

    private static int findMaxMoves(Stack<Integer> first, Stack<Integer> second, int maxSum) {
        int moves = 0;
        int sum = 0;

        while (!first.isEmpty() && !second.isEmpty()) {
            if (first.peek() < second.peek()) {
                sum += first.pop();
            } else {
                sum += second.pop();
            }

            if (sum < maxSum) {
                moves++;
            } else {
                break;
            }
        }

        if (sum < maxSum) {
            while (!first.isEmpty()) {
                sum += first.pop();
                if (sum < maxSum) {
                    moves++;
                } else {
                    break;
                }
            }

            while (!second.isEmpty()) {
                sum += second.pop();
                if (sum < maxSum) {
                    moves++;
                } else {
                    break;
                }
            }
        }

        return moves;
    }
}
