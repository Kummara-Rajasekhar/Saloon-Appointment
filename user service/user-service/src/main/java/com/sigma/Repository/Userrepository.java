package com.sigma.Repository;

import com.sigma.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User,Long> {

}
