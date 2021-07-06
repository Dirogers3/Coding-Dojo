package com.ianrogers.beltexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ianrogers.beltexam.models.LoginUser;
import com.ianrogers.beltexam.models.Task;
import com.ianrogers.beltexam.models.User;
import com.ianrogers.beltexam.services.TaskService;
import com.ianrogers.beltexam.services.UserService;
  
@Controller
public class HomeController {
    
    @Autowired
    private UserService us;
    
    @Autowired
    private TaskService ts; 
    
    
    //render login page
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    //post for login page register side
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        us.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());

            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }
    //post for login page login side
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = us.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            System.out.println("THERE ARE ISSUES");
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    //render dashboard page after login
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	User user = us.getUserById((Long)session.getAttribute("user_id"));
    	model.addAttribute("user", user);
    	model.addAttribute("allTasks", this.ts.allTasks());
    	return "dashboard.jsp";
    }
    
    //Render create Tasks page
    @GetMapping("/createTask")
    public String createTask(@ModelAttribute("task") Task task, Model model, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	User user = us.getUserById((Long)session.getAttribute("user_id"));
    	List<User> users = us.allUsers();
    	model.addAttribute("task", new Task());
    	model.addAttribute("user", user); 
    	model.addAttribute("users", users);
    	return "create.jsp";
    }
    
    //Post for creating tasks
    @RequestMapping(value="/newTask", method=RequestMethod.PUT)
    public String newTask(@Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session, Model model) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	if(result.hasErrors()) {
    		User user = us.getUserById((Long)session.getAttribute("user_id"));
        	List<User> users = us.allUsers();
        	model.addAttribute("task", new Task());
        	model.addAttribute("user", user); 
        	model.addAttribute("users", users);
    		return "create.jsp";
         } else {
    	ts.createTask(task);
         return "redirect:/dashboard";
         }
    }
    
    @GetMapping("tasks/{id}")
	public String show(Model model, HttpSession session, @PathVariable("id") Long id) {
    	User user = us.getUserById((Long)session.getAttribute("user_id"));
    	model.addAttribute("user", user);
    	model.addAttribute("task", ts.findtask(id));
		return "show.jsp";
	}
    
    //render Edit jsp with fields
    @GetMapping("edit/{id}")
    public String edit(Model model, HttpSession session, @PathVariable("id")Long id, @ModelAttribute("edit") Task task) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	User user = us.getUserById((Long)session.getAttribute("user_id"));
    	List<User> users = us.allUsers();
    	model.addAttribute("task", ts.findtask(id));
    	model.addAttribute("users", users);
    	model.addAttribute("user", user); 
    	return "edit.jsp";
    }
    
    //Post for edit form
    @RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
    public String editTask(@Valid @ModelAttribute("edit") Task task, BindingResult result, Model model, HttpSession session, @PathVariable("id")Long id) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	if(result.hasErrors()) {
    		User user = us.getUserById((Long)session.getAttribute("user_id"));
        	List<User> users = us.allUsers();
        	model.addAttribute("task", ts.findtask(id));
        	model.addAttribute("users", users);
        	model.addAttribute("user", user); 
    		return "edit.jsp";
         } else {
    	ts.updateTask(id, task.getName(), task.getUser(), task.getAssignee(), task.getPriority());
         return "redirect:/dashboard";
         }
    }
    
    @GetMapping(value="delete/{id}")
	public String delete(@PathVariable("id") Long id) {
    	System.out.println("it is here");
		ts.delete(id);
		return "redirect:/dashboard";
	}
    
    
}