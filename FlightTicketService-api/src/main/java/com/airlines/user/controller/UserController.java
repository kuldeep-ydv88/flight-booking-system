package com.airlines.user.controller;

import com.airlines.user.dto.ChangePasswordRequestDTO;
import com.airlines.user.dto.UserInfoDto;
import com.airlines.user.entity.UserInfo;
import com.airlines.user.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kuldeep
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
@Slf4j
public class UserController {
    private final UserInfoService userService;

    @GetMapping
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserInfoDto> getUserDetails(@PathVariable("id") String id){
        return ResponseEntity.ok(userService.getUserDetails(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserInfoDto> updateUserDetails(@RequestBody UserInfoDto userInfoDto, @PathVariable("id") String id){
        return ResponseEntity.ok(userService.updateUserDetails(userInfoDto, id));
    }

    @PutMapping("/change-password")
    public boolean changePassword(@RequestBody ChangePasswordRequestDTO requestPayload) {
        boolean isChanged = userService.changePassword(requestPayload);
        return true;
    }
}
