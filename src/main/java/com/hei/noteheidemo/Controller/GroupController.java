package com.hei.noteheidemo.Controller;

import com.hei.noteheidemo.Entity.Group;
import com.hei.noteheidemo.Service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class GroupController {
    private GroupService groupService ;
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    @PostMapping("/group-create")
    public ResponseEntity<String> createGroup(@RequestBody Group group) {
            groupService.createGroup(group);
            return ResponseEntity.status(HttpStatus.CREATED).body("Group created successfully");

    }

    @GetMapping("/group")
    public List<Group> getAllGroups() {
        return groupService.getAllGroups() ;
    }

    @GetMapping("/group/{id}")
    public Optional<Group> getGroupByID(@PathVariable int id){
        return groupService.getGroupById(id) ;
    }

    @PutMapping("/group/{id}")
    public Group updateGroup(@PathVariable int id, @RequestBody Group group) {
        if (group.getId() != id){
            throw new IllegalArgumentException("ID mismatch between URL and request body");
        }
        return groupService.updateGroup(group);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        groupService.deleteGroup(id);
        return ResponseEntity.ok("Student with ID " + id + " has been deleted.");
    }
}
