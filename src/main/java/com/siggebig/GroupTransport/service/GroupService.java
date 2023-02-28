package com.siggebig.GroupTransport.service;

import com.siggebig.GroupTransport.model.Group;
import com.siggebig.GroupTransport.repo.JpaGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private JpaGroupRepository jpaGroupRepository;

    public List<Group> getAll() {
        return jpaGroupRepository.findAll();
    }

    public Group save(Group group) {
        return jpaGroupRepository.save(group);
    }

    public void delete(long groupId) {
        jpaGroupRepository.deleteById(groupId);
    }


}
