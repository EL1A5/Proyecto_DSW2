package com.epy.main.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epy.main.entity.Authority;
import com.epy.main.entity.User;
import com.epy.main.repository.UserRepository;

@Service
public class UsuarioConfigService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User  appUser = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("No existe usuario"));
			List grantList = new ArrayList<>();
			
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUser.getAuthority().getAuthority());
				grantList.add(grantedAuthority);
			
			/*
			for (Authority x : appUser.getAuthority()) {
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(x.getAuthority());
				grantList.add(grantedAuthority);
			}
			*/  
			return new UserDetails() {
				
				@Override
				public boolean isEnabled() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isCredentialsNonExpired() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isAccountNonLocked() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isAccountNonExpired() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public String getUsername() {
					// TODO Auto-generated method stub
					return appUser.getUsername();
				}
				
				@Override
				public String getPassword() {
					// TODO Auto-generated method stub
					return appUser.getPassword();
				}
				
				@Override
				public Collection<? extends GrantedAuthority> getAuthorities() {
					// TODO Auto-generated method stub
					return grantList;
				}
			};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
