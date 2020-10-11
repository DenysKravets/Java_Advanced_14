package ua.lviv.lgs.application;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ua.lviv.lgs.model.Cart;
import ua.lviv.lgs.model.Item;

public class Application {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.getTransaction().begin();;
		
		Item item1 = new Item();
		item1.setTotal(19.0);
		Item item2 = new Item();
		item2.setTotal(23.0);
		Item item3 = new Item();
		item3.setTotal(56.0);
		Item item4 = new Item();
		item4.setTotal(6.0);
		
		Set<Item> items = new HashSet<>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		
		Cart cart = new Cart();
		cart.setName("cart1");
		cart.setTotal(120.0);
		cart.setItems(items);
		
		session.persist(cart);
		
		session.getTransaction().commit();
		

	}
}
