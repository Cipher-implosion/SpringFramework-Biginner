package com.example.webapp.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.ToDo;
import com.example.webapp.repository.ToDoMapper;

@SpringBootTest
@Transactional  // テスト後に自動ロールバック
class ToDoMapperTest {

    @Autowired
    private ToDoMapper toDoMapper;

    @Test
    void selectAll_正常に取得できる() {
        List<ToDo> list = toDoMapper.selectAll();
        assertThat(list).isNotNull();
    }

    @Test
    void insert_and_selectById() {
        ToDo todo = new ToDo();
        todo.setTodo("JUnitテスト");
        todo.setDetail("MyBatisのテスト");

        toDoMapper.insert(todo);

        List<ToDo> list = toDoMapper.selectAll();
        ToDo saved = list.get(list.size() - 1);

        ToDo result = toDoMapper.selectById(saved.getId());
        assertThat(result.getTodo()).isEqualTo("JUnitテスト");
    }

    @Test
    void update_正常に更新される() {
        ToDo todo = toDoMapper.selectAll().get(0);
        todo.setTodo("更新後");

        toDoMapper.update(todo);

        ToDo updated = toDoMapper.selectById(todo.getId());
        assertThat(updated.getTodo()).isEqualTo("更新後");
    }

    @Test
    void delete_正常に削除される() {
        ToDo todo = toDoMapper.selectAll().get(0);
        toDoMapper.delete(todo.getId());

        ToDo deleted = toDoMapper.selectById(todo.getId());
        assertThat(deleted).isNull();
    }
}
