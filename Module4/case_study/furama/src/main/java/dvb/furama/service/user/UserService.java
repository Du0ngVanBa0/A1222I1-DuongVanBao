package dvb.furama.service.user;

import dvb.furama.entity.user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
