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
        return "";
    }

    @Override
    public String postOrder() {
        return "";
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
        return 0;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Comparable data) {
        return false;
    }

    @Override
    public boolean insert(Comparable data) {
        if (root==null){
            root = new DS5_BinarySearchTree_Node<E>((E) data);
            return true;
        }
        else if(root.getLeft()==null&&data.compareTo(root.getData())>0){
            root.setRight(new DS5_BinarySearchTree_Node<E>((E) data));
            return true;
        }
        else if(root.getLeft()==null&&data.compareTo(root.getData())<0){
            root.setLeft(new DS5_BinarySearchTree_Node<E>((E) data));
            return true;
        }
        //insert(data);

        return false;
    }
    private DS5_BinarySearchTree_Node<E> insertHelper(DS5_BinarySearchTree_Node<E> temp, Comparable data)
    {
        if (temp.getLeft()!=null){
            insertHelper(temp,data);
        }
        if (temp.getRight()!=null){
            insertHelper(temp,data);
        }
        return 
    }

    @Override
    public boolean remove(Comparable data) {
        return false;
    }
}
