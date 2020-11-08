package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {
    public Group mapToGroup(final GroupDto groupDto) {
        return new Group(groupDto.getGroupName());
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(group.getGroupName());
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groupList) {
        return groupList.stream()
                .map(t -> new GroupDto((t.getGroupName())))
                .collect(Collectors.toList());
    }

}