package THE4;

import java.util.Iterator;

public class lv5 {
    public static void main(String[] args) {
        MyLinked<String> a = new MyLinked<>();
        a.addNode("冉跃");
        a.addNode("可能");
        a.addNode("是");
        a.addNode("卷王");
        Iterator<String> iterator1 = a.iterator();
        System.out.println("删除操作前");
        while(iterator1.hasNext()){
            System.out.print(iterator1.next());
        }
        System.out.println();
        a.deleteNode("可能");
        System.out.println("删除操作后");
        for (String s : a) {
            System.out.print(s);
        }
    }
}
//新建MyLinked类，实现Iterable接口
class MyLinked<T>implements Iterable<T> {
    //设置节点内部类
    class Node {
        private final T data;//录入数据
        private Node next;//保存下一个节点

        public Node(T data) {
            this.data = data;
        }

        //增加新节点
        public void add(Node newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.add(newNode);
            }
        }
        //新建查找方法，为删除数据做准备
        public boolean search(T data) {
            if (data.equals(this.data)) {
                return true;
            } else {
                if (this.next != null) {
                    return this.next.search(data);
                }
                else {
                    return false;
                }
            }
        }
        //删除节点的方法
        public void delete(Node per, T data) {
            if (data.equals(this.data)) {
                per.next = this.next;//空出节点
            } else {
                if (this.next != null) {
                    this.next.delete(this, data);
                }
            }
        }
    }

    //设置根节点
    private Node root;

    //增加节点的方法
    public void addNode(T date) {
        Node newNode = new Node(date);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.add(newNode);
        }
    }

    //查询是否包含数据
    public boolean contains(T data) {
        return this.root.search(data);
    }

    //删除数据
    public void deleteNode(T data) {
        if (this.contains(data)) {
            if (this.root.data.equals(data)) {
                this.root = this.root.next;//删除节点
            } else {
                this.root.next.delete(root, data);//删除节点
            }
        }
    }

    //覆写iterator方法
    @Override
    public Iterator<T> iterator() {
        return new LIST(this.root);
    }

    //新建LIST内部类，实现Iterator<>接口
    class LIST implements Iterator<T> {
        Node node;

        //获取Node节点
        public LIST(Node node) {
            this.node = node;
        }

        //覆写hasNext方法
        @Override
        public boolean hasNext() {
            return node != null;
        }

        //覆写next方法
        @Override
        public T next() {
            T t = node.data;
            node = node.next;
            return t;
        }
    }
}


