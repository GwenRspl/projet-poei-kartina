package com.ajc.kartina;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ajc.kartina.model.Address;
import com.ajc.kartina.model.User;
import com.ajc.kartina.repository.UserRepository;

@SpringBootTest
public class KartinaApplicationTests {

	@Autowired
	public UserRepository repo;

	@Test
	public void contextLoads() {
		assertTrue(true);
	}

	@Test
	public void testUserCreate() {
		Address address = new Address();
		address.setRue("rue");
		address.setCodePostal("75356");
		address.setVille("ville");
		address.setPays("France");

		User u = new User();
		u.setAdresse(address);
		u.setNom("nom");

		repo.save(u);
		assertTrue(true);

	}

}
