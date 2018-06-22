package com.javalogbook.spring.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javalogbook.spring.boot.model.Item;
import com.javalogbook.spring.boot.services.ItemService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping(value = "/api/v1/inventory/")
@CrossOrigin(allowedHeaders = "*", allowCredentials = "true", origins = "*")
public class ItemController {

	@Autowired
	ItemService itemService;

	JSONObject response;

	@RequestMapping(value = "items", method = RequestMethod.GET)
	public ResponseEntity<Object> getItems() {
		response = new JSONObject();
		List<Item> items = itemService.getItems();
		response.put("items", items);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@PostMapping(value = "items")
	public ResponseEntity<Object> createItem(@RequestBody Item item) {
		itemService.addItems(item);
		response = new JSONObject();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
