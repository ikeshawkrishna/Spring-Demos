package com.org.MultipleDBExample.Repo.User;

import com.org.MultipleDBExample.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
