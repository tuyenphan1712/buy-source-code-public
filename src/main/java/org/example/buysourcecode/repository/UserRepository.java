package org.example.buysourcecode.repository;

import org.example.buysourcecode.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "select u from User u where u.username = :username and u.status != 'DELETED'")
    User findUserByUsername(@Param("username") String username);

    @Query(value = "select u from User u where u.id = :id and u.status != 'DELETED'")
    User findUserById(@Param("id")String id);
}
