package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal_padaction extends JFrame{

	private static final long serialVersionUID = 1456881600611113423L;
	
	// 	ȭ�� ����
	private JTextField inputSpace;
	
	public Cal_padaction() {
		
//		���� ȭ��� ��ư�� �ٿ��� �ǵ� ���ٸ� ���̾ƿ� �����ڸ� ������� ���� ���̱� ������
		setLayout(null);
		
//		����ڰ� ģ ���� �������� ȭ��
		inputSpace = new JTextField();
		inputSpace.setEditable(false);
		inputSpace.setBackground(Color.WHITE);
		inputSpace.setHorizontalAlignment(JTextField.RIGHT);
		inputSpace.setFont(new Font("Arial",Font.BOLD,30));
		inputSpace.setBounds(8,10,270,70);
		
		JPanel buttonPanel = new JPanel();
//		���ڹ��� �����
		buttonPanel.setLayout(new GridLayout(4,4,10,10));
		buttonPanel.setBounds(8,90,270,235);
		
//		��ư �̸� �����
		String button_names[] = {"C", "��", "��", "=", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "0" };
		JButton buttons[] = new JButton[button_names.length];
		
//		for������ ���� �迭�� ��ư �����
		for (int i=0; i<button_names.length; i++) {
			buttons[i] = new JButton(button_names[i]);
			buttonPanel.add(buttons[i]);
			if (button_names[i] == "C") buttons[i].setBackground(Color.RED);
			else if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14)) buttons[i].setBackground(Color.BLACK);
			else buttons[i].setBackground(Color.GRAY);
			buttons[i].setForeground(Color.WHITE);
			buttons[i].setBorderPainted(false); // �׵θ� ���ֱ�
			buttons[i].addActionListener(new PadActionListener());
			buttonPanel.add(buttons[i]);			
		}
		
		add(inputSpace);
		add(buttonPanel);
		
		setTitle("�Ҷ�ǥ ����");
		setVisible(true);
		setSize(300,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
//	Ű�� ���
	class PadActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String operation = e.getActionCommand(); //getActionCommand() : �̺�Ʈ�� �߻���Ų ��ü�� ���ڿ��� �����´�.
			if (operation.equals("C")) { //C�� ��� �����ִ� Ű
				inputSpace.setText("");
				}
			else if (operation.equals("=")) { //=�� ������ ������� �����־���Ѵ�.
				
			}
			else {
				inputSpace.setText(inputSpace.getText() + e.getActionCommand()); // �ٸ� ��쿡�� ���ڸ� �߰��Ѵ�
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cal_padaction();
	}

}
