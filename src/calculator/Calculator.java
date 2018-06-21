package calculator;

import com.sun.org.apache.xpath.internal.operations.Div;
import com.sun.org.apache.xpath.internal.operations.Plus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * create by tan on 2018/6/20
 * swing 实现简易计算器
 **/
public class Calculator {
    private JFrame frame;
    private JPanel panel, panelText, panelButton;
    private JTextField jtfText;
    private JButton jbt0, jbt1, jbt2, jbt3, jbt4, jbt5, jbt6, jbt7, jbt8, jbt9, jbtPoint,
                    jbtPlus, jbtSub, jbtMul, jbtDiv, jbtEqu, jbtYx, jbtYu, jbtSqrt, jbtClear, jbtBack;
    private double num1, num2, num3, result;
    private int m;
    public Calculator() {

        // 定义最外层的panel
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panelText = new JPanel();
        panelText.setLayout(new FlowLayout(FlowLayout.LEFT));

        jtfText = new JTextField(35);
        jtfText.setEditable(false); // 文本框不可编辑
        jtfText.setBounds(0, 0, 230, 40);

        jbtBack = new JButton("<-");
        jbtBack.setBounds(240, 0, 30, 40);
        panelText.add(jtfText);
        panelText.add(jbtBack);

        panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(5,4));
        jbt0 = new JButton("0");
        jbt1 = new JButton("1");
        jbt2 = new JButton("2");
        jbt3 = new JButton("3");
        jbt4 = new JButton("4");
        jbt5 = new JButton("5");
        jbt6 = new JButton("6");
        jbt7 = new JButton("7");
        jbt8 = new JButton("8");
        jbt9 = new JButton("9");
        jbtPoint = new JButton(".");
        jbtEqu = new JButton("=");
        jbtPlus = new JButton("+");
        jbtSub = new JButton("-");
        jbtMul = new JButton("*");
        jbtDiv = new JButton("/");
        jbtSqrt = new JButton("√");
        jbtClear = new JButton("CE");
        jbtYu = new JButton("%");
        jbtYx = new JButton("^");

        panelButton.add(jbtSqrt);
        panelButton.add(jbtYu);
        panelButton.add(jbtYx);
        panelButton.add(jbtClear);

        panelButton.add(jbt7);
        panelButton.add(jbt8);
        panelButton.add(jbt9);
        panelButton.add(jbtPlus);

        panelButton.add(jbt4);
        panelButton.add(jbt5);
        panelButton.add(jbt6);
        panelButton.add(jbtSub);

        panelButton.add(jbt1);
        panelButton.add(jbt2);
        panelButton.add(jbt3);
        panelButton.add(jbtMul);

        panelButton.add(jbt0);
        panelButton.add(jbtPoint);
        panelButton.add(jbtEqu);
        panelButton.add(jbtDiv);

        panel.add(panelText, BorderLayout.NORTH);
        panel.add(panelButton, BorderLayout.CENTER);

        // 按钮添加事件监听器
        jbt0.addActionListener(new B0());
        jbt1.addActionListener(new B1());
        jbt2.addActionListener(new B2());
        jbt3.addActionListener(new B3());
        jbt4.addActionListener(new B4());
        jbt5.addActionListener(new B5());
        jbt6.addActionListener(new B6());
        jbt7.addActionListener(new B7());
        jbt8.addActionListener(new B8());
        jbt9.addActionListener(new B9());
        jbtPoint.addActionListener(new Point());
        jbtEqu.addActionListener(new Equ());
        jbtPlus.addActionListener(new Plus());
        jbtSub.addActionListener(new Sub());
        jbtMul.addActionListener(new Mul());
        jbtDiv.addActionListener(new Div());
        jbtSqrt.addActionListener(new Sqrt());
        jbtYu.addActionListener(new Yu());
        jbtYx.addActionListener(new Yx());
        jbtBack.addActionListener(new Back());
        jbtClear.addActionListener(new Clear());

        // 设置操作按钮的前景色
        jbtSqrt.setForeground(Color.BLUE);
        jbtYu.setForeground(Color.BLUE);
        jbtYx.setForeground(Color.BLUE);
        jbtClear.setForeground(Color.BLUE);
        jbtPlus.setForeground(Color.BLUE);
        jbtSub.setForeground(Color.BLUE);
        jbtMul.setForeground(Color.BLUE);
        jbtDiv.setForeground(Color.BLUE);
        jbtBack.setForeground(Color.BLUE);

        // 定义窗口
        frame = new JFrame();
        frame.add(panel);
        frame.setTitle("简易计算器"); // 窗口标题
        frame.setResizable(false); // 不可拉伸窗口大小
        frame.setSize(280,220); // 窗口大小
        frame.setLocationRelativeTo(null); // 窗口默认置中，也可以使用setBounds方法定义位置和大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 定义是否可以关闭
        frame.setVisible(true); // 可视化
    }

    // 按钮添加事件响应
    class B0 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText(jtfText.getText() + "0");
        }
    }

    class B1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText(jtfText.getText() + "1");
        }
    }

    class B2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText(jtfText.getText() + "2");
        }
    }

    class B3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText(jtfText.getText() + "3");
        }
    }

    class B4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText(jtfText.getText() + "4");
        }
    }

    class B5 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText(jtfText.getText() + "5");
        }
    }

    class B6 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText(jtfText.getText() + "6");
        }
    }

    class B7 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText(jtfText.getText() + "7");
        }
    }

    class B8 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText(jtfText.getText() + "8");
        }
    }

    class B9 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText(jtfText.getText() + "9");
        }
    }

    class Point implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (("").equals(jtfText.getText())) {
                jtfText.setText("0");
            }  else if (jtfText.getText().contains(".")) {
                jtfText.setText("0");
            } else if(jtfText.getText().endsWith(".")) {
                jtfText.setText("0");
            } else {
                jtfText.setText(jtfText.getText() + ".");
            }
            num1 = Double.parseDouble(jtfText.getText());
        }
    }

    class Plus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                num1 = Double.parseDouble(jtfText.getText());
                m = 1;
                jtfText.setText( "");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    class Sub implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                num1 = Double.parseDouble(jtfText.getText());
                m = 2;
                jtfText.setText("");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    class Mul implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                num1 = Double.parseDouble(jtfText.getText());
                m = 3;
                jtfText.setText("");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    class Div implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                num1 = Double.parseDouble(jtfText.getText());
                m = 4;
                jtfText.setText("");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    class Yx implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                num1 = Double.parseDouble(jtfText.getText());
                m = 5;
                jtfText.setText("");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    class Yu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                num1 = Double.parseDouble(jtfText.getText());
                m = 6;
                jtfText.setText( "");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    class Equ implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                num2 = Double.parseDouble(jtfText.getText());
                switch (m) {
                    case 1: result = num1 + num2;
                        break;
                    case 2: result = num1 - num2;
                        break;
                    case 3: result = num1 * num2;
                        break;
                    case 4: result = num1 / num2;
                        break;
                    case 5: result = Math.pow(num1, num2);
                        break;
                    case 6: result = num1 % num2;
                        break;
                    default:
                        break;
                }
                jtfText.setText(result + "");
            } catch (Exception e1) {
                e1.printStackTrace();
                jtfText.setText("除数不能为0");
            }
        }
    }

    class Sqrt implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                num1 = Double.parseDouble(jtfText.getText());
                num3 = Math.sqrt(num1);
                jtfText.setText(num3 + "");
            } catch (Exception e1) {
                e1.printStackTrace();
                jtfText.setText("根数不能为空值");
            }
        }
    }

    class Clear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfText.setText("");
        }
    }

    class Back implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (("").equals(jtfText.getAutoscrolls())) {
                    jtfText.setText("");
                } else {
                    jtfText.setText(jtfText.getText().substring(0, jtfText.getText().length() - 1));
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * main method
     * */
    public static void main(String[] args) {
        String lookAndFeel="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try{
            UIManager.setLookAndFeel(lookAndFeel);
        }catch(Exception e){
            e.printStackTrace();
        }
        new Calculator();
    }
}
