
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

class CarGame extends JFrame implements KeyListener,ActionListener
{
	public int xpos = 300;     // X POS(CAR) (CarAlgorithm)
	public int ypos = 700;     // Y POS(CAR) (CarAlgorithm)
	public ImageIcon car;      // Car Image

	public static String car_location = ".\\lib\\Textures\\gamecar4.png";
	Random random = new Random(); // Random number generator
	public int num1 = 400,num2 = 0,num3 = 0; // X POS(OBSTACLES) (CarAlgorithm)
	public int tree1ypos = 400,tree2ypos = -200,tree3ypos = -500,tree4ypos = 100,tree5ypos = -300,tree6ypos = 500; // Y POS(OBSTACLES)(CarAlgorithm)
	public int roadmove = 0; // Y POS(ROAD)
	public int carxpos[]={100,200,300,400,500}; // X POS(CAR)(CarAlgorithm)
	public int carypos[]= {-240,-480,-720,-960,-1200}; // Y POS(CAR)(CarAlgorithm)
	public int cxpos1 = 0,cxpos2 = 2,cxpos3 = 4; // X POS(CAR)(CarAlgorithm)
	public int cypos1 = random.nextInt(5),cypos2 = random.nextInt(5),cypos3 = random.nextInt(5); // Y POS(CAR)(CarAlgorithm)
	int y1pos = carypos[cypos1], y2pos = carypos[cypos2], y3pos = carypos[cypos3]; // Y POS(CAR)(CarAlgorithm)
	public ImageIcon car1,car2,car3,tree1,tree2,tree3,headlight; // Car image
	public static int score = 0, speed = 90; // Score,delay and speed of the game
	public long delay = 75;
	public boolean rightrotate = false, gameover = false, paint = false; // Boolean variables to control the game logic and the graphics
	
	// constructor to initialize the game
	public CarGame(String title)
	{
		super(title); // Call the constructor of the parent class JFrame
		setBounds(550,50,700,700); // Set the position and size of the frame
		setVisible(true); // make the frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the frame when the close button is clicked
		setLayout(null); // Set the layout of the frame to null
		addKeyListener(this); // Add the key listener to the frame
		setFocusable(true); // Set the focus to the frame
		setResizable(false); // Set the frame to be non resizable
	}




	public void paint(Graphics g) // This method is used to paint the graphics on the screen.
	{
		g.setColor(new Color(0X82CD47)); // Set the color of the grass
		g.fillRect(0, 0, 700, 700);  // Draw the grass
		g.setColor(new Color(0X9F8772)); // Set the color of the road
		g.fillRect(100,0,500,700);// Draw the road
		g.setColor(new Color(000000)); // Set the color of the barier
		g.fillRect(90,0,10,700);// Draw the barier
		g.setColor(new Color(000000)); // Set the color of the barier
		g.fillRect(600,0,10,700);// Draw the barier
		
	// Draw the road lines 
	if(roadmove == 0) {
		    for(int i = 0; i <= 700; i = i+100) { 
		 	// Draw the road lines
			g.setColor(Color.white);
			g.fillRect(345, i,10, 70);
			g.setColor(Color.white);
			g.fillRect(220, i,10, 70); 
			g.setColor(Color.white);
			g.fillRect(470, i,10, 70);   
	}
		    roadmove = 1; // Set the road move to 1 
	}
	
	else if(roadmove == 1){
	//Draw the road lines again for the next frame
		    for(int i = 50; i <= 700; i = i+100){
				g.setColor(Color.white);
				g.fillRect(345, i,10, 70);
				g.setColor(Color.white);
				g.fillRect(220, i,10, 70); 
				g.setColor(Color.white);
				g.fillRect(470, i,10, 70); 
		}
		roadmove=0; // Set the road move to 0
	}
	
	try {
		File image_1 = new File(".\\lib\\Textures\\tree_1.png");
		tree1 = new ImageIcon(ImageIO.read(image_1));; //Load the tree image
	} catch (IOException e) {
		e.printStackTrace();
	}
//---------------------------------------------------------------------------------------------------
	try {
		File image_2 = new File(".\\lib\\Textures\\tree_2.png");
		tree2 = new ImageIcon(ImageIO.read(image_2));; //Load the tree image
	} catch (IOException e) {
		e.printStackTrace();
	}
//---------------------------------------------------------------------------------------------------
	try {
		File image_3 = new File(".\\lib\\Textures\\tree_3.png");
		tree3 = new ImageIcon(ImageIO.read(image_3));; //Load the tree image 
	} catch (IOException e) {
		e.printStackTrace();
	}
//---------------------------------------------------------------------------------------------------

	tree1.paintIcon(this, g, 0, tree1ypos); // Draw the tree image on the screen
	num1 = random.nextInt(500); // Generate a random number
	tree1ypos += 50; // Increment the y position of the tree
	
	tree2.paintIcon(this, g, 0,tree2ypos ); // Draw the tree image on the screen
	tree2ypos+=50; // increment the y position of the tree
	
	tree3.paintIcon(this,g,0,tree3ypos); // draw the tree image on the screen
	tree3ypos += 50; // increment the y position of the tree
	tree1.paintIcon(this,g,600,tree4ypos);
	tree4ypos+=50;
	tree3.paintIcon(this, g,600,tree5ypos);
	tree5ypos+=50;
	tree2.paintIcon(this, g,600,tree6ypos);
	tree6ypos += 50;
	
		
	if(tree1ypos > 700)
	{ // if the tree goes out of the screen then reset the treell
		num1 = random.nextInt(500); // generate a random number
		tree1ypos = -num1; // reset the y position of the tree
	}
	
	if(tree2ypos > 700)
	{ 
		num1 = random.nextInt(500);
		tree2ypos =- num1;
	}
	
	if(tree3ypos > 700)
	{
		num1 = random.nextInt(500);
		tree3ypos = -num1;
	}
	
	if(tree4ypos > 700)
	{ // if the tree goes out of the screen then reset the tree
		num1=random.nextInt(500);
		tree4ypos=-num1;
	}
	
	if(tree5ypos > 700)
	{
		num1 = random.nextInt(500);
		tree5ypos = -num1;
	}
	
	if(tree6ypos > 700)
	{ // if the tree goes out of the screen then reset the tree
		num1 = random.nextInt(500);
		tree6ypos = -num1;
	}
		// load image for car
		try {
			File image_4 = new File(car_location);
			car =new ImageIcon(ImageIO.read(image_4));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		// car = new ImageIcon("gamecar1.png");
		car.paintIcon(this,g,xpos,ypos); // draw the car image on the screen
		
		ypos -= 40;
		if(ypos < 500)
		{
		ypos = 500;
		}
		
		//---------------------------------------------------------------------------------------------------
		// load the opponent image for car 
		try {
			File image_5 = new File(".\\lib\\Textures\\gamecar1.png");
			car1 = new ImageIcon(ImageIO.read(image_5));
		} catch (IOException e) {
				e.printStackTrace();
		}
		//---------------------------------------------------------------------------------------------------
		// load the opponent image for car
		try {
			File image_6 = new File(".\\lib\\Textures\\gamecar2.png");
			car2 = new ImageIcon(ImageIO.read(image_6));
		} catch (IOException e) {
				e.printStackTrace();
		}
		//---------------------------------------------------------------------------------------------------
		// load the opponent image for car	
		try {
			File image_7 = new File(".\\lib\\Textures\\gamecar3.png");
			car3 = new ImageIcon(ImageIO.read(image_7));
		} catch (IOException e) {
				e.printStackTrace();
		}
		//---------------------------------------------------------------------------------------------------
		// load player headlight
		try {
			File image_8 = new File(".\\lib\\Textures\\Headlight.png");
			headlight = new ImageIcon(ImageIO.read(image_8));; 
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
		car1.paintIcon(this, g, carxpos[cxpos1], y1pos); // draw the opponent car image on the screen
		car2.paintIcon(this, g, carxpos[cxpos2], y2pos); 
		car3.paintIcon(this, g, carxpos[cxpos3], y3pos);
		y1pos += 50; // increment the y position of the opponent car// (CarAlgorithm)
		y2pos += 50;// (CarAlgorithm)
		y3pos += 50;// (CarAlgorithm)
		
		if(y1pos > 700)// (CarAlgorithm)
		{
			// if the opponent car goes out of the screen then reset the opponent car
			cxpos1 = random.nextInt(5); // generate a random number
			cypos1 = random.nextInt(5);
			y1pos = carypos[cypos1]; // reset the y position of the opponent car
			
		}

		if(y2pos > 700)// (CarAlgorithm)
		{
		 // if the opponent car goes out of the screen then reset the opponent car
			cxpos2++;
			if(cxpos2 > 4)
			{ 
				cxpos2 = 0;
			}
			
			cxpos2 = random.nextInt(5);
			cypos2 = random.nextInt(5);
			y2pos = carypos[cypos2];
			
		}

		if(y3pos > 700)// (CarAlgorithm)
		{
			cxpos3++;
			if(cxpos3 > 4)
			{
				cxpos3 = 0;
			}
			cxpos3 = random.nextInt(5);
			cypos3 = random.nextInt(5);
			y3pos = carypos[cypos3];
		}
	
		if(cxpos1 == cxpos2 && cypos1>-100 && cypos2 > -100) // (CarAlgorithm)
		{ 
			cxpos1 -= 1;
			if(cxpos1 < 0)
			{
				cxpos1 += 2;
			}
		}

		if(cxpos1 == cxpos3 && cypos1 > -100 && cypos3 > -100) // (CarAlgorithm)
		{
			cxpos3 -= 1;
			if(cxpos3 < 0)
			{
				cxpos3 += 2;
			}
		}
		if(cxpos2 == cxpos3 && cypos3 > -100 && cypos2 > -100)// (CarAlgorithm)
		{
			cxpos2 -= 1;
			if(cxpos2 < 0)
			{
				cxpos2 += 2;
			}
		}

		if(cxpos1 < 2 && cxpos2 < 2 && cxpos3 < 2)// (CarAlgorithm)
		{
			if(cxpos1 == 0 && cxpos2 == 0 && cxpos3 == 1)
			{
				cxpos3++;
				cxpos2++;
			}
			else if(cxpos1 == 0 && cxpos2 == 1 && cxpos3 == 0)
			{
				cxpos3++;
				cxpos2++;
			}
			else if(cxpos1 == 1 && cxpos2 == 0 && cxpos3 == 0)
			{
				cxpos1++;
				cxpos2++;
			}
		}
		
		// if the opponent car hits the player car then reset the game // (CarAlgorithm)
		if(y1pos < ypos && y1pos+175 > ypos && carxpos[cxpos1] == xpos)
		{ 
		gameover = true;
		}

		if(y2pos < ypos && y2pos+175 > ypos && carxpos[cxpos2] == xpos)
		{ 
		gameover = true;
		}

		if(y3pos < ypos  && y3pos+175 > ypos && carxpos[cxpos3] == xpos)
		{
		gameover = true;
		}

		if(ypos<y1pos && ypos+175 > y1pos && carxpos[cxpos1] == xpos)
		{
		gameover = true;
		}

		if(ypos < y2pos && ypos+175 > y2pos && carxpos[cxpos2] == xpos)
		{
		gameover = true;
		}

		if(ypos < y3pos  && ypos+175 > y3pos && carxpos[cxpos3] == xpos)
		{
		gameover = true;
		}

		score++; // increment the score

		if(speed > 140)
		{// if the speed is greater than 140 then reset the speed
			speed = 145;
		}else {
			speed++; // increment the speed
		}

		try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		if(y1pos < ypos && y1pos+175 > ypos && carxpos[cxpos1] == xpos)// (opponent car1 hit user end game)
		{
		gameover = true;
		}

		if(y2pos < ypos && y2pos+175 > ypos && carxpos[cxpos2] == xpos)// (opponent car2 hit user end game)
		{
		gameover = true;
		}

		if(y3pos < ypos  && y3pos+175 > ypos && carxpos[cxpos3] == xpos)// (opponent car3 hit user end game)
		{
		gameover = true;
		}

		if(gameover)
		{	
		//Game Over Menu
		g.setColor(new Color(14,216,182));
		g.fillRect(120, 210, 460, 200);	
		g.setColor(new Color(0,51,255));
		g.fillRect(130, 220, 440, 180);
		g.setFont(new Font("MV Boli",Font.BOLD,50));
		g.setColor(Color.red);
		g.drawString("Game Over",210, 270);
		g.setColor(Color.white);
		g.setFont(new Font("MV Boli",Font.BOLD,25));
		g.drawString("Press Enter to Restart", 210, 320);
		g.setColor(Color.white);
		g.setFont(new Font("MV Boli",Font.BOLD,20));
		g.drawString("Press R to Return Menu", 230, 350);
		//score 
		g.setColor(new Color(14,216,182));
		g.fillRect(250,35,220,50);
		g.setColor(Color.blue);
		g.fillRect(255,40, 210, 40);
		g.setColor(Color.white);
		g.setFont(new Font("MV Boli",Font.BOLD,30));
		g.drawString("Score : "+score, 265, 67);	
		if(!paint)
		{
			repaint();
			paint=true;
		}
		}

		else
		{
		repaint();
		}
	}

	@Override
	
	public void keyPressed(KeyEvent e) {   //(Car Algorithm)
		if(e.getKeyCode()==KeyEvent.VK_R && gameover)
		{	
			ScoreBoardAlgo scr_obb = new ScoreBoardAlgo();
			scr_obb.Read_and_Process();
			GUI a = new GUI("Highway Racer");
			a.Draw_Enterance(a);
			a.Draw_Play(a);
			a.Draw_ChooseCar(a);
			a.Draw_ScoreBoard(a);
			a.Draw_ChooseCar_Succesfull(a);
			a.Draw_NewHighScore(a);
			a.Draw_Score_Succesfull(a);
			a.Draw_Score_Not_Succesfull(a);
			a.showCard("enterance");
			
		}

		if(e.getKeyCode()==KeyEvent.VK_LEFT && !gameover)
		{ // if the left key is pressed then move the car to the left
			xpos -= 100;
			if(xpos < 100)
			{
				xpos = 100; // set the car to the left most position
			}
			
			
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT&&!gameover)
		{ 	// if the right key is pressed then move the car to the right
			xpos += 100;
			if(xpos > 500)
			{
				xpos = 500; // if the car is at the right most position then don't move it
			}
		}
			if(e.getKeyCode()==KeyEvent.VK_UP&&!gameover)
			{ 	// if the up key is pressed then open headlight xpos (Same) ypos (92 - 107)
				headlight.paintIcon(this,getGraphics(), xpos, ypos-185);
			}
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER && gameover)
		{ // if the game is over and the enter key is pressed then restart the game
			gameover = false;
			paint = false;
			cxpos1 = 0;
			cxpos2 = 2;
			cxpos3 = 4;
			cypos1 = random.nextInt(5); // randomize the position of the opponent cars
			cypos2 = random.nextInt(5);
			cypos3 = random.nextInt(5);
			y1pos = carypos[cypos1]; // set the position of the opponent cars
			y2pos = carypos[cypos2];
			y3pos = carypos[cypos3];
			speed = 90; // set the speed to 90
			score = 0; // set the score to 0
			delay = 70; // set the delay to 100
			xpos = 300; // set the position of the player car to the center
			ypos = 700;	 // set the position of the player car to the bottom
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override

	public void keyTyped(KeyEvent e) {
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {}

	public static void MAIN(){
			CarGame c = new CarGame("Highway Racer");
			c.setVisible(true);
			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}
