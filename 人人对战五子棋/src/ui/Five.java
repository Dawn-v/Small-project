package ui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Five extends JFrame {
	
	Bowl bowl = new Bowl();
	ControlPan cp = new ControlPan();
	
	//cheese为棋子的颜色,1为黑,2为白
	static int cheese = 1;
	//用二维数组来存储棋盘上已经下过的棋子
	static int allCheese[][] = new int[13][13];
	static Image img1 = Toolkit.getDefaultToolkit().getImage("black.jpg");
	static Image img2 = Toolkit.getDefaultToolkit().getImage("white.jpg");
	
	//数组初始化为0
	static {
		for(int i=0;i<13;i++) {
			for(int j=0;j<13;j++) {
				allCheese[i][j]=0;
			}
		}
	}
	
	public Five() {
		init();
		this.setTitle("五子棋");
		this.setSize(600, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {
		setLayout((new BorderLayout()));
		add(bowl,BorderLayout.CENTER);
		add(cp,BorderLayout.EAST);
		addWindowListener(new FiveWindowLinstener());
		
		//防止图片第一次加载时,没有加载成功
		//作用是在drawImage()之前调用,MediaTracker可以确保你的图片在DRAW前被加载以备使用
		try {
			MediaTracker t1 = new MediaTracker(this);
			t1.addImage(img1,0);
			t1.waitForAll();
			
			MediaTracker t2 = new MediaTracker(this);
			t2.addImage(img2,0);
			t2.waitForAll();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public class FiveWindowLinstener extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Five f = new Five();
	}

}
