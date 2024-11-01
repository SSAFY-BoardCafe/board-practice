package boardcafe.boardpractice.todo.presentation.controller;

import boardcafe.boardpractice.todo.application.service.TodoService;
import boardcafe.boardpractice.todo.presentation.dto.request.TodoCreateRequest;
import boardcafe.boardpractice.todo.presentation.dto.request.TodoCreateServiceRequest;
import boardcafe.boardpractice.todo.presentation.dto.response.TodoItem;
import boardcafe.boardpractice.todo.presentation.dto.response.TodoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<TodoResponse> getTodos() {
        return ResponseEntity.ok().body(todoService.getAllTodos());
    }

    //@ResponseStatus(HttpStatus.OK) void 리턴인 경우 status라도 보내기
    @PostMapping("/todos")
    public ResponseEntity<TodoItem> createTodo(@Valid @RequestBody TodoCreateRequest todoCreateRequest) {
        final TodoItem todoItem = todoService.save(todoCreateRequest.toServiceRequest());
        return ResponseEntity.created(URI.create("/todos/" + todoItem.id())).body(todoItem);
    }

    @PatchMapping("/todos/{todoId}")
    public ResponseEntity<Void> updateComplete(@PathVariable Long todoId) {
        todoService.updateTodoCompleted(todoId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId){
        todoService.delete(todoId);
        return ResponseEntity.noContent().build();
    }
}
