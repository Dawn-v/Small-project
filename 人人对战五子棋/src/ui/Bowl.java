package ui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Bowl extends JPanel {
	//������169����Ԫ����������
	public static FivePanel fp[][] = new FivePanel[13][13];
	
	Bowl() {
		//ʹ�����񲼾�
		setLayout(new GridLayout(13, 13));
		//����ѭ������13*13�ľ��ж�ά������FivePanel
		for(int i=0;i<13;i++) {
			for(int j=0;j<13;j++) {
				fp[i][j]=new FivePanel(i, j);
				//������������ӵ�Ԫ�����
				add(fp[i][j]);
			}
		}
	}

}
