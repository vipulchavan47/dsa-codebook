package stack.medium;

/*
You are given an absolute path for a Unix-style file system,
which always begins with a slash '/'. Your task is to transform this
absolute path into its simplified canonical path.

The rules of a Unix-style file system are as follows:

    1.A single period '.' represents the current directory.
    2.A double period '..' represents the previous/parent directory.
    3.Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
    4.Any sequence of periods that does not match the rules above should be treated
      as a valid directory or file name. For example, '...' and '....' are valid directory or file names.

The simplified canonical path should follow these rules:

    1-The path must start with a single slash '/'.
    2-Directories within the path must be separated by exactly one slash '/'.
    3-The path must not end with a slash '/', unless it is the root directory.
    4-The path must not have any single or double periods ('.' and '..') used
      to denote current or parent directories.

Input: path = "/home/user/Documents/../Pictures"
Output: "/home/user/Pictures"

Input: path = "/../"
Output: "/"
 */

import java.util.Stack;

public class SimplifyUnixPath {
    public String simplifyPath(String path) {
        // split by / (directory)
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Skip empty and "."
                continue;
            } else if (part.equals("..")) {
                // Pop if we can go back
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Normal folder, add to path
                stack.push(part);
            }
        }

        // build the simplified path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // If result is empty, return root
        return result.length() == 0 ? "/" : result.toString();
    }

}
