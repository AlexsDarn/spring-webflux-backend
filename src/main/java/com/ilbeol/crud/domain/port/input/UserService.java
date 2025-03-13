package com.ilbeol.crud.domain.port.input;

import com.ilbeol.crud.domain.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> getAllUsers();
    Mono<User> getUserById(Long id);
    Mono<User> createUser(User user);
    Mono<User> updateUser(Long id, User user);
    Mono<Void> deleteUser(Long id);
}
