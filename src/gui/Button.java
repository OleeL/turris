/**
 * @author Team 62
 * 
 * Oliver Legg - sgolegg - 201244658
 * Thomas Coupe - sgtcoupe - 201241037
 *
 */

package gui;

import engine.io.Audio;
import main.Main;

public class Button {
	private String name;
	private float x, y, width, height;
	private int state;
	private float r = 0f;
	private float g = 0f;
	private float b = 0f;
	private int corner_radius = 9;
	private final static float BOX_ALPHA = 0.5f;
	private final static float FONT_ALPHA = 1f;
	public Text text;
	private float font_r = 1f;
	private float font_g = 1f;
	private float font_b = 1f;
	private boolean roundedEdges = true;
	private float[] hover_colour = {0.4f, 0.4f, 0.4f, BOX_ALPHA};
	private boolean hover;
	
	public Button(String name, float x, float y, float width, float height, int state)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.state = state;
		this.name = name;
		
		hover = false;
		
		// Creates text to go on the button
		text = new Text(name, x, y, 16);
		
		this.setPosition((int)x,(int)y);
	}
	
	// Returns the number put into the button on creation
	// The number corresponds to the action that you want carried out next
	public int getState()
	{
		return state;
	}
	
	// Gets the text on the button
	public Text getText()
	{
		return text;
	}
	
	// Sets the button colour
	public void setButtonColour(float r, float g, float b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	// Sets the fonts colour
	public void setFontColour(float r, float g, float b)
	{
		this.font_r = r;
		this.font_g = g;
		this.font_b = b;
	}
	
	// Sets the position of the button
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
		
		text.setPosition(x + (width / 2) - (text.getFont().getTextWidth(name) / 2), y + (height / 2) - (text.getFont().getCharHeight() / 2));
	}
	
	//Sets the position of the button with option for text alignment
	public void setPosition(int x, int y, int align) {
		setPosition(x,y);
		switch(align) {
		case 1:
			text.setPosition(x, text.y);
			break;
		case 2:
			text.setPosition(text.x + (width / 2) - (text.getFont().getTextWidth(name) / 2), text.y);
		}
	}
	
	// Checks if the button is pressed (update this every frame)
	public boolean updateClick()
	{
		if (Main.window.getMouseX() > x &&
				Main.window.getMouseX() < x+width &&
				Main.window.getMouseY() > y &&
				Main.window.getMouseY() < y+height)
		{
			hover = true;
			
			if (Main.window.isMousePressed(Main.window.LEFT_MOUSE)){
				Audio.play(Audio.SND_MENU_CLICK);
				return true;

			}
		}
		else
		{
			hover = false;
		}

		return false;
	}
	
	// draws the button (update this every frame in the draw function)
	public void draw()
	{
		if (!hover)
			Main.window.setColour(r, g, b, BOX_ALPHA);
		else {
			Main.window.setColour(hover_colour[0], hover_colour[1], 
					hover_colour[2], hover_colour[3]);
		}
		if (roundedEdges)
			Main.window.rectangle(x, y, width, height, corner_radius);
		else
			Main.window.rectangle(x, y, width, height);
		Main.window.setColour(font_r, font_g, font_b, FONT_ALPHA);
		text.draw();
	}

	public void setRoundedEdges(boolean roundedEdges) {
		this.roundedEdges = roundedEdges;
	}

	// Gets the name of the button
	public String getName() {
		return name;
	}
	
	public float[] getColour() {
		return new float[] {r, g, b, BOX_ALPHA};
	}
	
	public void setHoverColour(float r, float g, float b, float a) {
		this.hover_colour[0] = r;
		this.hover_colour[1] = g;
		this.hover_colour[2] = b;
		this.hover_colour[3] = a;
	}
	

	// Sets the name of the button.
	public void setName(String name) {
		this.name = name;
		text.text = name;
		setPosition((int)x,(int)y);
	}
	// returns button width
	public float getWidth() {
		return width;
	}
	//returns button height
	public float getHeight() {
		return height;
	}
	
	// Returns the x coordinate
	public float getX() {
		return x;
	}
	
	// Returns the y coordinate
	public float getY() {
		return y;
	}
	
	public boolean getHover() {
		return hover;
	}
	
}
