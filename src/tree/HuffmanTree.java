package tree;

import java.util.*;

public class HuffmanTree {
    //定义Huffman树内的节点
    static class WeightNode<T> extends tree.Node {
        private int weight;
        private WeightNode parent;
        private WeightNode left;
        private WeightNode right;


        //有参构造节点
        WeightNode(T data, int weight){
            super(data);
            this.weight = weight;
            this.parent = null;
        }

        public String toString() {
            if (this.right == null && this.left == null) {
                return "WeightNode[data=" + data + ",weight=" + weight + "]\n";
            } else if (this.left == null) {
                return "WeightNode[data=" + data + ",weight=" + weight + ",right:" + right.data + "]\n";
            } else if (this.right == null) {
                return "WeightNode[data=" + data + ",weight=" + weight + ",left:" + left.data + "]\n";
            }
            else return "WeightNode[data=" + data + ",weight=" + weight + ",left:" + left.data +
                        ",right:" + right.data + "]\n";
        }
    }
    //------------定义哈夫曼树的部分------------
    private ArrayList<WeightNode> nodes = new ArrayList<WeightNode>();
    //构造新哈夫曼树,返回root节点
    private WeightNode createTree(ArrayList<WeightNode> weightNodes) {
        while (weightNodes.size() > 1) {
            quickSort(weightNodes);
            WeightNode left = weightNodes.get(weightNodes.size() - 1);
            WeightNode right = weightNodes.get(weightNodes.size() - 2);

            WeightNode parent = new WeightNode(0, left.weight + right.weight);

            parent.left = left;
            parent.right = right;
            parent.left.parent = parent;
            parent.right.parent = parent;

            this.nodes.add(weightNodes.remove(weightNodes.size() - 1));
            this.nodes.add(weightNodes.remove(weightNodes.size() - 1));

            weightNodes.add(parent);
        }
        this.nodes.add(weightNodes.get(0));
        return weightNodes.get(0);
    }

    //快速排序
    public static void quickSort(ArrayList<WeightNode> weightNodes){
        subSort(weightNodes, 0, weightNodes.size() - 1);
    }

    //实现快速排序的算法，对节点从大到小的排序
    private static void subSort(ArrayList<WeightNode> weightNodes, int start, int end){
        if (start < end){   //判断是否需要排序
            WeightNode base = weightNodes.get(start);   //以第一个元素作为分界值
            int i = start;
            int j = end +1;
            while (true){
                while (i < end && weightNodes.get(++i).weight >= base.weight);
                while (j > start && weightNodes.get(--j).weight <= base.weight);
                if(i <j){
                    swap(weightNodes, i ,j);
                }
                else {
                    break;
                }
            }
            swap(weightNodes, start, j);
            subSort(weightNodes, start,j - 1);
            subSort(weightNodes, j+1, end);
        }
    }

    //替换i和j索引处的元素交换
    private static void swap(ArrayList<WeightNode> weightNodes, int i, int j){
        WeightNode tmp;
        tmp = weightNodes.get(i);
        weightNodes.set(i, weightNodes.get(j));
        weightNodes.set(j, tmp);
    }

    //广度优先遍历
    public static ArrayList<WeightNode> breadthFirst(WeightNode root){
        Queue<WeightNode> queue = new ArrayDeque<WeightNode>();
        ArrayList<WeightNode> list = new ArrayList<WeightNode>();

        if (root!=null){
            queue.offer(root);
        }

        while (!queue.isEmpty()){
            list.add(queue.peek());
            WeightNode p = queue.poll();

            if (p.left != null){
                queue.offer(p.left);
            }

            if (p.right != null){
                queue.offer(p.right);
            }
        }
        return list;
    }

    //树的高度
    public static int height(WeightNode root) {
        if (root != null) { // 递归终止条件
            int h1 = height(root.left);
            int h2 = height(root.right);
            return h1 > h2 ? h1 + 1 : h2 + 1;
        }
        return 0;
    }

    //Huffman字符树创建
    public WeightNode huffmanStringTreeCreate(String input){
        int count[] = new int[128];
        ArrayList<WeightNode> weightNodes =new ArrayList<WeightNode>();

        for (int i = 0; i < count.length; i++){
            count[i] = 0;
        }
        for (int i = 0; i < input.length(); i++){
            count[input.charAt(i)]++;
        }
        for (int i = 0; i < count.length; i++){
            if (count[i] != 0 ){
                char ch = (char)i;
                weightNodes.add(new WeightNode<>(ch,count[i]));
            }
        }
        WeightNode root = createTree(weightNodes);
        return root;
    }
    //Huffman字符编码
    public String huffmanStringCode(String input){
        Stack stack = new Stack();
        String output = "";
        WeightNode tempNode = new WeightNode(null,0);
        for (int i = 0; i < input.length(); i++){
            for (int j = 0; j < this.nodes.size(); j++){
                if (String.valueOf(input.charAt(i)).equals(this.nodes.get(j).data.toString())){
                    tempNode = this.nodes.get(j);
                    break;
                }
            }
            while (tempNode.parent != null){
                if (tempNode.parent.left == tempNode){
                    stack.push(0);
                    tempNode = tempNode.parent;
                }
                else {
                    stack.push(1);
                    tempNode = tempNode.parent;
                }
            }
            while (!stack.empty()){
                String endStr = stack.pop().toString();
                output = output.concat(endStr);
            }
        }
        return output;
    }
    //Huffman字符译码
    public static String huffmanStringDecode(WeightNode root,String code){
        WeightNode p = root;
        String output ="";
        for (int i = 0; i < code.length(); i++){
            if (code.charAt(i) == '0'){
                p = p.left;
            }
            else {
                p = p.right;
            }
            if(p.left == null && p.right == null){
                output =output.concat(p.data.toString());
                p = root;
            }
        }
        return output;
   }


    public static void main (String args[]){
        HuffmanTree tree = new HuffmanTree();
        String input = "SDDADSSDA";
        WeightNode root = tree.huffmanStringTreeCreate(input);
        System.out.println(tree.huffmanStringCode("SDDADSSDA"));
        System.out.println(HuffmanTree.huffmanStringDecode(root,"01001011101"));
    }
}
