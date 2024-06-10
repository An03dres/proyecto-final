package com.example.demo;

import com.example.demo.model.Artist;
import com.example.demo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TattooApplication {

	@Autowired
	private ArtistRepository artistRepository;

	public static void main(String[] args) {
		SpringApplication.run(TattooApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase() {
		return args -> {
			artistRepository.deleteAll();
			artistRepository.save(new Artist("Artist 1", "Artist 1 bio", "https://randomuser.me/api/portraits/men/63.jpg"));
			artistRepository.save(new Artist("Artist 2", "Artist 2 bio", "https://randomuser.me/api/portraits/men/2.jpg"));
			artistRepository.save(new Artist("Artist 3", "Artist 3 bio", "https://randomuser.me/api/portraits/men/8.jpg"));
			artistRepository.save(new Artist("Artist 4", "Artist 4 bio", "https://randomuser.me/api/portraits/men/98.jpg"));
			artistRepository.save(new Artist("Artist 5", "Artist 5 bio", "https://randomuser.me/api/portraits/men/32.jpg"));
			artistRepository.save(new Artist("Artist 6", "Artist 6 bio", "https://randomuser.me/api/portraits/men/6.jpg"));
		};
	}
}
