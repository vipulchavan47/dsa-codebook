package Trie;

public class TrieLearning {
    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26]; // a-z

            for(int i=0;i<26;i++){
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word){

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)- 'a';

            // if no data at that index create new node
            if(root.children[index] == null){
                root.children[index] = new Node();
            }
            // if last char in word
            if(i == word.length()-1){
                root.children[index].eow = true;
            }

            // else go to next level ( by making the curr level root for next level)
           root =  root.children[index];

        }
    }
}
