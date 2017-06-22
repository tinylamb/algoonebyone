package challenges.tree;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by samo on 2017/6/22.
 *
 * @author samo
 * @date 2017/06/22
 */
public class Trie<K, V> {

    /**
     * 根节点使用hashmap加快查询
     * 这里的V要被实现为Node,先写个空Node
     */
    private HashMap<K, Node> root;

    /**
     * 树中的节点个数
     */
    private int size;

    /**
     * 构造函数
     */
    public Trie() {
        root = new HashMap<K, Node>();
    }

    public Trie(int initC) {
        root = new HashMap<K, Node>(initC);
    }

    /**
     * key的形式如"好天气" -> ["好", "天", "气"]
     * 根节点不包含字符，除根节点以外每个节点只包含一个字符
     * @param key
     * @param val
     */
    public void put(K[] key, V val) {
        //检查是否存在过
        Node child = root.get(key[0]);
        if (child == null) {
            //去实现Node的构造函数
            child = new Node(key[0]);
            root.put(key[0], child);
        }
        //["好", "天", "气"]中的"好"已经被添加到树中,接着处理"天"
        child.addChild(key, val, 1);

    }

    public V get(K[] key) {
        Node child = root.get(key[0]);
        if (child != null) {
            return child.getChild(key, 1);
        }
        return null;
    }

    public Node get(K key) {
        return root.get(key);
    }

    public int size() {
        return size;
    }

    public class Node {
        private K key;
        private V value;
        private LinkedList<Node> children;


        public Node(K singlechar) {
            this.key = singlechar;
            this.value = null;
            this.children = new LinkedList<>();
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        /**
         * 递归实现将一串字符插入到树中
         * @param key
         * @param value
         * @param index
         */
        public void addChild(K[] key, V value, int index) {
            if (index >= key.length) {
                if (this.value == null) {
                    //TODO why value is null?
                    ++size;
                }
                this.value = value;
                return;
            }
            for (Node child : children) {
                if (child.key.equals(key[index])) {
                    child.addChild(key, value, index + 1);
                    return;
                }
            }
            Node child = new Node(key[index]);
            children.addFirst(child);
            child.addChild(key, value, index + 1);

        }

        public V getChild(K[] key, int index) {
            if (index >= key.length) {
                return value;
            }
            for (Node child : children) {
                if (child.key.equals(key[index])) {
                    return child.getChild(key, index + 1);
                }
            }
            return null;
        }

        public Node getChild(K key) {
            for (Node child : children) {
                if (child.key.equals(key)) {
                    return child;
                }
            }

            return null;
        }
    }

}
