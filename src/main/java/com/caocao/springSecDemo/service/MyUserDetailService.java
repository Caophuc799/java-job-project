package com.caocao.springSecDemo.service;

import com.caocao.springSecDemo.dao.UserRepo;
import com.caocao.springSecDemo.model.User;
import com.caocao.springSecDemo.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         User user = repo.findByUsername(username);

         if (user == null) {
             System.out.println("User 404");
             throw new UsernameNotFoundException("User not found 404");
         }

         return new UserPrincipal(user);
    }
}