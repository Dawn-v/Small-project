package ui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Bowl extends JPanel {
	//棋盘由169个单元格面板所组成
	public static FivePanel fp[][] = new FivePanel[13][13];
	
	Bowl() {
		//使用网格布局
		setLayout(new GridLayout(13, 13));
		//运用循环创建13*13的具有二维特征的FivePanel
		for(int i=0;i<13;i++) {
			for(int j=0;j<13;j++) {
				fp[i][j]=new FivePanel(i, j);
				//按网格类型添加单元格面板
				add(fp[i][j]);
			}
		}
	}

}
