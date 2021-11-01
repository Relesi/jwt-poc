package com.relesi.jwt.config;import com.relesi.jwt.domain.Admin;import com.relesi.jwt.domain.User;import com.relesi.jwt.dto.AuthorDTO;import com.relesi.jwt.dto.CommentDTO;import com.relesi.jwt.repository.AdminRepository;import com.relesi.jwt.repository.UserRepository;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.CommandLineRunner;import org.springframework.context.annotation.Configuration;import java.text.SimpleDateFormat;import java.util.Arrays;import java.util.TimeZone;@Configurationpublic class Instantiation implements CommandLineRunner {    @Autowired    private UserRepository userRepository;    @Autowired    private AdminRepository adminRepository;    @Override    public void run(String... args) throws Exception {        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));        userRepository.deleteAll();        adminRepository.deleteAll();        User maria = new User(null, "Maria Brown", "maria@gmail.com");        User alex = new User(null, "Alex Green", "alex@gmail.com");        User bob = new User(null, "Bob Grey", "bob@gmail.com");        userRepository.saveAll(Arrays.asList(maria, alex, bob));        Admin post1 = new Admin(null, sdf.parse("31/10/2021"), "Viajem Confirmada", "Sentido New York", new AuthorDTO(maria)) ;        Admin post2 = new Admin(null, sdf.parse("31/10/2021"), "Bom dia", "Sentido Los Angeles!", new AuthorDTO(maria)) ;        CommentDTO c1 = new CommentDTO("Compania Air Lines", sdf.parse("31/10/2021"), new AuthorDTO(alex));        CommentDTO c2 = new CommentDTO("Compania Varig", sdf.parse("31/10/2021"), new AuthorDTO(bob));        CommentDTO c3 = new CommentDTO("Compania Vasp!", sdf.parse("31/10/2021"), new AuthorDTO(alex));        post1.getComments().addAll(Arrays.asList(c1, c2));        post2.getComments().addAll(Arrays.asList(c3));        adminRepository.saveAll(Arrays.asList(post1, post2));        maria.getAdmin().addAll(Arrays.asList(post1, post2));        userRepository.save(maria);    }}