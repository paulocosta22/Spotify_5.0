package com.spotify.spotify_5;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class UserService {

    @PersistenceContext(unitName = "MainUnit")
    private EntityManager entityManager;

    public User findUser(Long id) {return entityManager.find(User.class, id); }

    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT c FROM User c", User.class).getResultList();
    }

    public User insertUser(User user){
        entityManager.persist(user);

        return user;
    }

    public User updateUser(Long id, String firstName, String lastName) {
        User userToUpdate = findUser(id);
        userToUpdate.setFirstName(firstName);
        userToUpdate.setLastName(lastName);
        entityManager.merge(userToUpdate);

        return userToUpdate;
    }

    public User deleteUser(Long id) {
        User user = findUser(id);
        entityManager.remove(user);

        return user;
    }

}
