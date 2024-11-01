package boardcafe.boardpractice.todo.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TodoCreateServiceRequest (String content) {
}
