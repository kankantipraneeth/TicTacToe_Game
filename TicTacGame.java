import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacGame implements ActionListener
{
	Random random=new Random();
	JFrame frame =new JFrame();
	JPanel title_panel=new JPanel();
	JPanel button_panel=new JPanel();
	JLabel text_field=new JLabel();
	JButton[] button=new JButton[9];
	JButton resetbutton=new JButton();
	boolean player1_turn;
	
	
	
	TicTacGame()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		text_field.setBackground(new Color(25,25,25));
		text_field.setForeground(new Color(25,255,0));
		text_field.setFont(new Font("Ink Free",Font.BOLD,75));
		text_field.setHorizontalAlignment(JLabel.CENTER);
		text_field.setText("Tic-Tac_Toe: Game..x..o..x..");
		text_field.setOpaque(true);
	
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,80);
		
		resetbutton.setBounds(0,0,100,50);
		resetbutton.setText("New Game");
		resetbutton.setFont(new Font("Serif",Font.BOLD,10));
		resetbutton.setVerticalAlignment(JLabel.CENTER);
		resetbutton.addActionListener(this);
		title_panel.add(resetbutton);
		
		title_panel.add(text_field);
		frame.add(title_panel,BorderLayout.NORTH );
		
		frame.add(resetbutton);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.GRAY);
		frame.add(button_panel);
		
		for(int i=0;i<9;i++)
		{
			button[i]=new JButton();
			button_panel.add(button[i]);
			button[i].setFont(new Font("MV Boli",Font.ITALIC,120));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		firstchance();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource()==resetbutton)
		{
			//reset();
			TicTacGame tictac = new TicTacGame();
		}
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==button[i])
			{
				if(player1_turn)
				{
					if(button[i].getText()=="")
					{
						button[i].setForeground(Color.RED);
						button[i].setText("X");
						player1_turn=false;
						text_field.setText("O turn");
						wincheck();
					}
				}
				else
				{
					if(button[i].getText()=="")
					{
						button[i].setForeground(Color.GREEN);
						button[i].setText("O");
						player1_turn=true;
						text_field.setText("X turn");
						wincheck();
					}
				}
			}
		}
			
		
	}
	public void firstchance()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2)==0)
		{
			player1_turn=true;
			text_field.setText("O-turn..");
		}
		else
		{
			player1_turn=false;
			text_field.setText("O-turn..");
		}
		
	}
	public void wincheck()
	{
		//X wins condition:
		if((button[0].getText()=="X") &&
				(button[1].getText()=="X")&&
				(button[2].getText()=="X")) 
		{
			xWins(0,1,2);
		}
		if( (button[3].getText()=="X") &&
			(button[4].getText()=="X")&&
			(button[5].getText()=="X")) 
		{
			xWins(3,4,5);
		}
		if( (button[6].getText()=="X") &&
				(button[7].getText()=="X")&&
				(button[8].getText()=="X")) 
			{
				xWins(6,7,8);
			}
		if( (button[0].getText()=="X") &&
				(button[3].getText()=="X")&&
				(button[6].getText()=="X")) 
			{
				xWins(0,3,6);
			}
		if( (button[1].getText()=="X") &&
				(button[4].getText()=="X")&&
				(button[7].getText()=="X")) 
			{
				xWins(1,4,7);
			}
		if( (button[2].getText()=="X") &&
				(button[5].getText()=="X")&&
				(button[8].getText()=="X")) 
			{
				xWins(2,5,8);
			}
		if( (button[0].getText()=="X") &&
				(button[4].getText()=="X")&&
				(button[8].getText()=="X")) 
			{
				xWins(0,4,8);
			}
		if( (button[2].getText()=="X") &&
				(button[4].getText()=="X")&&
				(button[6].getText()=="X")) 
			{
				xWins(2,4,6);
			}
		//O wins condition:
		if((button[0].getText()=="O") &&
				(button[1].getText()=="O")&&
				(button[2].getText()=="O")) 
		{
			oWins(0,1,2);
		}
		if( (button[3].getText()=="O") &&
			(button[4].getText()=="O")&&
			(button[5].getText()=="O")) 
		{
			oWins(3,4,5);
		}
		if( (button[6].getText()=="O") &&
				(button[7].getText()=="O")&&
				(button[8].getText()=="O")) 
			{
				oWins(6,7,8);
			}
		if( (button[0].getText()=="O") &&
				(button[3].getText()=="O")&&
				(button[6].getText()=="O")) 
			{
				oWins(0,3,6);
			}
		if( (button[1].getText()=="O") &&
				(button[4].getText()=="O")&&
				(button[7].getText()=="O")) 
			{
				oWins(1,4,7);
			}
		if( (button[2].getText()=="O") &&
				(button[5].getText()=="O")&&
				(button[8].getText()=="O")) 
			{
				oWins(2,5,8);
			}
		if( (button[0].getText()=="O") &&
				(button[4].getText()=="O")&&
				(button[8].getText()=="O")) 
			{
				oWins(0,4,8);
			}
		if( (button[2].getText()=="O") &&
				(button[4].getText()=="O")&&
				(button[6].getText()=="O")) 
			{
				oWins(2,4,6);
			}
	}
	public void xWins(int a, int b, int c)
	{
		button[a].setBackground(Color.CYAN);
		button[b].setBackground(Color.CYAN);
		button[c].setBackground(Color.CYAN);
		for (int i=0;i<9;i++)
		{
			button[i].setEnabled(false);
		}
		text_field.setText("X-wins");
	}
	public void oWins(int a, int b, int c)
	{
		button[a].setBackground(Color.CYAN);
		button[b].setBackground(Color.CYAN);
		button[c].setBackground(Color.CYAN);
		for (int i=0;i<9;i++)
		{
			button[i].setEnabled(false);
		}
		text_field.setText("O-wins");
	}
	public void reset()
	{
		TicTacGame tictac=new TicTacGame();
		
	}
}
