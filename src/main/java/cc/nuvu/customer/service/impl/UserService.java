package cc.nuvu.customer.service.impl;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import cc.nuvu.customer.repository.UserRepository;
import cc.nuvu.customer.repository.entity.User;
import cc.nuvu.customer.service.IUserService;
import cc.nuvu.customer.util.Constants;
import cc.nuvu.customer.util.exception.ResourceNotFoundException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public String getJWTToken(String username, String password) {
		if (validateUsernameAndPassword(username, password)) {
			String secretKey = "mySecretKey";
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
			String token = Jwts.builder().setId("softtekJWT").setSubject(username)
					.claim("authorities",
							grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

			return token;
		}
		return null;
	}

	private boolean validateUsernameAndPassword(String username, String password) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(Constants.USER, Constants.USERNAME, username));
		if (user.getPassword().equalsIgnoreCase(encrypt(password)))
			return true;
		else
			return false;
	}

	public static String encrypt(String str) {
		try {
			Cipher ecipher = Cipher.getInstance("AES");
			SecretKey key = new SecretKeySpec("1234567891234567".getBytes(), "AES");
			ecipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] utf8 = str.getBytes("UTF-8");
			byte[] enc = ecipher.doFinal(utf8);
			return Base64.getEncoder().encodeToString(enc);
		} catch (Exception e) {
		}
		return null;
	}

	public static String decrypt(String str) {
		try {
			Cipher dcipher = Cipher.getInstance("AES");
			SecretKey key = new SecretKeySpec("1234567891234567".getBytes(), "AES");
			dcipher.init(Cipher.DECRYPT_MODE, key);
			byte[] dec = Base64.getDecoder().decode(str);
			byte[] utf8 = dcipher.doFinal(dec);
			return new String(utf8, "UTF-8");
		} catch (Exception e) {
		}
		return null;
	}

}
