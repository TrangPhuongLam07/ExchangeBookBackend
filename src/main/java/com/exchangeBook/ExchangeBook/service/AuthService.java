package com.exchangeBook.ExchangeBook.service;

import org.springframework.http.ResponseEntity;

import com.exchangeBook.ExchangeBook.payload.request.LoginRequest;
import com.exchangeBook.ExchangeBook.payload.request.RegisterRequest;
import com.exchangeBook.ExchangeBook.payload.request.ResetPasswordRequest;

public interface AuthService {

	ResponseEntity<?> registerNewUser(RegisterRequest registerRequest);

	ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
	
	ResponseEntity<?> verifyConfirmationToken(String token);
	
	ResponseEntity<?> resendVerificationEmail(String userEmail);
	
	ResponseEntity<?> sendForgetPasswordToken(String email);
	
	ResponseEntity<?> resendForgetPasswordToken(String email);

	ResponseEntity<?> verifyResetPasswordToken(ResetPasswordRequest resetPasswordRequest);

	ResponseEntity<?> resetPassword(ResetPasswordRequest resetPasswordRequest);

}
