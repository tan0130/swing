package hexstring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * create by tan on 2018/6/21
 * 读取十六进制文件
 **/
public class ReadHexString {
    private JButton jbtOpen;
    private JFrame frame;
    private JPanel panel;

    public ReadHexString() {

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        jbtOpen = new JButton("打开");

        panel.add(jbtOpen, BorderLayout.CENTER);

        jbtOpen.addActionListener(new Open());

        frame = new JFrame("解析");
        frame.add(panel);
        frame.setSize(100,80);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ReadHexString();
    }


    class Open implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                File file = null;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(false); // 不支持多选
                fileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setDialogTitle("选择目标文件夹");
                if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                    file = fileChooser.getSelectedFile();
                }

                int line = 0; // 设置解析后文本的行数，记录解析报文的条数
                FileInputStream fis = new FileInputStream(file.getPath()); // 读取字节文件
                BufferedInputStream bis = new BufferedInputStream(fis , 10 * 1024 * 1024); // 相当于一个缓冲区
                int len = 1;
                byte[] temp = new byte[len]; // 单个字节读取文件
                int i = 1; // 设置控制台显示的行数
                StringBuffer sb = new StringBuffer(""); // 将每次读取到的字节存放到缓存中


                for (; (fis.read(temp, 0, len) != -1); ) {
                    if (temp[0] > 0xf && temp[0] <= 0xff) {
                        sb.append(Integer.toHexString(temp[0]));
                    } else if (temp[0] >= 0x0 && temp[0] <= 0xf) {
                        sb.append("0" + Integer.toHexString(temp[0]));
                    } else {
                        sb.append(Integer.toHexString(temp[0]).substring(6));
                    }
                    if (sb.toString().contains("0d0a") || sb.toString().contains("0D0A")) {
                        System.out.println(sb.toString());
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
