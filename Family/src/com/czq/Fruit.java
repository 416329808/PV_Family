package com.czq;

import java.awt.Container;
import java.awt.Image;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Fruit extends Thread{
	public static JFrame form = new JFrame();
	public static Image appleImg;
	public static Image orangeImg;
	public static Image diskImg;
	public static JTextArea jTextArea;
	public static JScrollPane jScrollPane;

	Image MoImg = new ImageIcon(getClass().getResource("Mother.jpg")).getImage();
	Image FaImg = new ImageIcon(getClass().getResource("Father.jpg")).getImage();
	Image SonImg = new ImageIcon(getClass().getResource("Son.jpg")).getImage();
	Image DauImg = new ImageIcon(getClass().getResource("Daughter.jpg")).getImage();

	public static Container container = form.getContentPane();
	public static JLabel[] label = new JLabel[4];
	public static int[] flag = { 0, 0, 0, 0 };// label[i]在窗体中是否存在
	public static JLabel Disk = new JLabel();

	public static Semaphore FruitNumSemapore = new Semaphore(2, false);
	// 盘子中可放水果的个数

	public static Semaphore GetputmutexSemaphore = new Semaphore(1, false);
	// 盘子放或取得互斥信号量

	public static Semaphore haveAppleSemaphore = new Semaphore(0, false);
	// 盘子中是否有苹果

	public static Semaphore haveOrangeSemaphore = new Semaphore(0, false);
	// 盘子中是否有橘子

	public static int apple = 0;
	// 盘子中苹果的数量

	public static int orange = 0;
	// 盘子中橘子的数量

	public static int SonChangenum = -1;
	// 儿子吃水果的改变数

	public static int DauChangenum = -1;
	// 女儿吃水果的改变数
	public static int Sonflag = 0;// 0吃橘子 1吃苹果
	public static int Dauflag = 1;

	public Fruit() {
		appleImg = new ImageIcon(getClass().getResource("Apple.jpg")).getImage();
		orangeImg = new ImageIcon(getClass().getResource("Orange.jpg")).getImage();
		diskImg = new ImageIcon(getClass().getResource("Disk.jpg")).getImage();
		Disk = new JLabel(new ImageIcon(diskImg));
		label[0] = new JLabel(new ImageIcon(appleImg));
		label[1] = new JLabel(new ImageIcon(appleImg));
		label[2] = new JLabel(new ImageIcon(orangeImg));
		label[3] = new JLabel(new ImageIcon(orangeImg));
		form.setLayout(null); // 设置窗体没有布局，组件位置任意
		form.setSize(1300, 700);
		form.setDefaultCloseOperation(3); // 设置窗体有最小化，最大化，关闭三个按钮
		form.setLocationRelativeTo(null); // 窗口居中显示
		form.setResizable(false); // 设置窗体不能调整大小
		JLabel mot = new JLabel(new ImageIcon(MoImg));
		mot.setBounds(800, 0, 100, 100);
		JLabel fa = new JLabel(new ImageIcon(FaImg));
		fa.setBounds(800, 550, 100, 100);
		JLabel son = new JLabel(new ImageIcon(SonImg));
		son.setBounds(0, 0, 100, 100);
		JLabel dau = new JLabel(new ImageIcon(DauImg));
		dau.setBounds(0, 550, 100, 100);
		JLabel dis = new JLabel(new ImageIcon(diskImg));
		dis.setBounds(400, 300, 200, 133);
		jTextArea = new JTextArea();
		jScrollPane = new JScrollPane(jTextArea);
		jScrollPane.setBounds(900, 0, 400, 670);
		container.add(jScrollPane);
		form.add(fa);
		form.add(son);
		form.add(dau);
		form.add(mot);
		form.add(dis);
		form.add(jScrollPane);

		form.setVisible(true);
	}
	@Override
	public void run() {
		Farther farther = new Farther();
		Mother mother = new Mother();
		Son son = new Son();
		Daughter daughter = new Daughter();
		
		farther.start();
		daughter.start();
		mother.start();
		son.start();
	}

	public static void main(String[] args) {
		new Fruit().start();

	}

}
