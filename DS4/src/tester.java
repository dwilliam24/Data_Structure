public class tester {
    public static void main(String[] args){
        DS4_HashTable<Integer, Integer> a = new DS4_HashTable<>(4,16,4);
        a.insert(2,9);
        System.out.println(a.contains(2));
        a.print();
    }

}
