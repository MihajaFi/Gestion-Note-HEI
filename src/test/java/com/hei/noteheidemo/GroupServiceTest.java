package com.hei.noteheidemo;

import com.hei.noteheidemo.Entity.Group;
import com.hei.noteheidemo.Repository.GroupRepository;
import com.hei.noteheidemo.Service.GroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GroupServiceTest {
    private GroupService groupService;

    @Mock
    private GroupRepository groupRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        groupService = new GroupService(groupRepository);
    }

    @Test
    void testCreateGroup() throws SQLException {
        Group group = new Group(1, "H1");

        doNothing().when(groupRepository).insert(group);

        groupService.createGroup(group);

        verify(groupRepository, times(1)).insert(group);
    }

    @Test
    void testGetAllGroups() throws SQLException {
        List<Group> groups = new ArrayList<>();
        groups.add(new Group(1, "H1"));
        groups.add(new Group(2, "H2"));
        when(groupRepository.findAll()).thenReturn(groups);

        List<Group> result = groupService.getAllGroups();

        assertEquals(groups, result);
        verify(groupRepository, times(1)).findAll();
    }

    @Test
    void testGetGroupById() throws SQLException {
        int groupId = 1;
        Group group = new Group(groupId, "H1");

        when(groupRepository.findById(groupId)).thenReturn(Optional.of(group));

        Optional<Group> result = groupService.getGroupById(groupId);

        assertEquals(group, result.orElse(null));
        verify(groupRepository, times(1)).findById(groupId);
    }

    @Test
    void testUpdateGroup() throws SQLException {
        Group group = new Group(1, "H1");

        groupService.updateGroup(group);

        verify(groupRepository, times(1)).update(group);
    }

    @Test
    void testDeleteGroup() throws SQLException {
        int groupId = 1;
        groupService.deleteGroup(groupId);

        verify(groupRepository, times(1)).delete(groupId);
    }
}
