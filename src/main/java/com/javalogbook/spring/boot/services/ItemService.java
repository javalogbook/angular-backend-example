package com.javalogbook.spring.boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalogbook.spring.boot.model.Item;
import com.javalogbook.spring.boot.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public List<Item> getItems() {
		return itemRepository.getItems();
	}

	public void addItems(Item item) {
		itemRepository.addItem(item);

	}

}
