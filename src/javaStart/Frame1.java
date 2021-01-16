package javaStart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel btnPanel = new JPanel();
		JLabel label = new JLabel("some text");
		JButton btn1 = new JButton("Click me");
		JButton btn2 = new JButton("Exit");
//		�������� �ؽ�Ʈ�� ���� �� ���
		JTextArea txtArea = new JTextArea();
//		�� �� ������ �ؽ�Ʈ�� ���� �� ���
//		JTextField txtField = new JTextField(200); 
		panel.setLayout(new BorderLayout());
		
//		�������� ������ �г��� �߰��Ǿ���.
		frame.add(panel);
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		panel.add(label,BorderLayout.NORTH);
		panel.add(btnPanel,BorderLayout.WEST);
		panel.add(txtArea, BorderLayout.CENTER);
		
		btn1.addActionListener(new ActionListener(){
//			addActionListner�� �ʼ� �߰� ���
			@Override
			public void actionPerformed(ActionEvent e) {
//				�ؽ�Ʈ ������ �ؽ�Ʈ�� �󺧿� �ֱ�
				label.setText(txtArea.getText());
			}
			
		});
		
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		frame.setTitle("��� ����");
		frame.setVisible(true);
		frame.setSize(new Dimension(350,350));
//		terminating the program.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		centering.
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		
	}

}
