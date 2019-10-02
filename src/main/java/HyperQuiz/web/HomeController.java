package HyperQuiz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import HyperQuiz.entities.Quiz;
import HyperQuiz.service.QuizService;

@Controller
public class HomeController extends BaseController {

	private QuizService quizService;
	
	@Autowired
	public HomeController(QuizService quizService) {
		this.quizService = quizService;
	}

	@GetMapping("/")
	@PreAuthorize("isAnonymous()")
	public ModelAndView index() {
		return super.view("index");
	}
	
	@GetMapping("/home")
	@PreAuthorize("isAuthenticated()")
	public ModelAndView home(ModelAndView modelAndView) {
		List<Quiz> quizzes = quizService.findAllQuizzes();
		modelAndView.addObject("quizzes", quizzes);
		return super.view("home",modelAndView);
	}
}
