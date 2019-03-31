package seqlist;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeqListApp{
    private static ArrayList<SeqList> seqlists = new ArrayList<SeqList>();

    //创建主窗口
    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);//设置好看的外观风格

        // 创建及设置窗口
        JFrame win_Main = new JFrame("顺序表测试");
        win_Main.setVisible(true);
        win_Main.setSize(500,500);
        win_Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //创建及设置按钮
        JButton button_createSeqList = new JButton("创建线性表");
        button_createSeqList.setBounds(30,30,200,50);
        button_createSeqList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               createWinCreateSeqList();
            }
        });

        JButton button_query = new JButton("查找");
        button_query.setBounds(30,100,200,50);
        button_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createWinCreateSeqList();
            }
        });

        JButton button_insert = new JButton("插入");
        button_insert.setBounds(30,170,200,50);
        button_insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createWinCreateSeqList();
            }
        });

        JButton button_delete = new JButton("移除");
        button_delete.setBounds(30,240,200,50);
        button_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createWinCreateSeqList();
            }
        });

        JButton button_quit = new JButton("退出程序");
        button_quit.setBounds(30,310,200,50);
        button_quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"程序即将退出...");
                System.exit(0);
            }
        });

        Container container_main = win_Main.getContentPane();
        container_main.setLayout(null);
        container_main.add(button_createSeqList);
        container_main.add(button_query);
        container_main.add(button_insert);
        container_main.add(button_delete);
        container_main.add(button_quit);


    }

    //创建线性表窗口
    private static void createWinCreateSeqList() {
        //创建并设置窗口
        JFrame win_CreateSeqList = new JFrame("创建线性表");
        win_CreateSeqList.setVisible(true);
        win_CreateSeqList.setSize(300,300);

        //创建并设置文本标签
        JLabel text_length = new JLabel("请输入线性表长度");
        text_length.setBounds(20,30,150,20);

        JLabel text_initValue = new JLabel("请输入初始值");
        text_initValue.setBounds(20,60,150,20);

        //创建并设置文本输入域
        JTextField input_length = new JTextField(100);
        input_length.setBounds(160,30,40,20);

        JTextField input_initValue = new JTextField(100);
        input_initValue.setBounds(160,60,40,20);

        //创建并设置按钮
        JButton button_create = new JButton("创建");
        button_create.setBounds(30,200,100,30);
        button_create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeqList seqlist = new SeqList(input_length.getColumns(),input_initValue.getColumns());
                seqlists.add(seqlist);
                JOptionPane.showMessageDialog(null,"创建成功！");
                win_CreateSeqList.setVisible(false);
            }
        });


        //向窗口添加组件
        Container container_creatSeqList = win_CreateSeqList.getContentPane();
        container_creatSeqList.setLayout(null);
        container_creatSeqList.add(text_length);
        container_creatSeqList.add(input_length);
        container_creatSeqList.add(text_initValue);
        container_creatSeqList.add(input_initValue);
        container_creatSeqList.add(button_create);

    }

    //线性表查找窗口
    private static void createWinQuery() {
        //创建并设置窗口
        JFrame win_CreateSeqList = new JFrame("创建线性表");
        win_CreateSeqList.setVisible(true);
        win_CreateSeqList.setSize(300,300);

        //创建并设置文本标签
        JLabel text_length = new JLabel("请输入线性表长度");
        text_length.setBounds(20,30,150,20);

        JLabel text_initValue = new JLabel("请输入初始值");
        text_initValue.setBounds(20,60,150,20);

        //创建并设置文本输入域
        JTextField input_length = new JTextField(100);
        input_length.setBounds(160,30,40,20);

        JTextField input_initValue = new JTextField(100);
        input_initValue.setBounds(160,60,40,20);

        //创建并设置按钮
        JButton button_create = new JButton("创建");
        button_create.setBounds(30,200,100,30);
        button_create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeqList seqlist = new SeqList(input_length.getColumns(),input_initValue.getColumns());
                seqlists.add(seqlist);
                JOptionPane.showMessageDialog(null,"创建成功！");
                win_CreateSeqList.setVisible(false);
            }
        });


        //向窗口添加组件
        Container container_creatSeqList = win_CreateSeqList.getContentPane();
        container_creatSeqList.setLayout(null);
        container_creatSeqList.add(text_length);
        container_creatSeqList.add(input_length);
        container_creatSeqList.add(text_initValue);
        container_creatSeqList.add(input_initValue);
        container_creatSeqList.add(button_create);

    }

    public static void main(String[] args) {
        // 显示应用 GUI
        new SeqListApp().createAndShowGUI();
    }
}