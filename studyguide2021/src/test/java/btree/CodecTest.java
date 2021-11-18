package btree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CodecTest {

    private static Codec codec;

    @BeforeAll
    public static void init() {
        codec = new Codec();
    }

    @Test
    public void testSerialize() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(4);
        root.right.right = new TreeNode<>(5);

        String coded = codec.serialize(root);
        String expected = "1,2,#,#,3,4,#,#,5,#,#";
        Assertions.assertEquals(expected, coded);
    }

    @Test
    public void testDeserialize() {
        String expected = "1,2,#,#,3,4,#,#,5,#,#";
        TreeNode<Integer> expectedTree = new TreeNode<>(1);
        expectedTree.left = new TreeNode<>(2);
        expectedTree.right = new TreeNode<>(3);
        expectedTree.right.left = new TreeNode<>(4);
        expectedTree.right.right = new TreeNode<>(5);

        TreeNode<Integer> root = codec.deserialize(expected);
        Assertions.assertEquals(expectedTree, root);
    }

    @Test
    public void testSerializeEmpty() {
        String coded = codec.serialize(null);
        String expected = "#";
        Assertions.assertEquals(expected, coded);
    }

    @Test
    public void testDeserializeSingleNode() {
        String tree = "1,#,#,";
        TreeNode<Integer> coded = codec.deserialize(tree);
        TreeNode<Integer> expected = new TreeNode(1);
        Assertions.assertEquals(expected, coded);
    }

    @Test
    public void testSerializeSingleNode() {
        TreeNode<Integer> root = new TreeNode<>(1);
        String coded = codec.serialize(root);
        String expected = "1,#,#,";
        Assertions.assertEquals(expected, coded);
    }

    @Test
    public void testSerializeTwoNodes() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        String coded = codec.serialize(root);
        String expected = "1,2,#,#,#,";
        Assertions.assertEquals(expected, coded);
    }

    @Test
    public void testDeserializeTwoNodes() {
        String data = "1,2,#,#,#,";

        TreeNode<Integer> expected = new TreeNode<>(1);
        expected.left = new TreeNode<>(2);

        TreeNode<Integer> coded = codec.deserialize(data);
        Assertions.assertEquals(expected, coded);
    }
}
