package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    GroupService groupService;

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getGroups());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) {
        return groupMapper.mapToGroupDto(groupService.getGroup(groupId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupService.saveGroup(groupMapper.mapToGroup(groupDto));

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public void updateGroup(@RequestBody GroupDto groupDto) {
        groupService.deleteGroup(groupDto.getId());
    }
}