package com.blog.jpa.restaurant;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tutorialspoint.eclipselink.entity.Menu;


public class PopulateTable {
	
	
	public static void main(String[] args) {
		
		
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			entitymanager.getTransaction().begin();
			String[][] values = {{"Egusi Soup and Eba", "24.5"}, { "Porridge Yam", "12"}, {"Porridge Beans", "13"}};
			for (int i = 0; i < values.length; i++) {
				
					String[] row = values[i];
					String dishName = row[0];
					String dishPrice = row[1];
					float floatDishPrice = Float.parseFloat(dishPrice);
					Menu menu = new Menu();
					menu.setName(dishName);
					menu.setDishPrice(floatDishPrice);
					
					entitymanager.persist(menu);
					
					
			}
			entitymanager.getTransaction().commit();
			entitymanager.close();
			entitymanagerfactory.close();
			
	}
}
