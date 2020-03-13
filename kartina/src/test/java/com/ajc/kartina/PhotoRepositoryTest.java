package com.ajc.kartina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ajc.kartina.model.Photo;
import com.ajc.kartina.repository.PhotoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhotoRepositoryTest {

	@Autowired
	private PhotoRepository repo;

	@Test
	public void testPhotoFindByTheme() {

		List<Photo> list = repo.findByThemeId(1);
		assertEquals(1, list.get(0)
							.getId());

	}

	@Test
	public void testPhotoFindByArtist() {

		List<Photo> list = repo.findByArtisteId(1);
		assertEquals(1, list.get(0)
							.getId());

	}

	@Test
	public void testPhotoFindFewStock() {

		List<Photo> list = repo.findTop5ByOrderByTirages();
		assertEquals(6, list.get(0)
							.getId());
		assertEquals(5, list.size());

	}

}
