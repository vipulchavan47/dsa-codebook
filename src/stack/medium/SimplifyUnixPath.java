package stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

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


/* (Simple idea)
 split by /
 if empty or . skip
 if .. pop 
 else push


*/
public class SimplifyUnixPath {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Deque<String> st = new ArrayDeque<>();

        for (String dir : str) {
            if(dir.isEmpty() || dir.equals(".")){
                continue;
            }

            if(dir.equals("..")){
                if(!st.isEmpty()){
                    st.removeLast();
                }
            } 
            else{
                st.addLast(dir);
            }
        }

        StringBuilder result = new StringBuilder();

        for(String dir : st){
            result.append("/").append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}
