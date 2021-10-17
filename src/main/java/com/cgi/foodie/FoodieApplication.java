package com.cgi.foodie;

import com.cgi.foodie.dao.UserDao;
import com.cgi.foodie.model.Dish;
import com.cgi.foodie.model.Restaurant;
import com.cgi.foodie.model.User;
import com.cgi.foodie.model.UserAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Collections;

@SpringBootApplication
public class FoodieApplication implements CommandLineRunner {
	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(FoodieApplication.class, args);
	}

	// method will run right after application is started, used here to test database
	@Override
	public void run(String... args) throws Exception {
//		User user1 = new User("sahil.verma@gmail.com", "Sahil", "Verma", 8290111788L, "abc");
//
//		mongoTemplate.save(user1);
//
//		System.out.println("User found by email id & password");
//		Query q = new Query();
//		q.addCriteria(Criteria.where("emailId").is("sahil.verma@gmail.com"));
//		q.addCriteria(Criteria.where("password").is("abc"));
//		System.out.println(mongoTemplate.findOne(q, User.class));

//		UserAuth ua = new UserAuth("sahil.verma@gmail.com", "")

//		Dish d1 = new Dish("Cheese Pizza", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fitalianexpressonline.com%2Fwp-content%2Fuploads%2F2019%2F05%2Fcheese.jpg&f=1&nofb=1");
//		Dish d2 = new Dish("Veg Pizza", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn3.tmbi.com%2Fsecure%2FRMS%2Fattachments%2F37%2F1200x1200%2FGrilled-Veggie-Pizza_EXPS_LSBZ18_48960_D01_18_6b.jpg&f=1&nofb=1");
//
//		Dish[] dishes = {d1, d2};
//		Restaurant r1 = new Restaurant(5, "dine-in", "Pizza Hut", "bangalore", "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.retail4growth.com%2Fpublic%2Fuploads%2Feditor%2F2020-09-21%2F1600665663.jpg&f=1&nofb=1", dishes);
//		mongoTemplate.save(r1);
//
//		mongoTemplate.findAll(Restaurant.class).forEach(System.out::println);

//		Query q = new Query();
//		q.addCriteria(Criteria.where("city").is("bangalore"));
//		mongoTemplate.find(q, Restaurant.class).forEach(System.out::println);
	}
}
