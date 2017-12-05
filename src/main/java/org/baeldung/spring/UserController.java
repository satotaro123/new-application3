package org.baeldung.spring;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;

//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;

import org.baeldung.spring.UserService;
import org.baeldung.spring.UserRepository;

//import java.util.List;

@Controller
@RequestMapping("signup")
public class UserController {

	@Autowired
    UserService userService;
	
	@Autowired
	UserRepository repository;
	
	
	
	//�o�^
	@GetMapping
    public String signup(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "signup";
    }
	
	@PostMapping
    public String signupPost(Model model, @Valid UserForm userForm, BindingResult bindingResult, HttpServletRequest request) {
		userService.registerUser(userForm.getNo(),userForm.getUserid(), userForm.getUsername(),userForm.getOrgname(),userForm.getPassword(),"1","USER");
		return "signup";
	}
		
	
}
