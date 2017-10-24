/**
*Coordinates
*
*@Authors: Ahmed Khattab
*@Purpose: Determine the coordinates of a house given its x and y positions.
*
*@field variables
*	x: The x coordinate
*	y: The y coordinate
*	
*@methods
*	getY
*	getX
*	setY
*	setX
*	getNormalizedValue
*
*/
public class Coordinates implements HouseAttributes {

	
private int x;
private int y;
	
	public Coordinates(int x, int y) {
		this.x=x;
		this.y=y;
	}

	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
	public float getNormalizedValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}