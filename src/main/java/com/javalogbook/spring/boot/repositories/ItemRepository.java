package com.javalogbook.spring.boot.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javalogbook.spring.boot.model.Item;

@Repository
public class ItemRepository {
	List<Item> items = new ArrayList<>();

	public ItemRepository() {
		this.items = this.getItemList();
	}

	public List<Item> getItemList() {
		for (int i = 0; i < 5; i++) {
			Item item = new Item();
			item.setBrandName("Brand Name " + (i + 1));
			item.setItemName("Item Name " + (i + 1));
			item.setItemPrice((i + 1) + 25.5);
			items.add(item);
		}
		return items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		this.items.add(item);

	}

}
