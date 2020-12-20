package top.uninut.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
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
    public Page<Novel> novels(Pageable pageable){
        return novelService.find(pageable);
    }

    @GetMapping("/{novelId}")
    public Page<Chapter> chapters(@PathVariable int novelId,Pageable pageable){
        return chapterService.chapters(novelId,pageable);
    }

    @GetMapping("/{novelId}/{chapterIndex}")
    public Chapter chapter(@PathVariable int novelId,@PathVariable int chapterIndex){
        return chapterService.chapter(novelId,chapterIndex);
    }

    @GetMapping("/{novelId}/{chapterIndex}/previous")
    public Chapter previousChapter(@PathVariable int novelId,@PathVariable int chapterIndex){
        return chapterService.previousChapter(novelId,chapterIndex);
    }

    @GetMapping("/{novelId}/{chapterIndex}/next")
    public Chapter nextChapter(@PathVariable int novelId,@PathVariable int chapterIndex){
        return chapterService.nextChapter(novelId,chapterIndex);
    }

    @PostMapping
    public void save(@RequestBody String novelFilePath){
        try {
            novelService.saveNovel(novelFilePath);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
