#### ArrayList源码刨析

##### 主要属性

```java
     /**
     *  默认初始化容量为10
     */
     private static final int DEFAULT_CAPACITY = 10;

    /**
     * 当自定义容量为0时，用该Empty数组进行初始化
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 没有自定义容量，用该数组初始化。懒加载
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     *  非私有，目的简化嵌套访问（？）
     *  transient：保证其不参与序列化
     *  Object 类型，因为Java不支持数组泛型
     */
    transient Object[] elementData; // non-private to simplify nested class access

    /**
     * 数组中元素的个数，非数组的长度
     */
    private int size;

    /**
    *可分配的最大容量，前8个字节要操作系统要记录借出去的空间容量，方便回收
    */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
```



##### 主要方法

###### 无参构造

```java
// 长度为0的数组（懒加载机制）
public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
```

###### 指定容量的构造方法

```java 
public ArrayList(int initialCapacity) {
    // 没有判断大于Integer.MAX_VALUE - 8;
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;//(空数组)
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        }
    }
```

###### 集合作为参数

```java
public ArrayList(Collection<? extends E> c) {  //类型只能是E及其子类，否则编译时异常
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // replace with empty array.
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }
```

###### 添加元素

```java
 public boolean add(E e) {
        ensureCapacityInternal(size + 1);  
        elementData[size++] = e;    // 末尾添加元素
        return true;
    }
```

###### 确保数组容量存的下

```java
private void ensureCapacityInternal(int minCapacity) {  // minCapacity = size + 1
           //第一次添加时，未指定容量时条件成立
           // 指定容量且为0 时会很麻烦
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            //懒加载机制启动，此时容量为10
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        //自定义容量时
        ensureExplicitCapacity(minCapacity);
    }
```

###### 是

```java
private void ensureExplicitCapacity(int minCapacity) {  // minCapacity = size + 1 或者 1
        modCount++;  // 统计集合被修改的次数
        // 判断数组是否放满
        if (minCapacity - elementData.length > 0)
            // 扩容逻辑
            grow(minCapacity);
    }
```

###### 扩容方法

```java
private void grow(int minCapacity) {  // minCapacity = size + 1 且 大于了elementData.lengt
        // 当前数组长度
        int oldCapacity = elementData.length;
        // 1 + 0.5 = 1.5倍扩容 
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 扩为1.5倍还不能满足要求，指定容量且为0的情况
        // 若自定义初始容量小于5，下面条件都会成立
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        // 大于最大容量了
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```

###### 处理大于最大容量的情况

```java
private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow 大于int最大值溢出了，为负
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            // 给予Integer.MAX_VALUE，int类型的最大值
            // 因此最大容量为2 ^ 31 - 1.
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
```

###### 删除操作

```java
public E remove(int index) {
        // 索引检查
        rangeCheck(index);

        modCount++;
        // 返回值
        E oldValue = elementData(index);

        int numMoved = size - index - 1; // 很重要
        // 每删除一个元素，该元素后面的的元素移动
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }
```

