package ph.com.bpi.oop.SeatWork_M2_Activity5;

public abstract class Program {
	
	private String name;
	private boolean isRunning = false;
	
	public Program() {
		
	}
	
	public Program(String name) {
		this.name = name;
	}
	
	abstract void run();
	abstract void stop();
   
   public boolean getIsRunning() {
	   return isRunning;
   }
   public String getName() {
	   return name;
   }
   public void setIsRunning(boolean isRunning) {
	   this.isRunning = isRunning;
   }
   public void setName(String name) {
	   this.name = name;
   }
	
	
	
}
