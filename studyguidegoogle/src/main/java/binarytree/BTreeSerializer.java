package binarytree;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BTreeSerializer<T extends Comparable<T>> {

    public static final String SERIALIZED_FILE_PATH = "/tmp/BTreeSerializer.txt";
    public static final String DELIMITER = ",";

    private static final String MARKER = "#";
    private final Path serializedTree = Paths.get(SERIALIZED_FILE_PATH);


    public BTreeSerializer() {

    }

    public List<String> serialize(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        serialize(node, sb);

        List<String> nodesData = new ArrayList<>();
        nodesData.add(sb.toString());

        saveToFile(nodesData);

        return nodesData;
    }

    private void serialize(BinaryTreeNode<T> node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data.toString() + DELIMITER);
            serialize(node.left, sb);
            serialize(node.right, sb);
        } else {
            sb.append(MARKER + DELIMITER);
        }

    }

    private void saveToFile(List<String> data) {
        try {
            if (Files.exists(serializedTree)) {
                Files.write(serializedTree, data, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
            } else {
                Files.write(serializedTree, data, Charset.forName("UTF-8"), StandardOpenOption.CREATE_NEW);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    public BinaryTreeNode<T> deserialize(String filePath, String delimiter) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException();
        }

        BinaryTreeNode<T> root = null;

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            Deque<String> nodes = new LinkedList<>();
            for (String line : lines) {
                String[] nodesValue = line.split(delimiter);

                nodes.addAll(Arrays.asList(nodesValue));
                root = buildTree(nodes);
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return root;
    }

    private BinaryTreeNode<T> buildTree(Deque<String> nodes) {

        if (nodes.isEmpty()) {
            return null;
        }

        String current = nodes.remove();
        if (current.trim().equals(MARKER)) {
            return null;
        }

        BinaryTreeNode<T> node = new BinaryTreeNode(current);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }
}
