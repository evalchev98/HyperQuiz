package HyperQuiz.web;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import HyperQuiz.entities.Quiz;
import HyperQuiz.models.binding.QuizAddBindingModel;
import HyperQuiz.models.service.QuizServiceModel;
import HyperQuiz.models.view.QuizViewModel;
import HyperQuiz.service.CloudinaryService;
import HyperQuiz.service.QuizService;

@Controller
@RequestMapping("/quizzes")
public class QuizController extends BaseController {

	private QuizService quizService;
	private CloudinaryService cloudinaryService;
//	private ModelMapper modelMapper;

	@Autowired
	public QuizController(QuizService quizService, CloudinaryService cloudinaryService) {
		this.cloudinaryService=cloudinaryService;
		this.quizService = quizService;
		//this.modelMapper = modelMapper;
	}

	@GetMapping("/add")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView addQuiz(ModelAndView modelAndView, @ModelAttribute(name = "model") Quiz model) {
		modelAndView.addObject("model", model);
		return super.view("add-quiz");
	}

	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView addQuizConfirm(ModelAndView modelAndView,
			@ModelAttribute(name = "model") Quiz model) {
		//da opravq cloudinaryconfig
		Quiz quiz=model;
		quiz.setImageUrl(model.getImageUrl());
		this.quizService.createQuiz(quiz);
		modelAndView.addObject(quiz);
		return super.redirect("/quizzes/all");
	}

	@GetMapping("/all")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView allQuizzes(ModelAndView modelAndView) {
		List<Quiz> quizzes = this.quizService.findAllQuizzes();
		modelAndView.addObject("quizzes", quizzes);
		return super.view("all-quizzes", modelAndView);
	}

	@GetMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView deleteQuiz(@PathVariable String id, ModelAndView modelAndView) {
		Quiz quiz = this.quizService.findQuizByID(id);
		modelAndView.addObject("model", quiz);
		return super.view("delete-quiz", modelAndView);
	}

	@PostMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView deleteQuizConfirm(@PathVariable String id) {
		this.quizService.deleteQuiz(id);
		return super.redirect("/quizzes/all");
	}
	
	@GetMapping("/play/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView playQuiz(@PathVariable String id, ModelAndView modelAndView) {
		Quiz quiz = this.quizService.findQuizByID(id);
		modelAndView.addObject("model", quiz);
		return super.view("play-quiz", modelAndView);
	}

	@GetMapping("/fetch")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	@ResponseBody
	public List<Quiz> fetchQuizzes() {
		List<Quiz> quizzes = this.quizService.findAllQuizzes();
		return quizzes;

	}

}
