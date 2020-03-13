package com.ajc.kartina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ajc.kartina.model.Address;
import com.ajc.kartina.model.User;
import com.ajc.kartina.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	public UserRepository repo;

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

		User a = repo.save(u);
		assertEquals(u.getNom(), a.getNom());

	}

}
