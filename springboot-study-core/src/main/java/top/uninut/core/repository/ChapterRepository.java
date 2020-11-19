package top.uninut.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import top.uninut.core.entity.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter,Long> {
    Chapter findFirstByNovelIdOrderByChapterIndexAsc(int novelId);

    Page<Chapter> findChapterIdAndChapterNameAndChapterIndexByNovelIdOrderByChapterIndexAsc(int novelId, Pageable pageable);

    Chapter findByNovelIdAndChapterIndex(int novelId,int chapterId);
}
