package com.example.demo;

import com.example.demo.model.Artist;
import com.example.demo.model.User;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TattooApplication {

	@Autowired
	private ArtistRepository artistRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TattooApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase() {
		return args -> {
			artistRepository.deleteAll();
			artistRepository.save(
					new Artist(
							"Carlos Santana",
							" Carlos santana is a skilled tattoo artist specializing in traditional style. Known for bold lines and vibrant colors, he works at tattoShop, earning admiration for his dedication and artistry. He also participates in tattoo conventions, continually refining his craft.",
							"https://randomuser.me/api/portraits/men/63.jpg"
					));
			artistRepository.save(
					new Artist(
							"Albert Ruiz",
							"Albert Ruiz is a talented tattoo artist specializing in blackout style. Known for his mastery of bold, solid designs, he works at TattooShop, where he showcases his dedication and creativity. Constantly pushing the boundaries of blackout artistry.",
							"https://randomuser.me/api/portraits/men/2.jpg"
					));
			artistRepository.save(
					new Artist(
							"Juan Cruz",
							"Juan Cruz is a skilled tattoo artist specializing in watercolor style. Known for his vibrant colors and fluid designs, he works at TattooShop, where he showcases his dedication and creativity. Constantly pushing the boundaries of watercolor artistry.",
							"https://randomuser.me/api/portraits/men/8.jpg"
					));
			artistRepository.save(
					new Artist(
							"Maria Garcia",
							"Maria Garcia is a talented tattoo artist specializing in realism style. Known for her intricate details and lifelike designs, she works at TattooShop, where she showcases her dedication and creativity. Constantly pushing the boundaries of realism artistry.",
							"https://randomuser.me/api/portraits/women/10.jpg"
					));
			artistRepository.save(
					new Artist(
							"Lucia Fernandez",
							"Lucia Fernandez is a skilled tattoo artist specializing in geometric style. Known for her precise lines and intricate patterns, she works at TattooShop, where she showcases her dedication and creativity. Constantly pushing the boundaries of geometric artistry.",
							"https://randomuser.me/api/portraits/women/12.jpg"
					));
			artistRepository.save(
					new Artist(
							"Javier Lopez",
							"Javier Lopez is a talented tattoo artist specializing in Japanese style. Known for his bold designs and rich symbolism, he works at TattooShop, where he showcases his dedication and creativity. Constantly pushing the boundaries of Japanese artistry.",
							"https://randomuser.me/api/portraits/women/14.jpg"
					));

			userRepository.deleteAll();
		};
	}

}
