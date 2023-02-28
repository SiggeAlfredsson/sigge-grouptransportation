package com.siggebig.GroupTransport.repo;

import com.siggebig.GroupTransport.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaGroupRepository extends JpaRepository<Group, Long> {
}
