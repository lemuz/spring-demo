package com.omnisport.hello.security;

public class Constants {
	
	public static final String LOGIN_URL = "/sign-in";
	public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer";
	public static final String ISSUER_INFO = "http://localhost:8080/";
	public static final String SUPER_SECRET_KEY = "P455w0rd123!";
	public static final long TOKEN_EXPIRATION_TIME = 1_800_000; // 1 hora
	
}