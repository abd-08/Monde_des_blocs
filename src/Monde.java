
public class Monde {
	Table table ; 
	Robot robot;
	
	public Table getTable() {
		return table;
	}
	
	public void setTable(Table table) {
		this.table = table;
	}
	
	
	public Robot getRobot() {
		return robot;
	}
	
	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	
	public Monde(Table table,  Robot robot) {
		super();
		this.table = table; 
		this.robot = robot;
	}
	
	
	public Monde() {
		super();
		this.table = new Table(); 
		this.robot = new Robot();
	}
	
	
	

}
