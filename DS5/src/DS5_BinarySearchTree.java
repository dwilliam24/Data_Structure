

public class DS5_BinarySearchTree<E extends Comparable<E>> implements DS5_BinarySearchTree_Interface<E> {

    private DS5_BinarySearchTree_Node<E> root;

    public DS5_BinarySearchTree() {
        root = null;
    }

    public DS5_BinarySearchTree(E data) {
        root = new DS5_BinarySearchTree_Node<>(data);
    }

    @Override
    public DS5_BinarySearchTree_Node<E> getRoot() {
        return root;
    }

    @Override
    public String preOrder() {
        if (root == null) return "[]";
        return "[" + preOrderHelper(root).substring(2) + "]";
    }

    private String preOrderHelper(DS5_BinarySearchTree_Node<E> temp) {
        if (temp == null)
            return "";
        else
            return ", " + temp.getData() + preOrderHelper(temp.getLeft()) + preOrderHelper(temp.getRight());
    }

    @Override
    public String inOrder() {
        if (root == null) return "[]";
        return "[" + inOrderHelper(root).substring(2) + "]";
    }

    private String inOrderHelper(DS5_BinarySearchTree_Node<E> node) {
        if (node == null)
            return "";
        else
            return inOrderHelper(node.getLeft()) + ", " + node.getData() + inOrderHelper(node.getRight());
    }

    @Override
    public String postOrder() {
        if (root == null) return "[]";
        return "[" + postOrderHelper(root).substring(2) + "]";
    }

    private String postOrderHelper(DS5_BinarySearchTree_Node<E> node) {
        if (node == null)
            return "";
        else
            return postOrderHelper(node.getLeft()) + postOrderHelper(node.getRight()) + ", " + node.getData();
    }

    @Override
    public E minValue() {
        return minValueHelper(root);
    }

    private E minValueHelper(DS5_BinarySearchTree_Node<E> node) {
        E x = null;
        if (node == null) {
            return x;
        } else {
            x = node.getData();
            E a = minValueHelper(node.getLeft());
            E b = minValueHelper(node.getRight());
            if (a != null && a.compareTo(x) < 0) x = a;
            else if (b != null && b.compareTo(x) < 0) x = b;
        }
        return x;
    }

    @Override
    public E maxValue() {
        return maxValueHelper(root);
    }

    private E maxValueHelper(DS5_BinarySearchTree_Node<E> node) {
        E x = null;
        if (node == null) {
            return x;
        } else {
            x = node.getData();
            E a = maxValueHelper(node.getLeft());
            E b = maxValueHelper(node.getRight());
            if (a != null && a.compareTo(x) > 0) x = a;
            else if (b != null && b.compareTo(x) > 0) x = b;
        }
        return x;
    }

    @Override
    public int nodeDepth(Comparable value) {
        if (!contains(value)) return -1;
        if (value.equals(root.getData())) return 0;
        return nodeDepthHelper(root, value) - 1;
    }

    private int nodeDepthHelper(DS5_BinarySearchTree_Node<E> node, Comparable value) {
        int x = 0;
        if (node == null) {
            return 0;
        }
        if (value.compareTo(node.getData()) == 0) {
            return 1;
        }
        if (value.compareTo(node.getData()) > 0) {
            x += 1;
            x += nodeDepthHelper(node.getRight(), value);
        } else {
            x += 1;
            x += nodeDepthHelper(node.getLeft(), value);
        }
        return x;
    }

    @Override
    public int height() {
        return maxDepthHelper(root);
    }

    @Override
    public int maxDepth() {
        return maxDepthHelper(root) - 1;
    }

    private int maxDepthHelper(DS5_BinarySearchTree_Node<E> node) {
        int x = 0;
        int y = 0;
        if (node == null) {
            return 0;
        } else {
            x += 1;
            y += 1;
            y += maxDepthHelper(node.getLeft());
            x += maxDepthHelper(node.getRight());
        }
        return Math.max(y, x);
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public int size() {
        return sizeHelper(root);
    }

    private int sizeHelper(DS5_BinarySearchTree_Node<E> node) {
        int x = 0;
        if (node == null) {
            return 0;
        } else {
            x += 1;
            x += sizeHelper(node.getLeft());
            x += sizeHelper(node.getRight());
        }
        return x;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Comparable data) {
        if (root == null) return false;
        return ContainsHelper(root, data);
    }

    private boolean ContainsHelper(DS5_BinarySearchTree_Node<E> temp, Comparable data) {
        if (temp == null) {
            return false;
        }
        if (temp.getData().equals(data)) {
            return true;
        } else {
            return ContainsHelper(temp.getLeft(), data) || ContainsHelper(temp.getRight(), data);
        }
    }

    @Override
    public boolean insert(Comparable data) {
        if (contains(data)) {
            return false;
        }
        if (root == null) {
            root = new DS5_BinarySearchTree_Node<E>((E) data);
            return true;
        }
        return insertHelper(root, data);
    }

    private Boolean insertHelper(DS5_BinarySearchTree_Node<E> temp, Comparable data) {
        if (data.compareTo(temp.getData()) < 0) {
            if (temp.getLeft() == null) {
                temp.setLeft(new DS5_BinarySearchTree_Node<E>((E) data));
                return true;
            } else {
                boolean a = insertHelper(temp.getLeft(), data);
                if (a) return true;
            }
        } else {
            if (temp.getRight() == null) {
                temp.setRight(new DS5_BinarySearchTree_Node<E>((E) data));
                return true;
            } else {
                boolean a = insertHelper(temp.getRight(), data);
                if (a) return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Comparable data) {
        if (!contains(data)) return false;
        root = removeHelper(root, data);
        return true;
    }

    private DS5_BinarySearchTree_Node<E> removeHelper(DS5_BinarySearchTree_Node<E> node, Comparable data) {
        if (node == null) return null;
        int a = data.compareTo(node.getData());

        if (a < 0) {
            node.setLeft(removeHelper(node.getLeft(), data));
        } else if (a > 0) {
            node.setRight(removeHelper(node.getRight(), data));
        } else {
            if (node.getLeft() == null && node.getRight() == null)
                return null;

            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();

            DS5_BinarySearchTree_Node<E> after = smallestRight(node.getRight());
            node.setData(after.getData());
            node.setRight(removeHelper(node.getRight(), after.getData()));
        }

        return node;
    }


    public DS5_BinarySearchTree_Node<E> smallestRight(DS5_BinarySearchTree_Node<E> node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

}
