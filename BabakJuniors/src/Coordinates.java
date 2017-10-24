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
*
*/
public class Coordinates {

	
private int x;
private int y;
	
	public Coordinates(int x, int y) {
		this.x=x;
		this.y=y;
	}

	
	/**
	 * Method for Coordinates used to return the y coordinates
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Method for Coordinates used to set the y coordinates
	 * @return y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Method for Coordinates used to return the x coordinates
	 * @return y
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Method for Coordinates used to set the x coordinates
	 * @return y
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	

}