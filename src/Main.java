public class Main {
    public static void main(String[] args) {
//        MyHashTable<Integer, Integer> table=new MyHashTable<>();
//        table.put(1, 1);
//        table.put(2, 2);
//        table.put(3, 3);
//        table.put(4, 4);
//        System.out.println(table.length);
//        System.out.println(table.remove(2));
//        System.out.println(table.length);
//        System.out.println(table.get(2));
//        System.out.println(table.getKey(4));
//        System.out.println(table.contains(3));
//        System.out.println(table.contains(2));

        BST<Integer, Integer> tree=new BST<>();
        tree.put(1, 1);
        tree.put(2, 2);
        tree.put(3, 3);
        tree.put(4, 4);
        System.out.println(tree.get(1));
        System.out.println(tree.get(2));
        System.out.println(tree.get(3));
        System.out.println(tree.get(4));
        tree.delete(3);
        System.out.println(tree.get(3));
    }
}