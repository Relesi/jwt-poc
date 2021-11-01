package com.relesi.jwt.services;import com.relesi.jwt.domain.User;import com.relesi.jwt.dto.UserDTO;import com.relesi.jwt.repository.UserRepository;import com.relesi.jwt.services.exception.ObjectNotFoundException;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import java.util.List;import java.util.Optional;@Servicepublic class UserService {    private static Logger log = LoggerFactory.getLogger(UserService.class);    @Autowired    private UserRepository repo;    public List<User> findAll() {        return repo.findAll();    }    public User findById(String id) {        Optional<User> obj = repo.findById(id);        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));      /*  if (user == null) {            throw new ObjectNotFoundException("Objeto não encontrado");        }*/    }    public void delete(String id) {        findById(id);        repo.deleteById(id);    }    public User insert(User obj) {        return repo.insert(obj);    }    public User update(User obj) {        User newObj = findById(obj.getId());        updateData(newObj, obj);        return repo.save(newObj);    }    private void updateData(User newObj, User obj) {        newObj.setName(obj.getName());        newObj.setEmail(obj.getEmail());    }    public User fromDTO(UserDTO objDTO) {        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());    }    public User findByEmail(String email) {        Optional<User> obj = Optional.ofNullable(repo.findByEmail(email));        log.info("Searching user for EMAIL: {}", email);        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));    }}