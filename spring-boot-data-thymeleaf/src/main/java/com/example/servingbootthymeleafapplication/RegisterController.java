package com.example.servingbootthymeleafapplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/")
public class RegisterController {
	
	@Autowired
	private RegisterRepository registerRepository;
	
	@GetMapping("/register")
	public String greetingForm(Register register) {
		return "register";
	}
	
	@PostMapping("/register")
	public String save(Register register, Model model) {
	model.addAttribute("name", register.getFirstName());
	//registerService.saveUser(register);
	System.out.println("Register");
	return "success";
	}
	/*@GetMapping("showForm")
	public String showUserForm() {
		return "register";
	}
	@GetMapping("/list")
	public String users(Model model) {
		model.addAttribute("users", this.registerRepository.findAll());
		return "index";
	}
	@PostMapping("add")
	public String addUser(@Valid Register user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "register";
			
		}
		this.registerRepository.save(user);
		return "redirect:list";
		
	}
	@GetMapping("/edit/id")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Register user = this.registerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user id: "+id));
		model.addAttribute("users",user);
		return "update-user";
		
	}
	@GetMapping("update/{id}")
	public String updateUser(@PathVariable("id") long id, Register user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}
		//update user
		registerRepository.save(user);
		
		//get all users(with update)
		model.addAttribute("users",this.registerRepository.findAll());
		return "index";
	}
	@DeleteMapping("delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Register user = this.registerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user id: "+id));
		this.registerRepository.delete(user);
		model.addAttribute("users", this.registerRepository.findAll());
		return "index";
		
	}*/

}
