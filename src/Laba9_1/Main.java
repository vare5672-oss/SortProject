package Laba9_1;

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int key;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    static Node root = null;

    static Node insert(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        return node;
    }

    static boolean has(Node node, int key) {
        while (node != null) {
            if (key == node.key) return true;
            node = (key < node.key) ? node.left : node.right;
        }
        return false;
    }

    static Node delete(Node node, int key) {
        if (node == null) return null;
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node min = node.right;
            while (min.left != null) min = min.left;
            node.key = min.key;
            node.right = delete(node.right, min.key);
        }
        return node;
    }

    static Integer next(Node node, int x) {
        Integer result = null;
        while (node != null) {
            if (node.key > x) {
                result = node.key;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return result;
    }

    static Integer prev(Node node, int x) {
        Integer result = null;
        while (node != null) {
            if (node.key < x) {
                result = node.key;
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String cmd = parts[0];
            int x = Integer.parseInt(parts[1]);

            switch (cmd) {
                case "insert":
                    root = insert(root, x);
                    break;
                case "delete":
                    if (has(root, x)) root = delete(root, x);
                    break;
                case "has":
                    sb.append(has(root, x) ? "t" : "f").append('\n');
                    break;
                case "next": {
                    Integer r = next(root, x);
                    if (r != null) sb.append(r).append('\n');
                    break;
                }
                case "prev": {
                    Integer r = prev(root, x);
                    if (r != null) sb.append(r).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
