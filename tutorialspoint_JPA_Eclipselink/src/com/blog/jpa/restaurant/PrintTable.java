package com.blog.jpa.restaurant;

import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tutorialspoint.eclipselink.entity.Menu;

public class PrintTable {
	public static void main(String[] args) {
		
		
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		Query query = entitymanager.createQuery("SELECT e FROM Menu e");
		Collection<Menu> menus =   query.getResultList();
		Iterator<Menu> iterator = menus.iterator();
		while(iterator.hasNext()) {
			
				String row = iterator.next().printRow();
				System.out.println(row);
				
		}
		
	
}
}
