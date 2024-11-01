package boardcafe.boardpractice.todo.presentation.dto.response;

import boardcafe.boardpractice.todo.domain.entity.Todo;

public record TodoItem(Long id, String content, boolean completed) {
    public static TodoItem of(Todo todo){
        return new TodoItem(todo.getId(), todo.getContent(), todo.isCompleted());
    }
}
