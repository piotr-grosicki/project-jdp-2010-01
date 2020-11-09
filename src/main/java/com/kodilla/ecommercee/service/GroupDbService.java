package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupDbService {
    @Autowired
    private GroupDao groupDao;

    public List<Group> getGroups() {
        return groupDao.findAll();
    }

    public Group getGroup(Long groupId) {
        return groupDao.findById(groupId).orElse(null);
    }

    public Group saveGroup(Group group) {
        return groupDao.save(group);
    }

    public void deleteGroup(Long groupId) {
        groupDao.deleteById(groupId);
    }
}