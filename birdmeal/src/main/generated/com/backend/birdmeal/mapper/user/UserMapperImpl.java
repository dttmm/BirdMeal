package com.backend.birdmeal.mapper.user;

import com.backend.birdmeal.dto.user.UserDto;
import com.backend.birdmeal.dto.user.UserDto.UserDtoBuilder;
import com.backend.birdmeal.entity.user.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-13T16:54:57+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public List<UserDto> toDtoList(List<UserEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( entityList.size() );
        for ( UserEntity userEntity : entityList ) {
            list.add( toDto( userEntity ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> toEntityList(List<UserDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( dtoList.size() );
        for ( UserDto userDto : dtoList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    @Override
    public UserEntity toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserSeq( userDto.getUserSeq() );
        userEntity.setUserEmail( userDto.getUserEmail() );
        userEntity.setUserNickname( userDto.getUserNickname() );
        userEntity.setUserEoa( userDto.getUserEoa() );
        userEntity.setUserTel( userDto.getUserTel() );
        userEntity.setUserAdd( userDto.getUserAdd() );
        userEntity.setUserChargeState( userDto.isUserChargeState() );
        userEntity.setUserRegistDate( userDto.getUserRegistDate() );
        userEntity.setUserUpdateDate( userDto.getUserUpdateDate() );

        return userEntity;
    }

    @Override
    public UserDto toDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.userSeq( userEntity.getUserSeq() );
        userDto.userEmail( userEntity.getUserEmail() );
        userDto.userNickname( userEntity.getUserNickname() );
        userDto.userEoa( userEntity.getUserEoa() );
        userDto.userTel( userEntity.getUserTel() );
        userDto.userAdd( userEntity.getUserAdd() );
        userDto.userChargeState( userEntity.isUserChargeState() );
        userDto.userRegistDate( userEntity.getUserRegistDate() );
        userDto.userUpdateDate( userEntity.getUserUpdateDate() );

        return userDto.build();
    }
}
