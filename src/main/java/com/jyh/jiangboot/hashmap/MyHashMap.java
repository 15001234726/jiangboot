package com.jyh.jiangboot.hashmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> implements MyMap<K, V> {


    //数组默认初始长度
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    //阈值比例
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultInitSize;
    private float defaultLoadFactor;

    //map中entry的数量
    private int entryUseSize;

    //数组
    private Entry<K, V>[] table = null;

    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int defaultInitialCapacity, float defaultLoadFactor) {

        if (defaultInitialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " +
            defaultInitialCapacity );
        }

        if (defaultLoadFactor <= 0 || Float.isNaN(defaultLoadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " +
            defaultLoadFactor);
        }

        this.defaultInitSize = defaultInitialCapacity;
        this.defaultLoadFactor = defaultLoadFactor;

        table = new Entry[this.defaultInitSize];



    }

    @Override
    public V put(K k, V v) {
        V oldValue = null;
        //是否需要扩容
        //扩容完毕 重新散列
        if (entryUseSize >= defaultInitSize * defaultLoadFactor) {
            resize(2 * defaultInitSize);
        }
        //得到hash值 计算数组中的位置
        int index = hash(k) & (defaultInitSize - 1);
        if (table[index] == null) {
            table[index] = new Entry<K, V>(k, v, null);
            ++entryUseSize;
        } else { // 遍历单链表
            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while (e != null) {
                if (k == e.getKey() || k.equals(e.getKey())) {
                    oldValue = e.value;
                    e.value = v;
                    return oldValue;
                }
                e = e.next;
            }
            table[index] = new Entry<K, V>(k, v, entry);
            ++entryUseSize;

        }
        return oldValue;
    }

    @Override
    public V get(K k) {
        int index = hash(k) & (defaultInitSize - 1);

        if (table[index] == null) {
            return null;
        } else {
            Entry<K, V> entry = table[index];
            do {
                if (k == entry.getKey() || k.equals(entry.getKey())) {
                    return entry.getValue();
                }
                entry = entry.next;
            } while (entry != null);
        }
        return null;
    }


    private int hash(K k) {
        int hashcode = k.hashCode();
        hashcode ^= (hashcode >>> 20) ^ (hashcode >>> 12);
        return hashcode ^ (hashcode >>> 7 ) ^ (hashcode >>> 4);
    }

    private void resize(int i) {
        //改变数组大小
        Entry[] newTable = new Entry[i];
        defaultInitSize = i;
        entryUseSize = 0;
        rehash(newTable);
    }

    private void rehash(Entry<K, V>[] newTable) {
        //得到原来entry集合
        List<Entry<K, V>> entryList = new ArrayList<Entry<K, V>>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                do {
                    entryList.add(entry);
                    entry = entry.next;
                } while (entry != null);
            }
        }
        //覆盖旧的引用
        if (newTable.length > 0 ) {
            table = newTable;
        }
        //重新put entry
        for (Entry<K, V> entry : entryList) {
            put(entry.getKey(), entry.getValue());
        }


    }


    class Entry<K, V> implements MyMap.Entry<K, V> {

        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry() {
        }

        public Entry(K key, V value, Entry<K, V> next) {
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

    }



}
