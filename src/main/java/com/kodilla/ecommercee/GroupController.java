package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup(Long gropuId) {
        return new GroupDto((long) 1, "test");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public void createGroup(GroupDto groupDto) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(GroupDto groupDto) {
        return new GroupDto((long) 2, "updated");
    }

}
