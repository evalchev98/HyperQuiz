package HyperQuiz.web;

import java.io.IOException;
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

import HyperQuiz.entities.Question;
import HyperQuiz.entities.Quiz;
import HyperQuiz.mapper.QuestionMapper;
import HyperQuiz.models.binding.QuestionDTO;
import HyperQuiz.models.binding.QuizAddBindingModel;
import HyperQuiz.models.service.QuestionServiceModel;
import HyperQuiz.models.view.QuestionViewModel;
import HyperQuiz.service.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController extends BaseController {

	private QuestionService questionService;
	//private QuestionMapper questionMapper;
	//private ModelMapper modelMapper;

	@Autowired
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
		//this.questionMapper = questionMapper;
		//this.modelMapper = modelMapper;
	}

	@GetMapping("/add")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView addQuestion(ModelAndView modelAndView,@ModelAttribute(name = "model") QuestionDTO model) {
		modelAndView.addObject("model", model);
		return super.view("add-question");
	}

	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView addQuestionConfirm(ModelAndView modelAndView, @ModelAttribute(name = "model") QuestionDTO model)  {
		Question question=this.questionService.createQuestion(model);
		modelAndView.addObject(question);
		return super.redirect("/home");
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView allQuestions(ModelAndView modelAndView) {
		List<Question> questions = this.questionService.findAllQuestions();
		modelAndView.addObject("questions", questions);
		return super.view("all-questions", modelAndView);
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView deleteQuestion(@PathVariable String id, ModelAndView modelAndView) {
		Question question = this.questionService.findQuestionByID(id);
		modelAndView.addObject("model", question);
		return super.view("delete-question", modelAndView);
	}
	
	@PostMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView deleteQuestionConfirm(@PathVariable String id) {
		this.questionService.deleteQuestion(id);
		return super.redirect("/questions/all");
	}
	
	@GetMapping("/fetch")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	@ResponseBody
	public List<Question> fetchQuestions() {
		List<Question> questions = this.questionService.findAllQuestions();
		return questions;

	}
}
