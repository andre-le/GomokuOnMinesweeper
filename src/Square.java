import javax.swing.JPanel;

public class Square extends JPanel {
	private int i; //column element of the square
	private int j; //row element of the square
	
	//indicate whether there is mine there or hint number
	//if there is mine, the integer is -1
	private int sign;
	
	public Square(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}
	
	public String toString(){
		return i + " " + j;
	}
	
}
