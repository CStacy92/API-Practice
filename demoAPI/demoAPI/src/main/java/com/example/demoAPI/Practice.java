package com.example.demoAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Practice {
	@GetMapping("/addition/{num1}/{num2}")
	public String addition(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
		String s = String.format("%o + %o = ", num1, num2);
		return  s + (num1+num2);
	}
	
	@GetMapping("/subtraction/{num1}/{num2}")
	public String subtraction(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
		String s = String.format(" %o - %o = ", num1, num2);
		return s + (num1-num2);
	}
	
	@GetMapping("/names")
	public ArrayList<String> namesList(){
		ArrayList<String> names = new ArrayList<String>(List.of("Cpt. Malcolm Reynolds","Wash","Kaylee","Inara","Jayne","Zoe"));
		return names;
	}

}
