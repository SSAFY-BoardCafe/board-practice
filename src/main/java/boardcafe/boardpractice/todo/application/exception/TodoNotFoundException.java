package boardcafe.boardpractice.todo.application.exception;

import boardcafe.boardpractice.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class TodoNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public TodoNotFoundException(final ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
