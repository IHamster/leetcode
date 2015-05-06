package com.bupt.jiameng.java_test;

/**
 * User: jiameng
 * Date: 15/4/30
 * Time: 下午6:01
 */
//实现简易hashmap
public class HashMap<K, V> {
  private static int DEF_CAPACITY = 16;
  private static double A = (Math.pow(5, 0.5) - 1) / 2;

  private int capacity;
  private int size = 0;

  private Node<K, V>[] buckets;

  //  默认构造函数
  public HashMap() {
    this(DEF_CAPACITY);
  }

  //  含参构造函数
  public HashMap(int capacity) {
    if (capacity <= 0)
      throw new IllegalArgumentException("capacity can not be nagetive or zero");

    int tmp = 1;
    //确保容量为2的n次方
    while (tmp < capacity) {
      tmp <<= 1;
    }
    this.capacity = tmp;
    buckets = new Node[this.capacity];
  }


  public void put(K key, V value) {
    if (key == null)
      throw new IllegalArgumentException("key can not be null");

    int position = getIndex(key);
    Node<K, V> node = buckets[position];

    while (node != null) {
      if (node.getKey().equals(key)) {
        node.setValue(value);
        return;
      }
      node = node.getNext();
    }
    Node<K, V> newNode = new Node<K, V>(key, value);

    if (buckets[position] != null) {
      newNode.setNext(buckets[position]);
    }

    buckets[position] = newNode;
    size++;
  }

  public Node<K, V> get(K key) {
    if (key == null)
      throw new IllegalArgumentException("key can not be null");

    int position = getIndex(key);
    Node<K, V> node = buckets[position];
    while (node != null) {
      if (node.getKey().equals(key))
        return node;
      node = node.getNext();
    }
    return node;
  }

  public void delete(K key) {
    if (key == null)
      throw new IllegalArgumentException("key can not be null");

    int position = getIndex(key);
    Node<K, V> node = buckets[position];
    if (node == null)
      return;
    if (node.getKey().equals(key)) {
      buckets[position] = node.getNext();
      size--;
      return;
    }

    while (node.getNext() != null) {
      if (node.getNext().getKey().equals(key)) {
        node.setNext(node.getNext().getNext());
        size--;
        return;
      }
      node = node.getNext();
    }
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");

    for (int i = 0; i < capacity; i++) {
      Node<K, V> node = buckets[i];
      while (node != null) {
        sb.append(node.getKey() + ":" + node.getValue() + ",");
        node = node.getNext();
      }
    }

    if (sb.length() > 1) {
      sb.delete(sb.length() - 2, sb.length());
    }
    sb.append("}");
    return sb.toString();
  }

  private int getIndex(K key) {
    int hashCode = key.hashCode();
    double tmp = hashCode * A;
    double digit = tmp - Math.floor(tmp);

    return (int) Math.floor(digit * DEF_CAPACITY);
  }

}

class Node<K, V> {
  private final K key;
  private V value;
  private Node next;//防止碰撞

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public Node<K, V> getNext() {
    return next;
  }

  public void setNext(Node<K, V> next) {
    this.next = next;
  }

  public K getKey() {
    return this.key;
  }

  public static void main(String[] args) {
    HashMap<String,String> hashMap = new HashMap<String, String>();
    hashMap.put("001","james");
    hashMap.put("002","antony");
    hashMap.put("003","bosh");
    hashMap.put("004","wade");
    hashMap.put("004","west");
    System.out.println(hashMap);
    System.out.println(hashMap.size());

    System.out.println(hashMap.get("001").getValue());
    hashMap.delete("001");
    System.out.println(hashMap);
  }
}
