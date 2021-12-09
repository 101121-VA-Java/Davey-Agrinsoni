package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Fruityvice;
import com.revature.models.Spoonacular;

@SpringBootApplication
public class BlenderBuddiesBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlenderBuddiesBackEndApplication.class, args);
		String url = "https://www.fruityvice.com/api/fruit/";
		//String url1 ="https://api.spoonacular.com/food/ingredients/9003/information?amount=1&apiKey=e16c840ba6bc41799d1631c8121b5a4f";
		RestTemplate rt = new RestTemplate();
//		RestTemplate tr = new RestTemplate();

		Fruityvice f = rt.getForObject(url + "6", Fruityvice.class);
		//Spoonacular s = rt.getForObject(url1, Spoonacular.class);
		System.out.println(f);
		//System.out.println(s);
	}

}
