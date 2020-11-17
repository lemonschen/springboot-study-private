package top.uninut.core.practice;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CustomHashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable {

    private static final long serialVersionUID = 202011172050012320L;

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int TREEIFY_THRESHOLD = 8;

    static final int UNTREEIFY_THRESHOLD = 6;

    static final int MIN_TREEIFY_CAPACITY = 64;

    static class Node<K,V> implements Map.Entry<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash,K key,V value,Node<K,V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public final V setValue(V newVal) {
            V oldVal = value;
            value = newVal;
            return oldVal;
        }

        @Override
        public final int hashCode(){return Objects.hashCode(key) ^ Objects.hashCode(key);}

        @Override
        public final boolean equals(Object o){
            if(o == this)return true;
            if(o instanceof Map.Entry){
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
            }
            return false;
        }

        @Override
        public final String toString(){
            return key+"="+value;
        }
    }

    transient Node<K,V>[] table;

    transient Set<Map.Entry<K,V>> entrySet;

    transient int size;

    transient int modCount;

//    final float loadFactor;

    static final int tableSizeFor(int capacity){
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n<0)?1:(n>=MAXIMUM_CAPACITY)?MAXIMUM_CAPACITY:n+1;
    }

    int threshold;

//    public HashMap(int initialCapacity, float loadFactor){
//        if(initialCapacity<0)
//            throw new RuntimeException("容量不能为负数");
//        if(initialCapacity > MAXIMUM_CAPACITY)initialCapacity = MAXIMUM_CAPACITY;
//        if(loadFactor <= 0 || Float.isNaN(loadFactor))
//            throw new RuntimeException("负载因子不能<=0");
//        this.loadFactor = loadFactor;
//        this.threshold = tableSizeFor(initialCapacity);
//    }

    static final int hash(Object key){
        int h;
        return (key == null)?0:(h = key.hashCode()) ^ (h >>> 16);
    }

//    public V put(K key, V value){
//        return putVal(hash(key), key,value ,false, true);
//    }

//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict){
//        Node<K,V>[] tab;Node<K,V> p;int n, i;
//        if((tab = table) == null || (n = tab.length) == 0)
//    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }
}
