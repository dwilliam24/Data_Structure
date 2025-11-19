public class tester {
    public static void main(String[] args){
        DS5_BinarySearchTree<Integer> tree = new DS5_BinarySearchTree<>();
        System.out.println(tree.insert(7));
        System.out.println(tree.insert(6));
        System.out.println(tree.getRoot().getLeft().getData());
        System.out.println(tree.insert(5));
        System.out.println(tree.getRoot().getLeft().getLeft().getData());
        System.out.println(tree.insert(100));
        System.out.println(tree.contains(100));
    }
}
