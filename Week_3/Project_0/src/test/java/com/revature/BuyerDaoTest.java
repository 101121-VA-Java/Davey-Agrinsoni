package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.UserNotFoundException;
import com.revature.exceptions.UsernameAlreadyInUseException;
import com.revature.models.Buyer;
import com.revature.repositories.BuyerDao;
import com.revature.repositories.BuyerList;
import com.revature.services.BuyerService;

public class BuyerDaoTest {
	
	private BuyerDao bd = new BuyerList();
	private BuyerService bs = new BuyerService();
	
	@BeforeEach
	public void setUp() {
		bd = new BuyerList();
		bs = new BuyerService();
	}
	
	@Order(1)
	@Test
	public void getAll() {
		List<Buyer> expected = new ArrayList<>();
		assertEquals(expected, bd.getAll());
	}
	
	@Order(2)
	@Test
	public void addBuyer() {
		List<Buyer> expected = new ArrayList<>();
		expected.add(new Buyer("Agrin", "Pass", "Davey"));
		bd.add(new Buyer("Agrin", "Pass", "Davey"));
		assertEquals(expected, bd.getAll());
	}
	
	@Order(3)
	@Test
	public void getByUsername() {
		List<Buyer> expected = new ArrayList<>();
		expected.add(new Buyer("Agrin", "Pass", "Davey"));
		expected.add(new Buyer("VentHero", "Pass", "Ddre"));
		bd.add(new Buyer("Agrin", "Pass", "Davey"));
		bd.add(new Buyer("VentHero", "Pass", "Ddre"));
		assertEquals(expected.get(0), bd.getByUsername("Agrin"));
	}
	
	@Order(4)
	@Test
	public void getByUsernameNull() {
		bd.add(new Buyer("Agrin", "Pass", "Davey"));
		assertEquals(null, bd.getByUsername("Crank"));
	}
	
	@Order(5)
	@Test
	public void removeBuyer() {
		List<Buyer> expected = new ArrayList<>();
		expected.add(new Buyer("Agrin", "Pass", "Davey"));
		Buyer temp = new Buyer("VentHero", "Pass", "Ddre");
		bd.add(new Buyer("Agrin", "Pass", "Davey"));
		bd.add(new Buyer("VentHero", "Pass", "Ddre"));
		bd.remove(temp);
		assertEquals(expected, bd.getAll());
	}
	
	@Order(6)
	@Test
	public void removeNullBuyer() {
		List<Buyer> expected = new ArrayList<>();
		expected.add(new Buyer("Agrin", "Pass", "Davey"));
		Buyer temp = new Buyer("VentHero", "Pass", "Ddre");
		bd.add(new Buyer("Agrin", "Pass", "Davey"));
		assertFalse(bd.remove(temp));
	}
	
	@Order(7)
	@Test
	public void serviceAddBuyer() throws UsernameAlreadyInUseException {
		List<Buyer> expected = new ArrayList<>();
		expected.add(new Buyer("Agrin", "Pass", "Davey"));
		bs.addBuyer(new Buyer("Agrin", "Pass", "Davey"));
		assertEquals(expected, bd.getAll());
	}
	
//	@Order(8)
//	@Test
//	public void existingUsername() throws UsernameAlreadyInUseException{
//		bs.addBuyer(new Buyer("Agrin", "Pass", "Davey"));
//		assertThrows(UsernameAlreadyInUseException.class, bs.addBuyer(new Buyer("Agrin", "Pass", "Davey")));
//	}
//	
//	@Order(9)
//	@Test
//	public void serviceRemoveBuyer() {
//		List<Buyer> expected = new ArrayList<>();
//		expected.add(new Buyer("Agrin", "Pass", "Davey"));
//		expected.add(new Buyer("VentHero", "Pass", "Ddre"));
//		Buyer temp = new Buyer("Agrin", "Pass", "Davey");
//		//bs.addBuyer(new Buyer("Agrin", "Pass", "Davey"));
//		try {
//			bs.addBuyer(new Buyer("Agrin", "Pass", "Davey"));
//			bs.addBuyer(new Buyer("VentHero", "Pass", "Ddre"));
//		} catch (UsernameAlreadyInUseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		bs.removeBuyer(temp);
//		assertEquals(expected, bd.getAll());
//	}
	
	@Order(10)
	@Test
	public void serviceLogin() throws UserNotFoundException, UsernameAlreadyInUseException {
		List<Buyer> expected = new ArrayList<>();
		expected.add(new Buyer("Agrin", "Pass", "Davey"));
		bs.addBuyer(new Buyer("Agrin", "Pass", "Davey"));
		assertEquals(expected.get(0), bs.login("Agrin", "Pass"));
	}
	
}
