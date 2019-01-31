package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FivePanel extends JPanel{
	
	ControlPan cp = new ControlPan();
	int row,column;
	public FivePanel(int row,int column) {
		this.row = row;
		this.column = column;
		this.setBackground(new Color(206, 130, 15));
		this.addMouseListener(new PutCheese());
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.BLACK);

		if (row==0&&column==0) { //���Ͻ�
			g.drawLine(getWidth()/2, getHeight()/2, getWidth(), getHeight()/2);
			g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight());
		}else if (row==0&&column==12) { //���Ͻ�
			g.drawLine(0,getHeight()/2, getWidth()/2, getHeight()/2);
			g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight());
		}else if (row==12&&column==0) { //���½�
			g.drawLine(getWidth()/2,getHeight()/2, getWidth(), getHeight()/2);
			g.drawLine(getWidth()/2,0, getWidth()/2, getHeight()/2);
		}else if (row==12&&column==12) { //���½�
			g.drawLine(getWidth()/2,0, getWidth()/2, getHeight()/2);
			g.drawLine(0, getHeight()/2, getWidth()/2, getHeight()/2);
		}else if (row==0) {
			g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
			g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight());
		}else if (row==12) {
			g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
			g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, 0);
		}else if (column==0) {
			g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
			g.drawLine(getWidth()/2, getHeight()/2, getWidth(), getHeight()/2);
		}else if (column==12) {
			g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
			g.drawLine(getWidth()/2, getHeight()/2, 0, getHeight()/2);
		}else{
			g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
			g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
		}
		
		//�����������Ǹ����ӵ�ֵ,�ػ�����ϵ�����,�����ػ�����ʱ������ʧ
		if (Five.allCheese[row][column]==1) {
			g.drawImage(Five.img1, 0, 0, getWidth(), getHeight(), null);
		}else if (Five.allCheese[row][column]==2) {
			g.drawImage(Five.img2, 0, 0, getWidth(), getHeight(), null);
		}
	}
	
	class PutCheese extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
			Graphics g = getGraphics();
//			System.out.println(Five.cheese+"---------��ҿ�ʼ����--------");
//			
			//�˴��Ѿ��¹���
			if (Five.allCheese[row][column] != 0) {
				return;
			}
		
			//����cheese����ʵ������
			if (Five.cheese==1) {
				g.drawImage(Five.img1, 0, 0, getWidth(), getHeight(), FivePanel.this);
				//���������ӦԪ�ص�ֵ
				Five.allCheese[row][column]=1;
//				int x = e.getX();
//				int y = e.getY();
//				System.out.println("("+x+","+y+")");
			}else if (Five.cheese==2) {
				g.drawImage(Five.img2, 0, 0, getWidth(), getHeight(), FivePanel.this);
				//���������ӦԪ�ص�ֵ
				Five.allCheese[row][column]=2;
//				int x = e.getX();
//				int y = e.getY();
//				System.out.println("("+x+","+y+")");
			}
			
			//ʵ��������ɫ����
			if (Five.cheese==1) {
				Five.cheese=2;
			}else if (Five.cheese==2){
				Five.cheese=1;
			}
			
			for(int v1=0;v1<13;v1++){
				for(int v2=0;v2<13;v2++){
					if(Five.allCheese[v1][v2]==1&&Five.allCheese[v1][v2+1]==1&&Five.allCheese[v1][v2+2]==1&&Five.allCheese[v1][v2+3]==1&&Five.allCheese[v1][v2+4]==1||
					   Five.allCheese[v1][v2]==1&&Five.allCheese[v1+1][v2]==1&&Five.allCheese[v1+2][v2]==1&&Five.allCheese[v1+3][v2]==1&&Five.allCheese[v1+4][v2]==1||
					   Five.allCheese[v1][v2]==1&&Five.allCheese[v1+1][v2+1]==1&&Five.allCheese[v1+2][v2+2]==1&&Five.allCheese[v1+3][v2+3]==1&&Five.allCheese[v1+4][v2+4]==1||
					   Five.allCheese[v1][v2]==1&&Five.allCheese[v1+1][v2-1]==1&&Five.allCheese[v1+2][v2-2]==1&&Five.allCheese[v1+3][v2-3]==1&&Five.allCheese[v1+4][v2-4]==1){
						JOptionPane.showMessageDialog(null, "�����ʤ", "��ս���:", JOptionPane.PLAIN_MESSAGE);   
					}
			   }
		   }
			
		   for(int v1=0;v1<13;v1++){
				for(int v2=0;v2<13;v2++){
					if(Five.allCheese[v1][v2]==2&&Five.allCheese[v1][v2+1]==2&&Five.allCheese[v1][v2+2]==2&&Five.allCheese[v1][v2+3]==2&&Five.allCheese[v1][v2+4]==2||
					   Five.allCheese[v1][v2]==2&&Five.allCheese[v1+1][v2]==2&&Five.allCheese[v1+2][v2]==2&&Five.allCheese[v1+3][v2]==2&&Five.allCheese[v1+4][v2]==2||
					   Five.allCheese[v1][v2]==2&&Five.allCheese[v1+1][v2+1]==2&&Five.allCheese[v1+2][v2+2]==2&&Five.allCheese[v1+3][v2+3]==2&&Five.allCheese[v1+4][v2+4]==2||
					   Five.allCheese[v1][v2]==2&&Five.allCheese[v1+1][v2-1]==2&&Five.allCheese[v1+2][v2-2]==2&&Five.allCheese[v1+3][v2-3]==2&&Five.allCheese[v1+4][v2-4]==2){
						JOptionPane.showMessageDialog(null, "�����ʤ", "��ս���:", JOptionPane.PLAIN_MESSAGE);   
					}
			  }
		  }
			
			//�ڿ���̨�ϴ�ӡ���������ֵ
//			for(int i=0;i<13;i++) {
//				for(int j=0;j<13;j++) {
//					System.out.printf("%2s ",Five.allCheese[i][j]);
//				}
//			System.out.println();
//			}
		}
		
	}

}
