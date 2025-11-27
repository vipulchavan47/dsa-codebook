package stack.medium;

import java.util.*;
public class AsteroidCollision {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            for (int asteroid : asteroids) {
                boolean destroyed = false;

                // Process left-moving asteroid (negative)
                while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                    int top = stack.peek();

                    // Compare sizes
                    if (Math.abs(asteroid) > top) {
                        // Right-moving asteroid destroyed, continue checking
                        stack.pop();
                    } else if (Math.abs(asteroid) == top) {
                        // Both destroyed
                        stack.pop();
                        destroyed = true;
                        break;
                    } else {
                        // Left-moving asteroid destroyed
                        destroyed = true;
                        break;
                    }
                }

                // Add asteroid if it wasn't destroyed
                if (!destroyed) {
                    stack.push(asteroid);
                }
            }

            // Convert stack to array
            int[] result = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }

            return result;
        }

        // Test cases
        public static void main(String[] args) {
            AsteroidCollision solution = new AsteroidCollision();

            // Test case 1
            int[] test1 = {5, 10, -5};
            System.out.println("Test 1: " + Arrays.toString(solution.asteroidCollision(test1)));
            // Expected: [5, 10]

            // Test case 2
            int[] test2 = {8, -8};
            System.out.println("Test 2: " + Arrays.toString(solution.asteroidCollision(test2)));
            // Expected: []

            // Test case 3
            int[] test3 = {10, 2, -5};
            System.out.println("Test 3: " + Arrays.toString(solution.asteroidCollision(test3)));
            // Expected: [10]

            // Test case 4
            int[] test4 = {-2, -1, 1, 2};
            System.out.println("Test 4: " + Arrays.toString(solution.asteroidCollision(test4)));
            // Expected: [-2, -1, 1, 2]

            // Test case 5
            int[] test5 = {-2, -2, 1, -2};
            System.out.println("Test 5: " + Arrays.toString(solution.asteroidCollision(test5)));
            // Expected: [-2, -2, -2]
        }
    }

