package com.siggebig.GroupTransport.service;

import com.siggebig.GroupTransport.Exception.GroupNotFoundException;
import com.siggebig.GroupTransport.Exception.UserNotFoundException;
import com.siggebig.GroupTransport.model.Group;
import com.siggebig.GroupTransport.model.User.UserRegistration;
import com.siggebig.GroupTransport.model.User.User;
import com.siggebig.GroupTransport.repo.JpaUserRegistrationRepository;
import com.siggebig.GroupTransport.repo.JpaGroupRepository;
import com.siggebig.GroupTransport.repo.JpaUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Autowired
    private JpaGroupRepository jpaGroupRepository;

    @Autowired
    JpaUserRegistrationRepository jpaUserRegistrationRepository;

    public List<User> getAll() {
        return jpaUserRepository.findAll();
    }

    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    public void delete(long userId) {
        jpaUserRepository.deleteById(userId);
    }


    @Transactional
    public void addUserToGroup(Long userId, Long groupId) {
        User user = jpaUserRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Group group = jpaGroupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException(groupId));

        UserRegistration reg = new UserRegistration();

        reg.setUser(user);
        reg.setGroup(group);
        reg.setAddedToGroupAt(LocalDateTime.now());

        user.getRegistrations().add(reg);
        group.getRegistrations().add(reg);

        jpaUserRepository.save(user);
        jpaGroupRepository.save(group);
        jpaUserRegistrationRepository.save(reg);
    }

}
