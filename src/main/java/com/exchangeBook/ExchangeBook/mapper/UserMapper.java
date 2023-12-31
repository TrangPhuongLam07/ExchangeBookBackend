package com.exchangeBook.ExchangeBook.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exchangeBook.ExchangeBook.dto.AddressDto;
import com.exchangeBook.ExchangeBook.dto.ImageDto;
import com.exchangeBook.ExchangeBook.dto.UserDto;
import com.exchangeBook.ExchangeBook.entity.Address;
import com.exchangeBook.ExchangeBook.entity.User;
import com.exchangeBook.ExchangeBook.payload.response.UserDetailResponse;
import com.exchangeBook.ExchangeBook.payload.response.UserResponse;

@Component
public class UserMapper {

	@Autowired
	AddressMapper addressMapper;

	@Autowired
	ImageMapper imageMapper;

	@Autowired
	PostMapper postMapper;

	public UserDto toUserDto(User user) {
		UserDto userDto = UserDto.builder().firstName(user.getFirstName()).lastName(user.getLastName())
				.phoneNumber(user.getPhoneNumber()).address(addressMapper.toAddressDto(user.getAddress())).build();
		return userDto;
	}

	public UserDetailResponse toUserDetailResponse(User user) {

		Optional<ImageDto> avatar = Optional.ofNullable(imageMapper.toImageDto(user.getAvatar()));
		Address address = user.getAddress();
		AddressDto addressDto = null;
		if (address != null) {
			addressDto = addressMapper.toAddressDto(address);
		}
		UserDetailResponse userDetailResponse = UserDetailResponse.builder().id(user.getId()).email(user.getEmail())
				.firstName(user.getFirstName()).lastName(user.getLastName()).phoneNumber(user.getPhoneNumber())
				.role(user.getRole().toString()).avatar(avatar.get()).address(addressDto).build();
		return userDetailResponse;
	}

	public UserResponse toUserResponse(User user) {

		Optional<ImageDto> avatar = Optional.ofNullable(imageMapper.toImageDto(user.getAvatar()));
		AddressDto address = addressMapper.toAddressDto(user.getAddress());

		UserResponse usersResponse = UserResponse.builder().id(user.getId()).email(user.getEmail())
				.firstName(user.getFirstName()).lastName(user.getLastName()).phoneNumber(user.getPhoneNumber())
				.role(user.getRole().toString()).avatar(avatar.get()).address(address).build();
		return usersResponse;
	}
}
