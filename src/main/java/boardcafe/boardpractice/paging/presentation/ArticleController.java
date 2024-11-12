package boardcafe.boardpractice.paging.presentation;

import boardcafe.boardpractice.paging.application.ArticleService;
import boardcafe.boardpractice.paging.application.response.ArticleItem;
import boardcafe.boardpractice.paging.presentation.request.createArticlesRequest;
import boardcafe.boardpractice.paging.presentation.response.getCursorArticlesResponse;
import boardcafe.boardpractice.paging.presentation.response.getOffsetArticlesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/paging/offset")
    public ResponseEntity<getOffsetArticlesResponse> getOffsetArticles(Pageable pageable) {
        Page<ArticleItem> allArticles = articleService.getOffsetArticles(pageable);
        return ResponseEntity.ok(new getOffsetArticlesResponse(allArticles.getTotalPages()-1,allArticles.getContent()));
    }

    @GetMapping("/paging/cursor")
    public ResponseEntity<getCursorArticlesResponse> getCursorArticles(@RequestParam("cursorId") Long cursorId, Pageable pageable) {
        Slice<ArticleItem> cursorArticles = articleService.getCursorArticles(cursorId, pageable);
        Long lastId=cursorArticles.isLast()?null:cursorArticles.getContent().getLast().id();
        return ResponseEntity.ok(new getCursorArticlesResponse(lastId,cursorArticles.getContent()));
    }

    @PostMapping("/make")
    public ResponseEntity<Void> creatArticles(@RequestBody createArticlesRequest request) {
        articleService.createArticles(request.articles());
        return ResponseEntity.ok().build();
    }
}
