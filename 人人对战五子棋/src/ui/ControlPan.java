package ui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ControlPan extends JPanel{

	ButtonGroup bg = new ButtonGroup();
	
	public JRadioButton s1 = new JRadioButton("��������",true);
	public JRadioButton s2 = new JRadioButton("��������",false);
	
	JButton bstart = new JButton("��ʼ�¾�");
	JButton bregret = new JButton("��  ��");
	JButton bexit = new JButton("��  ��");
	
	ControlPan(){
		setLayout(new GridLayout(14,1,10,5));
		s1.setContentAreaFilled(false);
		s2.setContentAreaFilled(false);
		bstart.setContentAreaFilled(false);
		bregret.setContentAreaFilled(false);
		bexit.setContentAreaFilled(false);
		bg.add(s1);
		bg.add(s2);
		
		add(s1);
		add(s2);
		add(bstart);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(bregret);
		add(bexit);
		setBounds(0,0,200,500);
		
		ButtonClick bc = new ButtonClick();
		s1.addActionListener(bc);
		s2.addActionListener(bc);
		bstart.addActionListener(bc);
		bregret.addActionListener(bc);
		bexit.addActionListener(bc);
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img2 = Toolkit.getDefaultToolkit().getImage("bk.png");
		g.drawImage(img2, 0, 0, getSize().width, getSize().height, this);
	}
	
	class ButtonClick implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//���¿�ʼ
			if(e.getSource()==bstart) {
				for(int i=0;i<13;i++) {
					for(int j=0;j<13;j++) {
						Five.allCheese[i][j]=0;
					}
				}	
//				new Five().isResizable();
				for(int i=0;i<13;i++) {
					for(int j=0;j<13;j++) {
						Bowl.fp[i][j].repaint();
					}
				}	
			}
			
			//�����߻��Ǻ�����
			else if(e.getSource()==s1) {
				Five.cheese=1;
			}else if(e.getSource()==s2) {
				Five.cheese=2;
			}
			
			//����
			else if(e.getSource()==bregret) {
				JOptionPane.showMessageDialog(null, "���һ����������Ϸ���򣬺ڰ�˫���������壬��ĳһ����������ʱ����Ϸ������", "����", JOptionPane.PLAIN_MESSAGE);
			}
			
			//�˳�
			else if(e.getSource()==bexit) {
				System.exit(0);
			}
		}
	}
}
