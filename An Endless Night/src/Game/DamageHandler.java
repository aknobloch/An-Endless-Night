package Game;

public class DamageHandler {

	private Hero gameHero;
	private Monster battleMonster;
	private Room battleRoom;
	
	public DamageHandler() {
		
		gameHero = Game.getHero();
		battleRoom = gameHero.getRoom();
		battleMonster = battleRoom.getMonster();
		
	}
	
	public int attackHero() {
		
		int damage = battleMonster.getStrength() - gameHero.getDefense();
		int remainingHealth = gameHero.attack(damage);
		
		if(remainingHealth <= 0) {
			// TODO: Handle case if hero dies
			return -1;
		}
		else {
			return remainingHealth;
		}
		
	}
	
	public int attackMonster() {
		
		int damage = gameHero.getStrength() + gameHero.getEquippedWeapon().getStrength();
		int remainingHealth = battleMonster.attack(damage);
		
		if(remainingHealth <= 0) {
			// TODO: Handle case if monster dies
			return -1;
		}
		else {
			return remainingHealth;
		}
		
	}
	
}
