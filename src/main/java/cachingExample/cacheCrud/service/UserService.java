package cachingExample.cacheCrud.service;

import cachingExample.cacheCrud.models.User;
import cachingExample.cacheCrud.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Caching
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a user
    @CacheEvict(value = "users", allEntries = true)
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    // This method updates the cache with the new user data
    @CachePut(value = "users", key = "#user.id")
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    // Get a list of users
    @Cacheable("users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by id
    // This method caches the result, so if the same user ID is requested, it will return the cached result
    @Cacheable(value = "users", key = "#id")
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Delete a user
    @CacheEvict(value = "users", key = "#id",allEntries = true)
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
