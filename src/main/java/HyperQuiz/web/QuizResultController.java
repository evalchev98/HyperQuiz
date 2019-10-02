package HyperQuiz.web;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import HyperQuiz.entities.Quiz;
import HyperQuiz.entities.QuizResult;
import HyperQuiz.entities.User;
import HyperQuiz.models.service.UserServiceModel;
import HyperQuiz.service.QuizResultService;
import HyperQuiz.service.QuizService;
import HyperQuiz.service.UserService;

@Controller
@RequestMapping("/quizresult")
public class QuizResultController extends BaseController {
	private QuizResultService quizResultService;
	private QuizService quizService;
	private UserService userService;
	private ModelMapper modelMapper;

	@Autowired
	public QuizResultController(QuizResultService quizResultService, QuizService quizService, UserService userService,
			ModelMapper modelMapper) {
		this.quizResultService = quizResultService;
		this.quizService = quizService;
		this.userService = userService;
		this.modelMapper = modelMapper;
	}

	@PostMapping("/add/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView createQuizResultConfirm(ModelAndView modelAndView, Principal principal, @PathVariable String id,
			@ModelAttribute(name = "quizResult") QuizResult quizResult) {
		modelAndView.addObject("quizResult", quizResult);
		UserServiceModel userServiceModel = this.userService.findUserByUserName(principal.getName());
		quizResult.setUser(this.modelMapper.map(userServiceModel, User.class));
		Quiz quiz = this.quizService.findQuizByID(id);
		quizResult.setQuiz(quiz);
		this.quizResultService.createQuizResult(quizResult);
		return super.redirect("/home");
	}

}
