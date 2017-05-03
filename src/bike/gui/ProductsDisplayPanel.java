package bike.gui;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import bike.customerRecords.Customer;
import bike.inventory.Inventory;

public class ProductsDisplayPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public ProductsDisplayPanel() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void addProductsFromInventory(Inventory inventory, Customer customer, Frame frame) {
		inventory.getProducts().keySet().forEach(product -> {
			add(new ProductShoppingPanel(product, customer, frame));
	    	add(Box.createRigidArea(new Dimension(0, 80)));
	    });
	}
	
	public void addProductsFromCart(Customer customer, Inventory inventory) {
		customer.getCart()
				.getOrders()
				.forEach(order -> add(new ProductCartPanel(customer, order, inventory)));
	}
}
