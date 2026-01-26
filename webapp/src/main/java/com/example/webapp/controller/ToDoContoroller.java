package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.Service.ToDoService;
import com.example.webapp.entity.ToDo;

import lombok.RequiredArgsConstructor;

/**
 * ToDoコントローラ
 */
@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoContoroller {
	
	/** DI */
	private final ToDoService toDoService;
	
	/**
	 * 「すること」の一覧を表示します。
	 */
	@GetMapping
	public String list(Model model) {
		model.addAttribute("todos", toDoService.findAllToDo());
		return "todo/list";
	}
	
	/**
	 * 指定されたIDの「すること」の詳細を表示します。
	 */
	@GetMapping("/{id}")
	public String detail(@PathVariable Integer id, Model model, 
			RedirectAttributes attributes) {
		// 「すること」IDに対応する「すること」情報を取得
		ToDo toDo = toDoService.findByIdToDo(id);
		if (toDo != null) {
			// 対象データがある場合はモデルに格納
			model.addAttribute("todo", toDo);
			return "todo/detail";
		} else {
			// 対象データがない場合はフラッシュメッセージを設定
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
			// リダイレクト
			return "redirect:/todos";
		}
	}
}
