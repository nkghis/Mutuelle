package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.role.RoleDTO;
import ics.ci.mutuelle.entity.AppRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleToRoleDTO(AppRole role);
}
