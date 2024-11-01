package boardcafe.boardpractice.todo.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TodoCreateRequest(
        //null값 허용 X, '' 허용 X, "   " 허용 X --> 무조건 글자 있어야 함
        @NotBlank(message = "할 일을 입력해야 합니다!!")
        String content) {

    public TodoCreateServiceRequest toServiceRequest(){
        return new TodoCreateServiceRequest(content);
    }
}
