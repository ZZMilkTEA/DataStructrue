package exam.query;

public class STable {
    public class Node{
        private int key;
        private int other_int;
        private String other_string;

        public Node(int key, int other_int, String other_string) {
            this.key = key;
            this.other_int = other_int;
            this.other_string = other_string;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getOther_int() {
            return other_int;
        }

        public void setOther_int(int other_int) {
            this.other_int = other_int;
        }

        public String getOther_string() {
            return other_string;
        }

        public void setOther_string(String other_string) {
            this.other_string = other_string;
        }
    }

    private Node[] nodes;

    public STable(int length){
        this.nodes = new Node[length];
        for(int i = 0;i < nodes.length; i++){
            this.nodes[i] = new Node(0,0,null);
        }
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }
}
