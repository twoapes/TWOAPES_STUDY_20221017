# LinkedHashMap

`LinkedHashMap` 是 Java 中的一个哈希表实现，它是 `HashMap` 的子类，并且保留了键值对的插入顺序。与 `HashMap` 不同，`LinkedHashMap` 内部使用一个双向链表维护键值对的顺序。下面是关于 `LinkedHashMap` 的一些概念解释：

1. 顺序保持：
`LinkedHashMap` 在内部使用一个双向链表来维护键值对的顺序。通过双向链表，它能够保持插入的顺序或者按照最近访问的顺序对键值对进行排序。

2. 访问顺序：
`LinkedHashMap` 可以按照最近访问的顺序对键值对进行排序。当一个键值对被访问时，它会被移动到链表的末尾，保证最近访问的键值对在链表的尾部。

3. 插入顺序：
`LinkedHashMap` 也可以保持键值对的插入顺序。当键值对被插入到 `LinkedHashMap` 中时，它们会按照插入的顺序连接在链表中。

4. 哈希表和链表结合：
`LinkedHashMap` 的内部实现结合了哈希表和双向链表。哈希表提供了快速的键值对查找和检索，而双向链表用于维护键值对的顺序。

`LinkedHashMap` 提供了与 `HashMap` 类似的功能，并额外提供了按照插入顺序或最近访问顺序对键值对进行迭代的能力。它适用于需要按照特定顺序访问键值对的场景，例如实现缓存淘汰策略、LRU（最近最少使用）缓存等。

- LinkedHashMap 是 HashMap 的子类

- 在HashMap存储结构的基础上，使用了一对双向链表来记录添加元素的顺序

- 与LinkedHashSet类似，LinkedHashMap 可以维护 Map 的迭代顺序

迭代顺序与 Key-Value 对的插入顺序一致

```java
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
```

```java
    static class Entry<K,V> extends HashMap.Node<K,V> {
        Entry<K,V> before, after;
        Entry(int hash, K key, V value, Node<K,V> next) {
            super(hash, key, value, next);
        }
    }
```
