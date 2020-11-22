package top.uninut.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import top.uninut.core.common.RestResult;
import top.uninut.core.entity.Chapter;
import top.uninut.core.entity.Novel;
import top.uninut.core.service.ChapterService;
import top.uninut.core.service.NovelService;

@RestController
@RequestMapping("/novel")
public class NovelController {
    private final NovelService novelService;
    private final ChapterService chapterService;

    @Autowired
    public NovelController(NovelService novelService,ChapterService chapterService){
        this.novelService = novelService;
        this.chapterService = chapterService;
    }

    @GetMapping
    public RestResult<Novel> novels(Pageable pageable){
        return new RestResult<Novel>().pageSuccess(novelService.find(pageable));
    }

    @GetMapping("/{novelId}")
    public RestResult<Chapter> chapters(@PathVariable int novelId,Pageable pageable){
        return new RestResult<Chapter>().pageSuccess(chapterService.chapters(novelId,pageable));
    }

    @GetMapping("/{novelId}/{chapterIndex}")
    public RestResult<Chapter> chapter(@PathVariable int novelId,@PathVariable int chapterIndex){
        return new RestResult<Chapter>().success(chapterService.chapter(novelId,chapterIndex));
    }

    @GetMapping("/{novelId}/{chapterIndex}/previous")
    public RestResult<Chapter> previousChapter(@PathVariable int novelId,@PathVariable int chapterIndex){
        return new RestResult<Chapter>().success(chapterService.previousChapter(novelId,chapterIndex));
    }

    @GetMapping("/{novelId}/{chapterIndex}/next")
    public RestResult<Chapter> nextChapter(@PathVariable int novelId,@PathVariable int chapterIndex){
        return new RestResult<Chapter>().success(chapterService.nextChapter(novelId,chapterIndex));
    }

    @PostMapping
    public RestResult<?> save(@RequestBody String novelFilePath){
        try {
            novelService.saveNovel(novelFilePath);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return new RestResult<>().success();
    }
}
