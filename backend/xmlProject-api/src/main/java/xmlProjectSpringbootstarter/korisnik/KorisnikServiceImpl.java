package xmlProjectSpringbootstarter.korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "korisnikService")
public class KorisnikServiceImpl implements UserDetailsService,KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public Korisnik insert(Korisnik k) {
        k.setPassword(bcryptEncoder.encode(k.getPassword()));
        return korisnikRepository.insert(k);
    }

    @Override
    public Korisnik findByEmail(String email) {
        List<Korisnik> korisnici = korisnikRepository.findAll();
        Korisnik ret = null;
        for(Korisnik k: korisnici) {
            if(k.getEmail().equals(email)) {
                ret = k;
            }
        }
        if(ret == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return ret;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Korisnik korisnik = findByEmail(s);
        if(korisnik == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(String r: korisnik.getUloge()) {
            authorities.add(new SimpleGrantedAuthority(r));
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(korisnik.getEmail(), korisnik.getPassword(), authorities);

        return userDetails;
    }
}
