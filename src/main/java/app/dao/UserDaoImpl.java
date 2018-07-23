package app.dao;

import app.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    /*private JdbcTemplate jdbcTemplate;
*/
   /* @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

   @Override
    public User addUser(User user) {

         sessionFactory.getCurrentSession()
                .save(user);
         return user;
    }

    @Override
    public User getByEmail(User user) {
        User u = sessionFactory.getCurrentSession()
                .createQuery("select u from User u join fetch u.roles r " +
                        "where u.email =: email", User.class)
                .setParameter("email", user.getEmail())
                .uniqueResult();
        return u;
    }

    /*@Override
    public User getByEmail(User user) {
        return this.jdbcTemplate.queryForObject(
                "SELECT ID, EMAIL, PASSWORD FROM USERS U WHERE U.EMAIL = ?",
                new Object[]{user.getEmail()},
                (resultSet, i) -> {
                    User u = new User();
                    u.setEmail(resultSet.getString("EMAIL"));
                    u.setPassword(resultSet.getString("PASSWORD"));
                    return u;
                }
        );
    }*/


}
