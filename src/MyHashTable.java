public class MyHashTable <K extends Comparable<K>, V>{
    private class HashNode<K extends Comparable<K>, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.value=value;
            this.key=key;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] buckets;
    private int capacity=7;
    public int length=0;
    private float loadFactor= 0.75F;

    public MyHashTable(){
        buckets=new HashNode[capacity];
    }

    public MyHashTable(int initialCapacity){
        capacity= (int) (loadFactor*initialCapacity);
        buckets=new HashNode[capacity];
    }

    private void resize() {
        capacity = 2 * buckets.length;
        HashNode<K, V>[] oldTable = buckets;
        buckets = new HashNode[capacity];
        length = 0;
        for (int i = 0; i < oldTable.length; i++){
            if (oldTable[i] != null) {
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }

    private int hash(K key){
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    public void put(K key, V value){
        if(buckets.length/capacity==1){
            resize();
        }
        HashNode<K, V> newNode=new HashNode<>(key, value);
        int index=hash(key);
        if(buckets[index]==null){
            buckets[index]=newNode;
        }else{
            newNode.next=buckets[index];
            buckets[index]=newNode;
        }
        length++;
    }

    public V get(K key){
        int index=hash(key);
        HashNode<K, V> node=buckets[index];
        if(node==null){
            return null;
        }else{
            while(!node.key.equals(key) && node.next!=null){
                node=node.next;
            }
        }
        return (V) node.value;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = buckets[index];
        HashNode<K, V> prev = null;
        while(!node.key.equals(key) && node.next!=null){
            prev=node;
            node=node.next;
        }

        if (node == null)
            return null;

        if (prev != null)
            prev.next = node.next;
        else{
            buckets[index]=node.next;
        }
        length--;
        return node.value;
    }

    public boolean contains(V value){
        if(getKey(value)!=null) return true;
        return false;
    }

    public K getKey(V value){
        for(int i=0; i<length; i++){
            if(buckets[i].value.equals(value) && buckets[i].value!=null){
                return buckets[i].key;
            }
        }
        return null;
    }
}