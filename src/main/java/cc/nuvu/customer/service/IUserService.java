package cc.nuvu.customer.service;

public interface IUserService {

	String getJWTToken(String username, String password);

}