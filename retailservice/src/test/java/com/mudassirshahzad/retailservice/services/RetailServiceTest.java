/**
 * 
 */
package com.mudassirshahzad.retailservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mudassirshahzad.retailservice.entities.Item;
import com.mudassirshahzad.retailservice.entities.ItemType;
import com.mudassirshahzad.retailservice.entities.User;
import com.mudassirshahzad.retailservice.entities.UserType;
import com.mudassirshahzad.retailservice.services.RetailService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

/**
 * @author Mudassir Shahzad Dec 27, 2019
 */
@WebMvcTest(RetailService.class)
public class RetailServiceTest {

	@Autowired
	private RetailService service;

	@BeforeEach
	public void setup() {

	}

	@Test
	public void testEmployeeDiscount() {

		double total = service.getUserDiscount(200d, 30f);
		assertEquals(60L, total);
	}

	@Test
	public void testCalculateTotal_NoGroceries_Employee() {

		User user = User.builder().userType(UserType.EMPLOYEE).build();
		Item item1 = Item.builder().name("Cup").price(50).type(ItemType.KITCHEN_ITEMS).build();
		Item item2 = Item.builder().name("Cup").price(50).type(ItemType.KITCHEN_ITEMS).build();
		Item item3 = Item.builder().name("Fruits").price(50).type(ItemType.GROCERY).build();
		Item item4 = Item.builder().name("Fruits").price(50).type(ItemType.GROCERY).build();
		List<Item> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		double total = service.calculateTotal(user, items);
		assertEquals(160L, total);

	}

	@Test
	public void testCalculateTotal_NoGroceries_Affiliate() {

		User user = User.builder().userType(UserType.AFFILIATE).build();
		Item item1 = Item.builder().name("Cup").price(100).type(ItemType.KITCHEN_ITEMS).build();
		Item item2 = Item.builder().name("Cup").price(100).type(ItemType.KITCHEN_ITEMS).build();
		Item item3 = Item.builder().name("Fruits").price(100).type(ItemType.GROCERY).build();
		Item item4 = Item.builder().name("Fruits").price(100).type(ItemType.GROCERY).build();
		List<Item> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		double total = service.calculateTotal(user, items);
		assertEquals(360L, total);

	}

	@Test
	public void testCalculateTotal_NoGroceries_RegularCustomer() {

		User user = User.builder().userType(UserType.REGULAR_CUSTOMER).build();
		Item item1 = Item.builder().name("Cup").price(50).type(ItemType.KITCHEN_ITEMS).build();
		Item item2 = Item.builder().name("Cup").price(50).type(ItemType.KITCHEN_ITEMS).build();
		Item item3 = Item.builder().name("Cup").price(100).type(ItemType.KITCHEN_ITEMS).build();
		Item item4 = Item.builder().name("Cup").price(100).type(ItemType.KITCHEN_ITEMS).build();
		Item item5 = Item.builder().name("Fruits").price(100).type(ItemType.GROCERY).build();
		Item item6 = Item.builder().name("Fruits").price(100).type(ItemType.GROCERY).build();
		List<Item> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		double total = service.calculateTotal(user, items);
		assertEquals(460L, total);

	}

	@Test
	public void testCalculateTotal_NoGroceries_NewCustomer() {

		User user = User.builder().userType(UserType.NEW_CUSTOMER).build();
		Item item1 = Item.builder().name("Cup").price(100).type(ItemType.KITCHEN_ITEMS).build();
		Item item2 = Item.builder().name("Cup").price(100).type(ItemType.KITCHEN_ITEMS).build();
		Item item3 = Item.builder().name("Fruits").price(90).type(ItemType.GROCERY).build();
		List<Item> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		double total = service.calculateTotal(user, items);
		assertEquals(280L, total);

	}

}
