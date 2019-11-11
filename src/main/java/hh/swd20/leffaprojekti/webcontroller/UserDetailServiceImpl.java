package hh.swd20.leffaprojekti.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.swd20.leffaprojekti.domain.Kayttaja;
import hh.swd20.leffaprojekti.domain.KayttajaRepository;



@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final KayttajaRepository kaRepository;

	@Autowired
	public UserDetailServiceImpl(KayttajaRepository kaRepository) {
		this.kaRepository = kaRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
    	Kayttaja curruser = kaRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
} 