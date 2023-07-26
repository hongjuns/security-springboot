package io.security.coresecurity.service.Impl;

import io.security.coresecurity.dto.AccountDto;
import io.security.coresecurity.model.AccountEntity;
import io.security.coresecurity.repository.UserRepository;
import io.security.coresecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AccountEntity create(AccountEntity accountEntity) {
        return userRepository.save(accountEntity);
    }
}
