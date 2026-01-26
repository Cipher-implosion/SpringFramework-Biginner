package com.example.webapp.Service;

import java.util.List;

import com.example.webapp.entity.ToDo;

/**
 * ToDo : サービス
 */
public interface ToDoService {
	
	/**
	 * 全「すること」を検索します。 
	 */
	List<ToDo> findAllToDo();
	
	/**
	 * 指定されたIDの「すること」を検索します。 
	 */
	ToDo findByIdToDo(Integer Id);
	
	/**
	 * 「すること」を新規登録します。 
	 */
	void insertToDo(ToDo toDo);
	
	/**
	 * 「すること」を更新します。 
	 */
	void updateToDo(ToDo toDo);
	
	/**
	 * 「すること」を削除します。 
	 */
	void deleteToDo(Integer Id);
}
