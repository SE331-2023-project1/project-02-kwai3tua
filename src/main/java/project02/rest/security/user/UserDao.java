package project02.rest.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);

    //    User findById(Integer id);
    User getUser(Long id);
}