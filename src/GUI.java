
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;



public class GUI extends JFrame implements KeyListener, ActionListener {

	public int score;
	public String userInput;
	public Graphics g;
	public Image car1, car2, car3;
	public JPanel panel;
	public JPanel enterPanel;
	public CardLayout layout;
	public String scoreboard[] = new String[5];
	public JTextField textField;
	public JButton button;
	public static ScoreBoardAlgo scr_obb;
	public static GUI a;


	public GUI(String title) {
		super(title);
		setBounds(550, 50, 700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layout = new CardLayout();
		panel = new JPanel(layout);
		add(panel);
		addKeyListener(this);
		setFocusable(true);
		setResizable(false);
		setVisible(true);

	}

	public void addCard(JPanel card, String name) {
		panel.add(card, name);
	}

	public void showCard(String cardName) {
		layout.show(panel, cardName);
	}


	public void UIenterance(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, 700, 700);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(100, 100, 500, 100);
		g.setFont(new Font("MV Boli", Font.BOLD, 24));
		g.setColor(Color.white);
		g.drawString("🏎️ Welcome to Highway Racer 🏎️", 140, 150);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(225, 250, 250, 75);
		g.setFont(new Font("MV Boli", Font.BOLD, 24));
		g.setColor(Color.white);
		g.drawString("Play (P)", 300, 300);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(250, 375, 200, 50);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Exit (E)", 310, 405);
		//---------------------------------------------
	}

	public void Draw_Enterance(GUI a) {
		enterPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				UIenterance(g);
			}
		};
		a.addCard(enterPanel, "enterance");
	}

	public void UIplay(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, 700, 700);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(100, 100, 500, 100);
		g.setFont(new Font("MV Boli", Font.BOLD, 24));
		g.setColor(Color.white);
		g.drawString("🏎️ Highway Racer 🏎️", 220, 150);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(200, 250, 300, 100);
		g.setFont(new Font("MV Boli", Font.BOLD, 24));
		g.setColor(Color.white);
		g.drawString("Start Game (S)", 240, 300);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(250, 375, 200, 50);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Score Board (B)", 260, 400);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(250, 450, 200, 50);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Choose Car (C)", 260, 475);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(250, 525, 200, 50);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("How to Play ? (H)", 253, 550);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(250, 600, 200, 50);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Back (X)", 300, 625);
		//---------------------------------------------
	}

	public void Draw_Play(GUI a) {
		enterPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				UIplay(g);
			}
		};
		a.addCard(enterPanel, "play");
	}

	public void UIscoreboard(Graphics g) {

		int x_pos_scr = 220;
		int y_pos_scr = 300;
		//---------------------------------------------
		g.setColor(Color.blue);
		g.fillRect(0, 0, 700, 700);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(100, 50, 500, 100);
		g.setFont(new Font("MV Boli", Font.BOLD, 24));
		g.setColor(Color.white);
		g.drawString("🏎️ Highway Racer 🏎️", 220, 100);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(150, 175, 400, 400);
		ScoreBoardAlgo scr_obb = new ScoreBoardAlgo();
		scr_obb.Read_and_Process();
		for (int i = 0; i < 5; i++) {
			g.setFont(new Font("MV Boli", Font.BOLD, 20));
			g.setColor(Color.white);
			g.drawString(scr_obb.lines[i], x_pos_scr, y_pos_scr); 
			y_pos_scr += 35;}
			//----------------------------------------------
			g.setColor(Color.red);
			g.fillRect(250, 600, 200, 50);
			g.setFont(new Font("MV Boli", Font.BOLD, 20));
			g.setColor(Color.white);
			g.drawString("Back (X)", 300, 630);
	}
	

	public void Draw_ScoreBoard(GUI a) {
		enterPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				UIscoreboard(g);
			}
		};
		a.addCard(enterPanel, "scoreboard");
	}

	public void UIhowtoplay(Graphics g) {

		//---------------------------------------------
		g.setColor(Color.blue);
		g.fillRect(0, 0, 700, 700);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(100, 50, 500, 100);
		g.setFont(new Font("MV Boli", Font.BOLD, 24));
		g.setColor(Color.white);
		g.drawString("🏎️ Highway Racer 🏎️", 220, 100);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(40, 175, 600, 400);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("You are driving in ongoing trafic", 150, 260);
		g.drawString("Your objective is to navigate around ", 130, 300);
		g.drawString("the trafic without crashing other cars", 120, 320);
		g.drawString("As You drive you will earn more scores", 115, 340);
		g.drawString("Use LEFT and RIGHT arrow keys to change lanes", 80, 380);
		g.drawString("You wont be able to see the cars after a while", 90, 400);
		g.drawString("Use UP arrow key to use your headlight to see cars", 60, 420);
		g.drawString("Every time you change a lane you need to open your", 75, 460);
		g.drawString("headlights again with UP key again", 150, 480);
		//----------------------------------------------
		g.setColor(Color.red);
		g.fillRect(250, 600, 200, 50);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Back (X)", 300, 630);
	}
	

	public void Draw_HowtoPlay(GUI a) {
		enterPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				UIhowtoplay(g);
			}
		};
		a.addCard(enterPanel, "howtoplay");
	}

	public void UIchoosecar(Graphics g) {

		car1 = new ImageIcon(".\\lib\\Textures\\gamecar1.png").getImage();
		car2 = new ImageIcon(".\\lib\\Textures\\gamecar2.png").getImage();
		car3 = new ImageIcon(".\\lib\\Textures\\gamecar3.png").getImage();
		//------------------------------------------
		g.setColor(Color.blue);
		g.fillRect(0, 0, 700, 700);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(120, 20, 450, 175);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Select Car 1: (Num 1)", 145, 110);
		g.drawImage(car1, 470, 20, null);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(120, 220, 450, 175);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Select Car 2: (Num 2)", 145, 310);
		g.drawImage(car2, 470, 220, null);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(120, 420, 450, 175);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Select Car 3: (Num 3)", 145, 510);
		g.drawImage(car3, 470, 420, null);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(275, 620, 150, 30);
		g.setFont(new Font("MV Boli", Font.BOLD, 17));
		g.setColor(Color.white);
		g.drawString("Back (X)", 315, 640);
	}

	public void Draw_ChooseCar(GUI a) {
		enterPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				UIchoosecar(g);
			}
		};
		a.addCard(enterPanel, "choosecar");
	}

	public void UIchoosecar_succesfull(Graphics g) {
		//--------------------------------------------
		g.setColor(Color.blue);
		g.fillRect(0, 0, 700, 700);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(120, 220, 450, 175);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Car Selected!", 145, 310);
		//----------------------------------------------
		//----------------------------------------------
		g.setColor(Color.red);
		g.fillRect(250, 600, 200, 50);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Back (X)", 300, 630);
	}

	public void Draw_ChooseCar_Succesfull(GUI a) {
		enterPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				UIchoosecar_succesfull(g);
			}
		};
		a.addCard(enterPanel, "choosecar_succesfull");
	}

	public void New_High_Score(Graphics g) {
		//--------------------------------------------
		g.setColor(Color.blue);
		g.fillRect(0, 0, 700, 300);
		g.setColor(Color.blue);
		g.fillRect(0, 300, 250, 30);
		g.setColor(Color.blue);
		g.fillRect(450, 300, 250, 30);
		g.setColor(Color.blue);
		g.fillRect(0, 330, 700, 20);
		g.setColor(Color.blue);
		g.fillRect(0, 350, 300, 30);
		g.setColor(Color.blue);
		g.fillRect(400, 350, 300, 30);
		g.setColor(Color.blue);
		g.fillRect(0, 380, 700, 320);
		g.setColor(Color.red);
		g.fillRect(120, 120, 450, 175);
		//---------------------------------------------
		g.setFont(new Font("MV Boli", Font.BOLD, 30));
		g.setColor(Color.white);
		g.drawString("New High Score!", 230, 170);
		g.setFont(new Font("MV Boli", Font.BOLD, 15));
		g.setColor(Color.white);
		g.drawString("Enter Your Name for Score Board (Max 10 Characters)", 150, 215);
		g.setFont(new Font("MV Boli", Font.BOLD, 30));
		g.setColor(Color.white);
		g.drawString("Your Score: " + CarGame.score + "!", 220, 260);
		//----------------------------------------------
		g.setColor(Color.red);
		g.fillRect(250, 500, 200, 50);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Back (X)", 300, 530);
	}

	public void Draw_NewHighScore(GUI a) {
		enterPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				New_High_Score(g);
			}
		};
		textField = new JTextField(10);
		textField.setBounds(250, 300, 200, 30);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userInput = textField.getText();
				if(userInput.length() > 10){
					showCard("score_not_succesful");
				} else if(userInput.length() <= 10){
					scr_obb.Insert_New_HS(userInput);
					showCard("score_succesful");}
				}});

		enterPanel.setLayout(null);
		enterPanel.add(textField);
		enterPanel.add(button);   
		a.addCard(enterPanel, "newhighscore");
	}

	public void Score_Succesful(Graphics g) {
		//--------------------------------------------
		g.setColor(Color.blue);
		g.fillRect(0, 0, 700, 700);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(120, 220, 450, 175);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Done !", 145, 310);
		//----------------------------------------------
		//----------------------------------------------
		g.setColor(Color.red);
		g.fillRect(250, 600, 200, 50);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Back (X)", 300, 630);
	}

	public void Draw_Score_Succesfull(GUI a) {
		enterPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Score_Succesful(g);
			}
		};
		a.addCard(enterPanel, "score_succesfull");
	}

	public void Score_Not_Succesful(Graphics g) {
		//--------------------------------------------
		g.setColor(Color.blue);
		g.fillRect(0, 0, 700, 700);
		//---------------------------------------------
		g.setColor(Color.red);
		g.fillRect(120, 220, 450, 175);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Invalid Name !", 145, 310);
		//----------------------------------------------
		//----------------------------------------------
		g.setColor(Color.red);
		g.fillRect(250, 600, 200, 50);
		g.setFont(new Font("MV Boli", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Try Again (T)", 300, 630);
	}

	public void Draw_Score_Not_Succesfull(GUI a) {
		enterPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Score_Not_Succesful(g);
			}
		};
		a.addCard(enterPanel, "score_succesfull");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_P) {
			repaint();
			showCard("play");
		}

		if (e.getKeyCode() == KeyEvent.VK_E) {
			System.exit(0);
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			CarGame.MAIN();
		}

		if (e.getKeyCode() == KeyEvent.VK_B) {
			showCard("scoreboard");
		}

		if (e.getKeyCode() == KeyEvent.VK_C) {
			showCard("choosecar");
		}
		
		if (e.getKeyCode() == KeyEvent.VK_H) {
			showCard("howtoplay");
		}

		if (e.getKeyCode() == KeyEvent.VK_X) {
			showCard("enterance");
		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
			CarGame.car_location = ".\\lib\\Textures\\gamecar1.png";
			showCard("choosecar_succesfull");
		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
			CarGame.car_location = ".\\lib\\Textures\\gamecar2.png";
			showCard("choosecar_succesfull");
		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
			CarGame.car_location = ".\\lib\\Textures\\gamecar3.png";
			showCard("choosecar_succesfull");
		}
		if (e.getKeyCode() == KeyEvent.VK_T) {
			showCard("newhighscore");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		//ignore
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//ignore
	}

	public static void main(String[] args) {
		System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
		scr_obb = new ScoreBoardAlgo();
		scr_obb.Read_and_Process();
		a = new GUI("Highway Racer");
		a.Draw_Enterance(a);
		a.Draw_Play(a);
		a.Draw_ChooseCar(a);
		a.Draw_ScoreBoard(a);
		a.Draw_HowtoPlay(a);
		a.Draw_ChooseCar_Succesfull(a);
		a.Draw_NewHighScore(a);
		a.Draw_Score_Succesfull(a);
		a.Draw_Score_Not_Succesfull(a);
		a.showCard("enterance");
	}
}