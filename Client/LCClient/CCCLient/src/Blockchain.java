import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Blockchain 
{
	static ArrayList<Block> blockchain = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		blockchain.add(new Block());
		new Wallet();
		System.out.println(isChainValid());
	}
	
	// do a try catch later :3
	public static boolean isChainValid() throws Exception
	{
		Block currentBlock;
		Block previousBlock;
		
		for(int i = 1; i < blockchain.size(); i++)
		{
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			
			if(!currentBlock.computeHash().equals(currentBlock.prevHash))
			{
				return false;
			}
			if(!previousBlock.computeHash().equals(currentBlock.prevHash))
			{
				return false;
			}
		}
		
		return true;
	}
	
}
