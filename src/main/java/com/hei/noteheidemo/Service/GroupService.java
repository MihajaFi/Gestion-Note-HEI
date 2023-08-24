package com.hei.noteheidemo.Service;

import com.hei.noteheidemo.Repository.GroupRepository;
import com.hei.noteheidemo.Entity.Group;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private GroupRepository groupRepository ;
    public GroupService(GroupRepository groupRepository){
        this.groupRepository = groupRepository ;
    }
    public Group createGroup(Group group){
        try {
            groupRepository.insert(group);
            return group;
        } catch (SQLException e) {
            throw new RuntimeException("There has a error when creatingGroup"+group+ e ) ;
        }
    }

    public List<Group> getAllGroups() {
        try{
            return groupRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when fetching group "+e);
        }

    }
    public Optional<Group> getGroupById(int id) {
        try{
            return groupRepository.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when fetching group by id "+id+e);
        }
    }

    public Group updateGroup(Group group) {
        try {
            groupRepository.update(group);
            return group ;
        } catch (SQLException e) {
            throw new RuntimeException("There was error when updating group" +group+ e);
        }
    }

    public void deleteGroup(int id) {
        try {
            groupRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when deleting " + id + e) ;
        }
    }
}
