package exam.query;

import java.io.IOException;
import java.util.Scanner;

public class HashQuery {
    public static void main(String[] args) throws IOException {
        System.out.println("*******哈希查找*******");

        Scanner scanner =new Scanner(System.in);

        int sourceData_number;
        System.out.print("请输入源数据的数量：");
        sourceData_number = scanner.nextInt();
        STable sTable = new STable(sourceData_number);
        System.out.println("下面输入源数据，key要求非0，因为0值用来检测冲突了，若为0则可能会被覆盖");
        for (int i = 0;i < sTable.getNodes().length; i++){
            System.out.println("数据" + (i+1) + "：");
            System.out.print( "\tkey(int):");
            sTable.getNodes()[i].setKey(scanner.nextInt());
            System.out.print("\totherData(int):");
            sTable.getNodes()[i].setOther_int(scanner.nextInt());
            System.out.print("\totherData(String):");
            sTable.getNodes()[i].setOther_string(scanner.next());
        }

        // 原始数据
        int[] list = new int[sourceData_number];
        for (int i = 0; i < sourceData_number; i++){
            list[i] = sTable.getNodes()[i].getKey();
        }

        // 初始化哈希表
        int hashLength = list.length;
        int[] hashTable = new int[hashLength];

        // 创建哈希表
        for (int i = 0; i < list.length; i++) {
            insert(hashTable, list[i]);
        }
        System.out.println("展示哈希表中的数据：" + display(hashTable));

        while (true) {
            // 哈希表查找
            System.out.print("请输入要查找的数据：");
            int data = new Scanner(System.in).nextInt();
            int result = search(hashTable, data);
            if (result == -1) {
                System.out.println("对不起，没有找到！");
            } else {
                System.out.println("数据的位置是：" + (result+1));
                System.out.println("数据是： key-" + sTable.getNodes()[result].getKey() +
                        "  otherInt-" + sTable.getNodes()[result].getOther_int() +
                        "  ohterString-" + sTable.getNodes()[result].getOther_string());
            }
        }
    }

    /**
     * 方法：哈希表插入
     */
    public static void insert(int[] hashTable, int data) {
        // 哈希函数，除留余数法
        int hashAddress = hash(hashTable, data);

        // 如果不为0，则说明发生冲突
        while (hashTable[hashAddress] != 0) {
            // 利用 开放定址法 解决冲突
            hashAddress = (++hashAddress) % hashTable.length;
        }

        // 将待插入值存入字典中
        hashTable[hashAddress] = data;
    }

    /**
     * 方法：哈希表查找
     */
    public static int search(int[] hashTable, int data) {
        // 哈希函数，除留余数法
        int hashAddress = hash(hashTable, data);

        while (hashTable[hashAddress] != data) {
            // 利用 开放定址法 解决冲突
            hashAddress = (++hashAddress) % hashTable.length;
            // 查找到开放单元 或者 循环回到原点，表示查找失败
            if (hashTable[hashAddress] == 0 || hashAddress == hash(hashTable, data)) {
                return -1;
            }
        }
        // 查找成功，返回下标
        return hashAddress;
    }

    /**
     * 方法：构建哈希函数（除留余数法）
     *
     * @param hashTable
     * @param data
     * @return
     */
    public static int hash(int[] hashTable, int data) {
        return data % hashTable.length;
    }

    /**
     * 方法：展示哈希表
     */
    public static String display(int[] hashTable) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : hashTable) {
            stringBuffer = stringBuffer.append(i + " ");
        }
        return String.valueOf(stringBuffer);
    }
}
