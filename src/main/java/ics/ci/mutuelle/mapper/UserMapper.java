package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.user.UserDTO;
import ics.ci.mutuelle.entity.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(AppUser user);
}
