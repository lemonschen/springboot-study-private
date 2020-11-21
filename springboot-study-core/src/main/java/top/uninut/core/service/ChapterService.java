package top.uninut.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.uninut.core.entity.Chapter;
import top.uninut.core.repository.ChapterRepository;

@Service
public class ChapterService {
    private final ChapterRepository repository;

    @Autowired
    public ChapterService(ChapterRepository repository){
        this.repository = repository;
    }

    public Chapter findFirstChapter(int novelId){
        return repository.findFirstByNovelIdOrderByChapterIndexAsc(novelId);
    }

    public Page<Chapter> chapters(int novelId, Pageable pageable){
        return repository.findByNovelIdOrderByChapterIndexAsc(novelId,pageable);
    }

    public Chapter chapter(int novelId,int chapterIndex){
        return repository.findByNovelIdAndChapterIndex(novelId,chapterIndex);
    }
}
