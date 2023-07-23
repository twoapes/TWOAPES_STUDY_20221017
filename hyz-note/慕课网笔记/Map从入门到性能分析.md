# Map从入门到性能分析

## Map初识

### Map通用方法

Map接口及其实现类

![1689144400092](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/1689144400092.png)

● V put(K key,V value):存入Map中一个key/value映射

● V get(Object key):返回到指定键所映射的值

● V remove(Object key):从该Map中删除一个键的映射

● boolean containsKey(Object key):是否包含指定键的key

## HashMap的使用

### HashMap的构造方法

● HashMap()

● HashMap(int initialCapacity)

● HashMap(int initialCapacity, float loadFactor)

负载因子:指定Map对象在什么情况下扩容

initialCapacity:指定初始化大小

### HashMap的基本用法

```java
//key是限定为String类型,Value是Object
Map<String, Object> map = new HashMap<>();
```

### 创建HashMap对象

● Map<String, Object> map = new HashMap<>();

● map.put("张三",Integer.valueOf(120));

● map.get("张三")

```java
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //java会自动封装,可以无需new Integer或Integer.valueOf
        map.put("张三", 120);
        map.put("张三2", 140);
        System.out.println(map.get("张三"));
        System.out.println(map.get("张三2"));
    }
```

### HashMap的Entry结构

![1689144275651](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/1689144275651.png)

🤣原来1.8中的定义改了,改成了Node<K,V>,如下是jdk1.8.0_241的源代码,慕课网没提这一点,应该是没看1.8的源代码,没事,我们补上....

1.7及其之前是Entry<K,V>,所以1.8和之后不支持创建对象的时候使用 new HashMap<K,V>(),而只能使用new HashMap()

```java
     /**
     * Basic hash bin node, used for most entries.  (See below for
     * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
     */
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

### HashMap例题1

```java
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zhang1", 120);
        map.put("zhang2", 130);
        map.put("zhang3", 140);
        map.put("zhang4", 150);
        map.put("zhang5", 160);
        System.out.println(map);
    }
```

### HashMap遍历-keySet

```java
import java.util.HashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = map();
        showMap(map);
    }
    /**
     * 利用keySet方法遍历
     * @param map
     */
    private static void showMap(Map<String, Integer> map) {
        //既能获取到key,又能获取到value
        for (String s : map.keySet()) {
            System.out.println(s + ":" + map.get(s));
        }
    }
    private static Map<String, Integer> map() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zhang1", 120);
        map.put("zhang2", 130);
        map.put("zhang3", 140);
        map.put("zhang4", 150);
        map.put("zhang5", 160);
        return map;
    }
}
```

### HashMap遍历-values

```java
import java.util.HashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = map();
//        showMap(map);
        showMap2(map);
    }
    /**
     * 利用values方法遍历
     *
     * @param map
     */
    private static void showMap2(Map<String, Integer> map) {
        //只能获取到value
        for (Integer s : map.values()) {
            System.out.println(s);
        }
    }
    private static Map<String, Integer> map() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zhang1", 120);
        map.put("zhang2", 130);
        map.put("zhang3", 140);
        map.put("zhang4", 150);
        map.put("zhang5", 160);
        return map;
    }
}
```

### HashMasp遍历-entrySet

```java
import java.util.HashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = map();
//        showMap(map);
//        showMap2(map);
        showMap3(map);
    }
    /**
     * 利用entrySet方法遍历
     *
     * @param map map
     */
    private static void showMap3(Map<String, Integer> map) {
        //既能获取到key,又能获取到value
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            System.out.println(set.getKey() + ":" + set.getValue());
        }
    }
    private static Map<String, Integer> map() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zhang1", 120);
        map.put("zhang2", 130);
        map.put("zhang3", 140);
        map.put("zhang4", 150);
        map.put("zhang5", 160);
        return map;
    }
}
```

### HashMasp遍历-iterator

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = map();
//        showMap(map);
//        showMap2(map);
//        showMap3(map);
        showMap4(map);
    }
    /**
     * 利用iterator方法遍历
     *
     * @param map map
     */
    private static void showMap4(Map<String, Integer> map) {
        //既能获取到key,又能获取到value
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> set = it.next();
            System.out.println(set.getKey() + ":" + set.getValue());
        }
    }
    private static Map<String, Integer> map() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zhang1", 120);
        map.put("zhang2", 130);
        map.put("zhang3", 140);
        map.put("zhang4", 150);
        map.put("zhang5", 160);
        return map;
    }
}
```

### HashMasp遍历-性能分析

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = map();
        long start1 = showMap(map);
        long start2 = showMap2(map);
        long start3 = showMap3(map);
        long start4 = showMap4(map);
        long end = System.currentTimeMillis();
        System.out.println("keySet耗时:" + (end - start1));
        System.out.println("values耗时:" + (end - start2));
        System.out.println("entrySet耗时:" + (end - start3));
        System.out.println("iterator耗时:" + (end - start4));
    }
    /**
     * 利用keySet方法遍历
     *
     * @param map map
     */
    private static long showMap(Map<String, Integer> map) {
        long start = System.currentTimeMillis();
        //既能获取到key,又能获取到value
        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }
        return start;
    }
    /**
     * 利用values方法遍历
     *
     * @param map map
     */
    private static long showMap2(Map<String, Integer> map) {
        long start = System.currentTimeMillis();
        //只能获取到value
        for (Integer s : map.values()) {
            System.out.println(s);
        }
        return start;
    }
    /**
     * 利用entrySet方法遍历
     *
     * @param map map
     */
    private static long showMap3(Map<String, Integer> map) {
        long start = System.currentTimeMillis();
        //既能获取到key,又能获取到value
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            System.out.println(set.getValue());
        }
        return start;
    }
    /**
     * 利用iterator方法遍历
     *
     * @param map map
     */
    private static long showMap4(Map<String, Integer> map) {
        long start = System.currentTimeMillis();
        //既能获取到key,又能获取到value
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> set = it.next();
            System.out.println(set.getValue());
        }
        return start;
    }
    private static Map<String, Integer> map() {
        Map<String, Integer> map = new HashMap<>();
        String string[] = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
        String key;
        Integer value;
        for (int i = 0; i < 100000; i++) {
            int m = (int) (Math.random() * string.length);
            key = String.valueOf(string[m] + i * 100);
            value = i;
            map.put(key, value);
        }
        return map;
    }
}
```

以本机输出结果为例:

keySet耗时:3780

values耗时:2903

entrySet耗时:1950

iterator耗时:680

普遍情况下iterator效率是最高的,最差是keySet

单纯的获取value值的时候,values性能不见得较低

entrySet性能即不是很差也不是效率最高,但是是最常用的

计算机随机分配资源,所以时间消耗略有差异,这一点不影响上面的结论

## HashMap的原理

### HashMap例题2

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> zhang1 = new HashMap<>();
        zhang1.put("yuwen", 90);
        zhang1.put("shuxue", 80);
        zhang1.put("lishi", 72);
        Map<String, Integer> zhang2 = new HashMap<>();
        zhang2.put("yuwen", 74);
        zhang2.put("shuxue", 60);
        zhang2.put("lishi", 85);
        Map<String, Integer> zhang3 = new HashMap<>();
        zhang3.put("yuwen", 83);
        zhang3.put("shuxue", 75);
        zhang3.put("lishi", 69);
        Map<String, Integer> zhang4 = new HashMap<>();
        zhang4.put("yuwen", 91);
        zhang4.put("shuxue", 85);
        zhang4.put("lishi", 82);
        Map<String, Integer> zhang5 = new HashMap<>();
        zhang5.put("yuwen", 85);
        zhang5.put("shuxue", 97);
        zhang5.put("lishi", 77);
        map.put("zhang1", zhang1);
        map.put("zhang2", zhang2);
        map.put("zhang3", zhang3);
        map.put("zhang4", zhang4);
        map.put("zhang5", zhang5);
        System.out.println(map);
        ArrayList<Map<String, Integer>> arrayList=new ArrayList<>();
        arrayList.add(zhang1);
        arrayList.add(zhang2);
        arrayList.add(zhang3);
        arrayList.add(zhang4);
        arrayList.add(zhang5);
        System.out.println(arrayList);
    }
}
```

### HashMap底层原理

● HashMap的结果输出和put的存值顺序无关

● HashMap的结果输出也不是随机输出

```java
import java.util.HashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(120, "a");
        System.out.println(120 % 16);
        map.put(37, "a");
        System.out.println(37 % 16);
        map.put(61, "a");
        System.out.println(61 % 16);
        map.put(40, "a");
        System.out.println(40 % 16);
        map.put(92, "a");
        System.out.println(92 % 16);
        map.put(78, "a");
        System.out.println(78 % 16);
        System.out.println(map);
    }
}
```

● hash值除以16(初始化长度默认是16)后的余数,决定HashMap的结果输出顺序

```java
static final int hash(Object key);//获取hash码
static int indexFor(int h, int length)
```

● public HashMap(int initialCapacity, float loadFactor)

```txt
initialCapacity默认是16(长度)
loadFactor默认是0.75 (负载因子) 占了75%后会扩容
所以无参相当于new HashMap(16,0.75f)
扩容是2的倍数,所以是16,32,64...以此类推重新进行排列后扩容
1.8的版本不存在indexFor方法了,需要注意
```

### HashMap带参的构造方法

● public HashMap(int initialCapacity)

new HashMap(3);//长度小于等于2的n次方,大于initialCapacity的整数值,即实际为4

● public HashMap(int initialCapacity, float loadFactor)

loadFactor //控制扩充的时间点(负债因子),不包含节点被重复使用的情况

0.75是比较合理的默认值,一般情况下不改变

```java
import java.util.HashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += new Test().initHashMap(16384, 0.75f);
        }
        //第一次会做JVM内存处理和初始化,所以会慢点
        //16长度时    278787170 267080060
        //16384长度时 268299820 250944050
        System.out.println("平均时间:" + sum / 10);
    }
    private long initHashMap(int initialCapacity, float loadFactor) {
        Map<String, String> map = new HashMap<>(initialCapacity, loadFactor);
        String key, value;
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            key = String.valueOf(i);
            value = "value";
            map.put(key, value);
        }
        long time = System.nanoTime() - start;
        System.out.println("(initialCapacity:" + initialCapacity + ",loadFactor:" + loadFactor + ")time:" + time);
        return time;
    }
}
```

明显一定的扩容可以优化HashMap的性能

但一般情况下已经足矣,很少去做扩容

### HashMap的常用方法

● 判断是否为空,删除结点,清空HashMap对象

● 判断是否有某个key,判断是否有某个value

● HashMap替换某个key的value

```java
import java.util.HashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("x", "123");
        map.put("y", "456");
        if (map != null && map.isEmpty()) {
            System.out.println("map为空或null");
        } else {
            System.out.println("map不为空或null");
        }
        if (map.containsKey("x")) {
            System.out.println("key包含x");
        }
        if (map.containsValue("123")) {
            System.out.println("value包含123");
        }
        //map.replace("x","999");
        map.replace("x", "123", "999");
        //map.put("x","666"); //put是存在key则更新,不存在则新增
        //map.putIfAbsent("x","666"); //put是存在key则做任何操作,不存在则新增
        //map.remove("y");
        map.remove("y", "456");
        //map.clear();
        System.out.println(map);
    }
}
```

● default void forEach(BiConsumer<? super K, ? super V> action)

● default V getOrDefault(Object key, V defaultValue)

```java
import java.util.HashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(120, "a");
        map.put(37, "a");
        map.put(61, "a");
        map.put(40, "a");
        map.put(92, "a");
        map.put(78, "a");
        //内置循环
        map.forEach((key, value) -> System.out.println(key + ":" + value));
        //如果存在的key,则返回原值,如果不存在则给予一个默认值
        System.out.println(map.getOrDefault(78, "b"));
        System.out.println(map.getOrDefault(79, "b"));
    }
}
```

## LinkedHashMap

### LinkedHashMap性能耗时对比

● LinkedHashMap

● TreeMap

```java
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        int count = 1000000;
        Map<String, String> map = new HashMap<>();
        Map<String, String> linkedMap = new LinkedHashMap<>();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            map.put(String.valueOf(i), "value");
        }
        end = System.currentTimeMillis();
        System.out.println("map:" + (end - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            linkedMap.put(String.valueOf(i), "value");
        }
        end = System.currentTimeMillis();
        System.out.println("linkedMap:" + (end - start));
        start = System.currentTimeMillis();
        for (String value : map.values()) {
        }
        end = System.currentTimeMillis();
        System.out.println("map:" + (end - start));
        start = System.currentTimeMillis();
        for (String value : linkedMap.values()) {
        }
        end = System.currentTimeMillis();
        System.out.println("linkedMap:" + (end - start));
//        map:301
//        linkedMap:241
//        map:33
//        linkedMap:20
//        map:283
//        linkedMap:264
//        map:33
//        linkedMap:19
    }
}
```

linkedMap效率读取和存入都比Map快

数据量足够大的情况下,存的时候map快,而取的时候linkedMap快

### LinkedHashMap模拟LRU缓存

● 两种输出顺序:1.录入顺序 2.使用顺序

● 利用LinkHashMap实现LRU

```java
import java.util.LinkedHashMap;
import java.util.Map;
public class Test {
    public static void main(String[] args) {
        Map<String, String> linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.put("y1", "xx");
        linkedMap.put("m1", "xx");
        linkedMap.put("k1", "xx");
        linkedMap.put("n1", "xx");
        linkedMap.get("m1");
        linkedMap.get("y1");
        System.out.println(linkedMap);
        //可以使用removeEldestEntry实现LRU,但只能通过继承LinkedHashMap的方式实现,maxSize定义最近的个数输出
        //protected boolean removeEldestEntry(Map.Entry<K,V> eldest) this.size() > maxSize
        LRUMap<String, String> lruMap=new LRUMap<String, String>(3);
        lruMap.put("y1", "xx");
        lruMap.put("m1", "xx");
        lruMap.get("m1");
        lruMap.put("k1", "xx");
        lruMap.put("n1", "xx");
        System.out.println(lruMap);
    }
}
```

```txt
import java.util.LinkedHashMap;
import java.util.Map;
public class LRUMap<K, V> extends LinkedHashMap<K, V> {
    private int maxSize;
    public LRUMap(int maxSize) {
        super(16, 0.75f, true);
        this.maxSize = maxSize;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.maxSize;
    }
}
```

## TreeMap

TreeMap实现升序或降序

● 对TreeMap实现增,删,遍历,排序等操作

● 存取耗时对比

```java
import java.util.Map;
import java.util.TreeMap;
public class Test {
    public static void main(String[] args) {
//        Map<String, String> treeMap = new TreeMap<>((o1, o2) -> o1.compareTo(o2));//正序
        Map<String, String> treeMap = new TreeMap<>((o1, o2) -> o2.compareTo(o1));//倒序
        treeMap.put("tx","88");
        treeMap.put("ax","88");
        treeMap.put("bx","88");
        treeMap.put("yx","88");
        treeMap.put("cx","88");
        treeMap.put("abx","88");
        treeMap.put("ox","88");
        System.out.println(treeMap);
    }
}
```

TreeMap等进行性能对比

```java
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
public class Test {
    public static void main(String[] args) {
        int count = 1000000;
        Map<String, String> map = new HashMap<>();
        Map<String, String> linkedMap = new LinkedHashMap<>();
        Map<String, String> treeMap = new TreeMap<>();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            map.put(String.valueOf(i), "value");
        }
        end = System.currentTimeMillis();
        System.out.println("map:" + (end - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            linkedMap.put(String.valueOf(i), "value");
        }
        end = System.currentTimeMillis();
        System.out.println("linkedMap:" + (end - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            treeMap.put(String.valueOf(i), "value");
        }
        end = System.currentTimeMillis();
        System.out.println("treeMap:" + (end - start));
        start = System.currentTimeMillis();
        for (String value : map.values()) {
        }
        end = System.currentTimeMillis();
        System.out.println("map:" + (end - start));
        start = System.currentTimeMillis();
        for (String value : linkedMap.values()) {
        }
        end = System.currentTimeMillis();
        System.out.println("linkedMap:" + (end - start));
        start = System.currentTimeMillis();
        for (String value : treeMap.values()) {
        }
        end = System.currentTimeMillis();
        System.out.println("treeMap:" + (end - start));
    }
}
```

TreeMap需要排序,所以性能相比较差

```java
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
public class Test {
    public static void main(String[] args) {
        int count = 1000000;
        Map<String, String> map = new HashMap<>();
        Map<String, String> linkedMap = new LinkedHashMap<>();
        Map<String, String> treeMap = new TreeMap<>();
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            map.put(String.valueOf(i), "value");
        }
        end = System.nanoTime();
        System.out.println("map:" + (end - start));
        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedMap.put(String.valueOf(i), "value");
        }
        end = System.nanoTime();
        System.out.println("linkedMap:" + (end - start));
        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            treeMap.put(String.valueOf(i), "value");
        }
        end = System.nanoTime();
        System.out.println("treeMap:" + (end - start));
        start = System.nanoTime();
        for (String value : map.values()) {
        }
        end = System.nanoTime();
        System.out.println("map:" + (end - start));
        start = System.nanoTime();
        for (String value : linkedMap.values()) {
        }
        end = System.nanoTime();
        System.out.println("linkedMap:" + (end - start));
        start = System.nanoTime();
        for (String value : treeMap.values()) {
        }
        end = System.nanoTime();
        System.out.println("treeMap:" + (end - start));
//        map:273336500
//        linkedMap:253668200
//        treeMap:3710640900
//        map:33611300
//        linkedMap:25688600
//        treeMap:35448400
    }
}
```

## 课程总结

● Map接口的常见方法

● 对比不同遍历方法,不同Map遍历的效率

● 学习了底层原理,创建Map时,针对不同情况选择合适的构造方法

● HashMap,TreeMap和LinkedHashMap的区别和选择
