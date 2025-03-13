package com.ilbeol.crud.domain.port.output;

import com.ilbeol.crud.domain.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Flux<User> findAll();
    Mono<User> findById(Long id);
    Mono<User> save(User user);
    Mono<Void> deleteById(Long id);

    Mono<User> findByEmail(String email);
}
