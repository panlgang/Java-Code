package www.test;

public interface Sequence {
    /**
     * 在末尾添加元素
     * @param data  要添加的元素
     */
    void add(Object data);


    /**
     * 删除指定索引处的元素
     * @param index  指定索引
     * @return  删除成功或者失败
     */
    boolean delete(int index);

    /**
     * 查找指定元素
     * @param obj  指定元素
     * @return 成功返回查找到的元素下标，否则返回-1
     */
    int find(Object obj);

    /**
     * 线性表中是否包含指定元素
     * @param obj
     * @return
     */
    boolean contains(Object obj);

    /**
     * 修改指定索引处的元素
     * @param index  索引
     * @param obj  新数据
     * @return
     */

    Object set(int index,Object obj);

    /**
     * 线性表是否为空
     * @return
     */

    boolean isEmpty();

    /**
     * 清空线性表
     */
    void clear();

    /**
     * 获取当前线性表中元素的个数
     * @return
     */
    int getSize();

    Object[] toArray();





}
