package com.ilbeol.crud.application.usecase;

import com.ilbeol.crud.domain.model.User;
import com.ilbeol.crud.domain.port.input.UserService;
import com.ilbeol.crud.domain.port.output.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetUserUseCase implements UserService {
    private final UserRepository userRepository;

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.findByEmailAddress(user.getEmailAddress())
                .flatMap(existingUser -> Mono.error(new IllegalStateException("User already exists")))
                .switchIfEmpty(userRepository.save(user))
                .cast(User.class);
    }

    @Override
    public Mono<User> updateUser(Long id, User user) {
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
                    existingUser.setRut(user.getRut());
                    existingUser.setDv(user.getDv());
                    existingUser.setBirthDate(user.getBirthDate());
                    existingUser.setEmailAddress(user.getEmailAddress());
                    existingUser.setPassword(user.getPassword());
                    return userRepository.save(existingUser);
                });
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }
}
