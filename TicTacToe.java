import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToe extends JPanel
{
    int i=0;
    int j=0;
    int flag=0;
    JButton bu[]=new JButton[9]; 
    int change=0;
    
    public TicTacToe()
    {
      setLayout(new GridLayout(3,3));
      initialization(); 
    }
    
    public void initialization()
    {
        for(int i=0;i<=8;i++)
        {
            bu[i] = new JButton();
            bu[i].setText("");
            bu[i].addActionListener(new buttonListener());
            add(bu[i]);     
        }
    }
   private class buttonListener implements ActionListener 
    {
       
        public void actionPerformed(ActionEvent e) 
        {            
            JButton Click = (JButton)e.getSource();
            if(change%2 == 0)
            {
                Click.setText("X");
		i++;
            }
            else
	    {
                Click.setText("O");
                j++;
	    }
            if(checkForWin() == true)
            {	
		if(i>j)
                {	
			JOptionPane.showMessageDialog(null, "Player 1 wins");
			System.exit(0);
		}
		else if(i==j)
		{
			JOptionPane.showMessageDialog(null, "Player 2 wins");
			System.exit(0);
		}
            }
	    else if (flag==9) 
	        System.exit(0);
	change++;
        }
        
        public boolean checkForWin()
        {
		//horizontal
            if( Adj(0,1) && Adj(1,2) ) //no need to put " == true" because the default check is for true
                return true;
            else if( Adj(3,4) && Adj(4,5) )
                return true;
            else if ( Adj(6,7) && Adj(7,8))
                return true;
            //vertical
            else if ( Adj(0,3) && Adj(3,6))
                return true;  
            else if ( Adj(1,4) && Adj(4,7))
                return true;
            else if ( Adj(4,5) && Adj(5,8))
                return true;
            //diagonal
            else if ( Adj(0,4) && Adj(4,8))
                return true;  
            else if ( Adj(2,4) && Adj(4,6))
                return true;
            else 
	    {
		flag++;
		return false;
            }    
        }
        
        public boolean Adj(int a, int b)
        {
            if ( bu[a].getText().equals(bu[b].getText()) && !bu[a].getText().equals("") )
                return true;
            else
                return false;
        }
        
    }
	
    
    public static void main(String[] args) 
    {
        JFrame obj = new JFrame("Tic-Tac-Toe");
        obj.getContentPane().add(new TicTacToe());
        obj.setBounds(300,200,300,300);
        obj.setVisible(true);
    }
}