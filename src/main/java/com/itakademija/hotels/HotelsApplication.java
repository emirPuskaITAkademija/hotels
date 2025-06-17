package com.itakademija.hotels;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HotelsApplication.class, args);
    }

//	@Autowired
//	private UserRepository userRepository;
//
//    @Autowired
//    private PrivilegeRepository privilegeRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private RoomRepository roomRepository;

	@Override
	public void run(String... args) throws Exception {
//        Privilege firstPrivilege = privilegeRepository.findAll().getFirst();
//        User user = new User();
//        user.setName("John");
//        user.setSurname("Travolta");
//        user.setPassword(passwordEncoder.encode("1234"));
//        user.setUsername("john");
//        user.setPrivilege(firstPrivilege);
//        userRepository.save(user);
//		List<User> allUsers = userRepository.findAll();
//		allUsers.forEach(System.out::println);
//
//        List<Room> rooms = roomRepository.findAll();
//        rooms.forEach(System.out::println);
	}
}
