package com.siggebig.GroupTransport.controller;

import com.siggebig.GroupTransport.model.Group;
import com.siggebig.GroupTransport.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

/*
    @GetMapping("group")
    public List<Group> getAllGroups() {
        return groupService.getAll();
    } */

    @GetMapping("group")
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAll();

        if (groups.isEmpty()) {
            return ResponseEntity
                    .status(204)
                    .header("x-info", "No data found in db")
                    .build();
        } else {
            return ResponseEntity.ok(groups);
        }
    }

    @PostMapping("group")
    public ResponseEntity<List<Group>> createGroup(@RequestBody Group group) {
        groupService.save(group);

        List<Group> groups = groupService.getAll();
        return ResponseEntity.status(201).body(groups);
    }



    @DeleteMapping("channel/{groupId}")
    public ResponseEntity<List<Group>> deleteGroup(@PathVariable long groupId) {

        List<Group> groups = groupService.getAll();

        if (groupId > groups.size()) {
            return ResponseEntity
                    .status(400)
                    .header("x-error-msg", "Id out of bounds, no group with that id")
                    .build();
        } else {

            groupService.delete(groupId);
            return (ResponseEntity<List<Group>>) getAllGroups();
        }
    }


}
