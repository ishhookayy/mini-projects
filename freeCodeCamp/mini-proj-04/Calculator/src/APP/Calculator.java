package APP;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{

	JFrame jframe;
	JTextField textfield;
	JButton[] numButtons = new JButton[10];
	JButton[] funButtons = new JButton[14];
	JButton addButton,subButton,mulButton,divButton;
	JButton logButton,eqButton,clrButton,delButton,negButton;
	JButton decButton,facButton,powButton,sqrButton,modButton;
	JPanel panel;
	
	Font myfont=new Font("Helticva",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		jframe= new JFrame("Calculator App");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(450,600);
		jframe.setLayout(null);
		jframe.setResizable(false);
		
		
		textfield=new JTextField();
		textfield.setBounds(40,20,350,50);
		textfield.setFont(myfont);
		textfield.setEditable(false);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		eqButton = new JButton("=");
		delButton = new JButton("DC");
		clrButton = new JButton("C");
		negButton = new JButton("(-)");
		facButton = new JButton("n!");
		powButton = new JButton("^");
		sqrButton = new JButton("x²");
		modButton = new JButton("%");
		logButton = new JButton("log");

		funButtons[0]  =  addButton;
		funButtons[1]  =  subButton;
		funButtons[2]  =  mulButton;
		funButtons[3]  =  divButton;
		funButtons[4]  =  decButton;
		funButtons[5]  =  eqButton;
		funButtons[6]  =  delButton;
		funButtons[7]  =  clrButton;
		funButtons[8]  =  negButton;
		funButtons[9]  =  facButton;
		funButtons[10] =  powButton;
		funButtons[11] =  sqrButton;
		funButtons[12] =  modButton;
		funButtons[13] =  logButton;

		

		for(int i=0;i<14;i++) {
			funButtons[i].addActionListener(this);
			funButtons[i].setBackground(Color.GREEN);
			funButtons[i].setFont(myfont);
			funButtons[i].setFocusable(false);
		}
		
		for(int i=0;i<10;i++) {
			numButtons[i]= new JButton(String.valueOf(i));
			numButtons[i].setBackground(Color.CYAN);
			numButtons[i].addActionListener(this);
			numButtons[i].setFont(myfont);
			numButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(40,90,80,50);
		logButton.setBounds(130,90,80,50);
		delButton.setBounds(220,90,85,50);
		clrButton.setBounds(306,90,85,50);
		delButton.setBackground(Color.RED);
		clrButton.setBackground(Color.RED);
		
		panel = new JPanel();
		panel.setBounds(40,160,350,350);
		panel.setLayout(new GridLayout(4,5,10,10));
		
		panel.add(numButtons[1]);
		panel.add(numButtons[2]);
		panel.add(numButtons[3]);
		panel.add(addButton);
		panel.add(facButton);
		panel.add(numButtons[4]);
		panel.add(numButtons[5]);
		panel.add(numButtons[6]);
		panel.add(subButton);
		panel.add(powButton);
		panel.add(numButtons[7]);
		panel.add(numButtons[8]);
		panel.add(numButtons[9]);
		panel.add(mulButton);
		panel.add(sqrButton);
		panel.add(decButton);
		panel.add(numButtons[0]);
		panel.add(eqButton);
		panel.add(divButton);
		panel.add(modButton);
		
		jframe.add(panel);
		jframe.add(logButton);
		jframe.add(negButton);
		jframe.add(delButton);
		jframe.add(clrButton);
		jframe.add(textfield);
		jframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++) {
			if(e.getSource()==numButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		
		if(e.getSource()== addButton) {
			num1 =Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource()== subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource()== mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator='*';
			textfield.setText("");
		}
		if(e.getSource()== divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator='/';
			textfield.setText("");
		}
		
		if(e.getSource() == powButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '^';
			textfield.setText("");
		}
		if(e.getSource() == modButton) {
			num1=Double.parseDouble(textfield.getText());
			operator = '%';
			textfield.setText("");
		}

		
		if(e.getSource() == eqButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			
			case '^':
				result = Math.pow(num1, num2);
				break;
			case '%':
				result = num1%num2;
				break;	
				
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		
		if(e.getSource() == negButton) {
			num1 = Double.parseDouble(textfield.getText());
			num1*=-1;
			textfield.setText(String.valueOf(num1));
		}
		
		if(e.getSource() == facButton) {
			num1 = Double.parseDouble(textfield.getText());
			
			result =1;
			
		    for (double i = 1; i <= num1; i++) {
		        result *= i; // Multiply the result by i in each iteration
		    }
		    
		    num1=result;
		    textfield.setText(String.valueOf(num1));
		 }
		
		if(e.getSource() == sqrButton) {
			num1 = Double.parseDouble(textfield.getText());
			result = Math.pow(num1, 2);
			num1 = result;
			
			textfield.setText(String.valueOf(num1));
		}
		
		if(e.getSource() == logButton) {
			num1 = Double.parseDouble(textfield.getText());
			result = Math.log(num1);
			num1 = result;
			
			textfield.setText(String.valueOf(num1));

		}
		
	}


}
