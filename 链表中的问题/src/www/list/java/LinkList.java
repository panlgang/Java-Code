package www.list.java;

public class LinkList {
    public class Node{
        private  Node next;
        private Object data;
        public Node(Object data){
            this.data = data;
        }
    }

    /**
     * 在链表中删除等于value的结点，当头节点是要删除的节点时。
     * @param head
     * @param value
     * @return
     */
    public Node removeElements(Node head,Object value){
        Node duumyNode = new Node(0);  //创建一个虚拟的头节点
        duumyNode.next = head;
        Node cur = duumyNode;
        while(cur.next != null){
            if(cur.next.data == value){
                //删除操作
                Node delNode = cur.next;
                cur.next = delNode.next;
            }else{
                cur = cur.next;
            }
        }
        Node retNode = duumyNode.next;
        duumyNode = null;
        return retNode;
    }

    /**
     * 在不知道头节点的情况下，删除某一个结点
     * @param delNode
     */
    public void removeNode(Node delNode){
        if(delNode == null)
            return;
        if(delNode.next == null){   //该节点是最后一个结点
            delNode = null;
        }
        delNode.data = delNode.next.data;
        Node relDelNode = delNode.next;
        delNode.next = relDelNode.next;
        relDelNode = null;
    }

    /**
     * 删除链表的倒数第K个结点
     * @param head
     * @param k
     * @return
     */
    public Node removeLastKnode(Node head,int k){
        if(k <= 0){
            throw new RuntimeException("参数不合法：" + k);
        }
        Node duumyNode = new Node(0);
        duumyNode.next = head;
        Node p = duumyNode;
        Node q = duumyNode;
        for(int i = 0; i < k + 1; i++){ // p先走k+1步
            if(p != null){
                p = p.next;
            }
        }
        while(p != null){     //当p指向null的时候，q来到倒数第K+1个结点处
            p = p.next;
            q = q.next;
        }
        Node delNode = q.next;
        q.next = delNode.next;
        delNode = null;
        Node retNode = duumyNode.next;
        duumyNode = null;
        return retNode;

    }

}
