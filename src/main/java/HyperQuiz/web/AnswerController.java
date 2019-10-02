package HyperQuiz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import HyperQuiz.entities.Answer;
import HyperQuiz.entities.Question;
import HyperQuiz.models.binding.AnswerDTO;
import HyperQuiz.service.AnswerService;

@Controller
@RequestMapping("/answers")
public class AnswerController extends BaseController {
	private AnswerService answerService;

	@Autowired
	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	@GetMapping("/add")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView addAnswer(ModelAndView modelAndView, @ModelAttribute(name="model")AnswerDTO model) {
		modelAndView.addObject("model", model);
		return super.view("add-answer");
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView addAnswerConfirm(ModelAndView modelAndView, @ModelAttribute(name="model")AnswerDTO model) {
		Answer answer= this.answerService.createAnswer(model);
		modelAndView.addObject(answer);
		return super.redirect("/home");
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView allAnswers(ModelAndView modelAndView) {
		List<Answer> answers = this.answerService.findAllAnswers();
		modelAndView.addObject("answers", answers);
		return super.view("all-answers", modelAndView);
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView deleteAnswer(@PathVariable String id, ModelAndView modelAndView) {
		Answer answer = this.answerService.findAnswerByID(id);
		modelAndView.addObject("model", answer);
		return super.view("delete-answer", modelAndView);
	}
	
	@PostMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_MODERATOR')")
	public ModelAndView deleteQuestionConfirm(@PathVariable String id) {
		this.answerService.deleteAnswer(id);
		return super.redirect("/answers/all");
	}
}
