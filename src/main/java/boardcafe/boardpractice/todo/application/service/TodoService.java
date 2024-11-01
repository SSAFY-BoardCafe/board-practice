package boardcafe.boardpractice.todo.application.service;

import boardcafe.boardpractice.common.exception.ErrorCode;
import boardcafe.boardpractice.todo.application.exception.TodoNotFoundException;
import boardcafe.boardpractice.todo.domain.TodoRepository;
import boardcafe.boardpractice.todo.domain.entity.Todo;
import boardcafe.boardpractice.todo.presentation.dto.request.TodoCreateServiceRequest;
import boardcafe.boardpractice.todo.presentation.dto.response.TodoItem;
import boardcafe.boardpractice.todo.presentation.dto.response.TodoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static boardcafe.boardpractice.common.exception.ErrorCode.NOT_FOUND_TODO_ID;

@Transactional(readOnly = true)
@RequiredArgsConstructor //final 필드를 포함하는 생성자 자동 생성
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoResponse getAllTodos(){
        final List<Todo> todoList = todoRepository.findByDeletedFalse();
        return new TodoResponse(todoList.stream()
                .map(TodoItem::of)
                .toList());
    }

    @Transactional
    public TodoItem save(TodoCreateServiceRequest request){
        final Todo todo = todoRepository.save(new Todo(request.content()));
        return TodoItem.of(todo);
    }

    @Transactional
    public void updateTodoCompleted(final long todoId){
        final Todo todo = todoRepository.findByIdAndDeletedFalse(todoId)
                .orElseThrow(() -> new TodoNotFoundException(NOT_FOUND_TODO_ID));
        todo.updateCompleted();
    }

    @Transactional
    public void delete(final long todoId){
        final Todo todo = todoRepository.findByIdAndDeletedFalse(todoId)
                .orElseThrow(() -> new TodoNotFoundException(NOT_FOUND_TODO_ID));
        todo.removeTodo();
    }



}
