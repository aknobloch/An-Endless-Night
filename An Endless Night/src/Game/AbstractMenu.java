package Game;

public abstract class AbstractMenu {
	
	public AbstractMenu() {
		
		this.onLoad();
		
	}
	
	abstract void onLoad();
	
	abstract void onDestroy();
	
	public final void exitMenu() {
		
		this.onDestroy();
		
	}
	
}
