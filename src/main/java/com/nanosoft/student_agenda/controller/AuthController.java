package com.nanosoft.student_agenda.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanosoft.student_agenda.exception.TokenRefreshException;
import com.nanosoft.student_agenda.jwt.JwtUtils;
import com.nanosoft.student_agenda.model.ERole;
import com.nanosoft.student_agenda.model.RefreshToken;
import com.nanosoft.student_agenda.model.Role;
import com.nanosoft.student_agenda.model.User;
import com.nanosoft.student_agenda.model.UserDetailsImpl;
import com.nanosoft.student_agenda.payload.request.LoginRequest;
import com.nanosoft.student_agenda.payload.request.SignUpRequest;
import com.nanosoft.student_agenda.payload.request.TokenRefreshRequest;
import com.nanosoft.student_agenda.payload.response.JwtResponse;
import com.nanosoft.student_agenda.payload.response.MessageResponse;
import com.nanosoft.student_agenda.payload.response.TokenRefreshResponse;
import com.nanosoft.student_agenda.payload.response.UserInfoResponse;
import com.nanosoft.student_agenda.repository.RoleRepository;
import com.nanosoft.student_agenda.repository.UserRepository;
import com.nanosoft.student_agenda.service.RefreshTokenService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private RefreshTokenService refreshTokenService;

	@PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	    Authentication authentication = authenticationManager
	        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
	        .body(new UserInfoResponse(userDetails.getId(),
	                                   userDetails.getUsername(),
	                                   userDetails.getEmail(),
	                                   roles,
	                                   jwtCookie.toString()));
	  }
	  @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
	    }
	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
	    }
	    // Create new user's account
	    User user = new User(signUpRequest.getUsername(),
	                         signUpRequest.getEmail(),
	                         encoder.encode(signUpRequest.getPassword()));
	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();
	    if (strRoles == null) {
	      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);
	          break;
	        default:
	          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(userRole);
	        }
	      });
	    }
	    user.setRoles(roles);
	    userRepository.save(user);
	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	  }
	  @PostMapping("/signout")
	  public ResponseEntity<?> logoutUser() {
	    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
	        .body(new MessageResponse("You've been signed out!"));
	  }
	  
//	@PostMapping("/signin")
//	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//	    Authentication authentication = authenticationManager.authenticate(
//	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//	    SecurityContextHolder.getContext().setAuthentication(authentication);
//	    String jwt = jwtUtils.generateJwtToken(authentication);
//	    
//	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
//	    List<String> roles = userDetails.getAuthorities().stream()
//	        .map(item -> item.getAuthority())
//				.collect(Collectors.toList());
//
//		RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
//
//		return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
//				userDetails.getUsername(), userDetails.getEmail(), roles));
//	}
//	
//	@PostMapping("/signup")
//	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Username is already taken!"));
//		}
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Email is already in use!"));
//		}
//		
//		User user = new User(signUpRequest.getUsername(), 
//							 signUpRequest.getEmail(),
//							 encoder.encode(signUpRequest.getPassword()));
//		Set<String> strRoles = signUpRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//		if (strRoles == null) {
//			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//			roles.add(userRole);
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(adminRole);
//					break;
//				default:
//					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(userRole);
//				}
//			});
//		}
//		user.setRoles(roles);
//		userRepository.save(user);
//		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//	}
//	
//	@PostMapping("/refreshtoken")
//	public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
//		
//		String requestRefreshToken = request.getRefreshToken();
//		
//		return refreshTokenService.findByToken(requestRefreshToken)
//				.map(refreshTokenService::verifyExpiration)
//				.map(RefreshToken::getUser)
//				.map(user -> {
//					String token = jwtUtils.generateTokenFromUsername(user.getUsername());
//					return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
//				})
//				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token non è nel databse"));
//	}
//	
}