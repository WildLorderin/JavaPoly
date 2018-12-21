
import java.util.List;

import de.scholzf.javapoly.entitiy.House;
import de.scholzf.javapoly.entitiy.Player;
import de.scholzf.javapoly.entitiy.base.EntityFigure;
import de.scholzf.javapoly.entitiy.base.Purchaseable;

public class main {

	public static void main(String[] args) {
		
		Player player = new Player("Flo", 1500, EntityFigure.PLANE);
		House house = new House("Home", 1300, player);
	
		player.purchaseItem(house);

		List<Purchaseable> list = player.getItems();
		
		for(Purchaseable p : list) {
			System.out.println(p.getName());
			System.out.println(p.getValue());
			System.out.println(p.getOwner().getName());
		}
		
	} 
	
}
