public class tester {
    public static void main(String[] args){
        DS5_BinarySearchTree<Integer> tree = new DS5_BinarySearchTree<>();
        int[] a = {20, 15, 6, 16, 1, 2, 5, 17, 12, 11};
        for (int j : a) {
            System.out.println(tree.insert(j));
        }
        System.out.println("removing...");
        for (int j:a){
            System.out.println(tree.preOrder());
            System.out.println(tree.remove(j));
        }





        System.out.println(tree.preOrder());
    }
}
