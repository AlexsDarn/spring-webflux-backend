package com.ilbeol.crud.infraestructure.adapter;

import com.ilbeol.crud.domain.model.User;
import com.ilbeol.crud.domain.port.output.UserRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface R2dbcUserRepository extends R2dbcRepository<User, Long>, UserRepository {
    @Override
    Flux<User> findAll();

    @Override
    Mono<User> findById(Long id);

    @Override
    Mono<User> save(User user);

    @Override
    Mono<Void> deleteById(Long id);
}
