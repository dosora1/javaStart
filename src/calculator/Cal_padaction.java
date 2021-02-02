package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Cal_padaction extends JFrame{

	private static final long serialVersionUID = 1456881600611113423L;
	
	// 	ȭ�� ����
	private JTextField inputSpace;
	private ArrayList<String> equation = new ArrayList<String>();
	private String num = "";
	public JTextField answer;
	boolean focusJtf = false;	
	
	public Cal_padaction() {
		
//		���� ȭ��� ��ư�� �ٿ��� �ǵ� ���ٸ� ���̾ƿ� �����ڸ� ������� ���� ���̱� ������
		getContentPane().setLayout(null);
		
//		����ڰ� ģ ���� �������� ȭ��
		inputSpace = new JTextField();
		inputSpace.setEditable(true);
		inputSpace.setBackground(Color.WHITE);
		inputSpace.setHorizontalAlignment(JTextField.RIGHT);
		inputSpace.setFont(new Font("Arial",Font.BOLD,30));
		inputSpace.setBounds(8,10,270,50);
		
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
				
		answer = new JTextField();
		answer.setHorizontalAlignment(SwingConstants.RIGHT);
		answer.setBounds(150, 65, 123, 21);
		getContentPane().add(answer);
		answer.setColumns(10);
		
		getContentPane().add(inputSpace);
		getContentPane().add(buttonPanel);
		
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
			else if (operation.equals("=") | focusJtf) { //=�� ������ ������� �����־���Ѵ�.
				String result = Double.toString(calculate(inputSpace.getText()));
				answer.setText(""+result);
				num = "";
			}
			else {
				inputSpace.setText(inputSpace.getText() + e.getActionCommand()); // �ٸ� ��쿡�� ���ڸ� �߰��Ѵ�
			}
			
		}
	}
				
	private void fullTextParsing(String inputText) {
		equation.clear();
		
		for (int i=0; i < inputText.length(); i++ ) {
			char ch = inputText.charAt(i);
			
			if (ch == '-' | ch == '+' | ch == '��' | ch == '��' | ch == '*' | ch == '/') {
				equation.add(num);
				num = ""; // num�� �ʱ�ȭ, �����ȣ�� arraylist�� �߰�
				equation.add(ch + "");
				
			} else {
				num = num + ch; //�����ȣ�� ���� �� arraylist�� �߰��ǰ� �ʱ�ȭ
			}
			
		}
		equation.add(num);
	}
	
	public double calculate(String inputText) { // �����
		fullTextParsing(inputText);
		
		double prev = 0 ;
		double current = 0;
		String mode = ""; // ������ ���
		
		for (String s : equation) {
			if (s.equals("+")) {
				mode = "add";				
			}
			else if (s.equals("-")) {
				mode = "sub";				
			}
			else if (s.equals("��") | s.equals("*")) {
				mode = "mul";				
			}
			else if (s.equals("��") | s.equals("/")) {
				mode = "div";				
			}
			else {
				current = Double.parseDouble(s); // ���ڿ��� double������ �ٲپ��־�� ��.
				if (mode == "add") {
					prev += current;
				}
				else if (mode == "sub") {
					prev -= current;
				}
				else if (mode == "mul") {
					prev *= current;
				}
				else if (mode == "div") {
					prev /= current;
				}
				else {
					prev = current;
				}
			}
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cal_padaction();
	}
}
