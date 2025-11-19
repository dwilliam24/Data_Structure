

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
    public String preOrder()
    {
        if(root==null)
            return "[]";
        return "["+preOrderHelper(root).substring(2)+"]";
    }

    private String preOrderHelper(DS5_BinarySearchTree_Node<E> temp)
    {
        if(temp==null)
            return "";
        else
            return ", "+temp.getData() +
                    preOrderHelper(temp.getLeft()) +
                    preOrderHelper(temp.getRight());
    }

    @Override
    public String inOrder() {
        return "[]";
    }

    @Override
    public String postOrder() {
        return "[]";
    }

    @Override
    public E minValue() {
        return null;
    }

    @Override
    public E maxValue() {
        return null;
    }

    @Override
    public int nodeDepth(Comparable value) {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int maxDepth() {
        if (root==null){
            return -1;
        }
        return 0;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public int size() {
        /*
        String a = preOrder();
        a=a.substring(1,a.length()-1);
        String[] f =a.split(", ");
        System.out.println(Arrays.toString(f));
        return f.length;
        */
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Comparable data) {
        if (root==null) return false;
        return ContainsHelper(root,data);
    }
    private boolean ContainsHelper(DS5_BinarySearchTree_Node<E> temp, Comparable data)
    {
        if(temp==null) {
            return false;
        }
        if (temp.getData().equals(data))
        {
            return true;
        }
        else {
            return ContainsHelper(temp.getLeft(), data)||ContainsHelper(temp.getRight(), data);
        }


    }

    @Override
    public boolean insert(Comparable data) {
        if (contains(data)){return false;}
        if (root==null){
            root = new DS5_BinarySearchTree_Node<E>((E) data);
            return true;
        }
        return insertHelper(root,data);
    }
    private Boolean insertHelper(DS5_BinarySearchTree_Node<E> temp, Comparable data)
    {
        if (data.compareTo(temp.getData()) < 0){
            if (temp.getLeft()==null){
                temp.setLeft(new DS5_BinarySearchTree_Node<E>((E) data));
                return true;
            }
            else {
                boolean a = insertHelper(temp.getLeft(),data);
                if (a) return true;
            }
        }
        else {
            if (temp.getRight()==null){
                temp.setRight(new DS5_BinarySearchTree_Node<E>((E) data));
                return true;
            }
            else {
                boolean a = insertHelper(temp.getRight(),data);
                if (a) return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Comparable data) {
        return false;
    }
}
