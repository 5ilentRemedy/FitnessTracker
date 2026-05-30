package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserEmailDto;
import pl.wsb.fitnesstracker.user.api.UserNotFoundException;
import pl.wsb.fitnesstracker.user.api.UserProvider;
import pl.wsb.fitnesstracker.user.api.UserService;
import pl.wsb.fitnesstracker.user.api.UserSimpleDto;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserService userService;
    private final UserProvider userProvider;
    private final UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDto) {
        User user = new User(userDto.firstName(), userDto.lastName(), userDto.birthdate(), userDto.email());
        User createdUser = userService.createUser(user);
        return userMapper.toUserDto(createdUser);
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userProvider.findAllUsers().stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @GetMapping("/simple")
    public List<UserSimpleDto> getSimpleUsers() {
        return userProvider.findAllUsers().stream()
                .map(userMapper::toUserSimpleDto)
                .toList();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        User user = userProvider.getUser(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        return userMapper.toUserDto(user);
    }

    @GetMapping("/email")
    public List<UserEmailDto> getUserByEmail(@RequestParam String email) {
        return userProvider.findUsersByEmailContaining(email).stream()
                .map(userMapper::toUserEmailDto)
                .toList();
    }

    @GetMapping("/older/{time}")
    public List<UserDto> getUsersOlderThan(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate time) {
        return userProvider.findUsersOlderThan(time).stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    public UserDto updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        User user = new User(userDto.firstName(), userDto.lastName(), userDto.birthdate(), userDto.email());
        User updatedUser = userService.updateUser(userId, user);
        return userMapper.toUserDto(updatedUser);
    }

}