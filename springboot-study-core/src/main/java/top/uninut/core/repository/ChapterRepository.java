package top.uninut.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.uninut.core.entity.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter,Long> {
    Chapter findFirstByNovelIdOrderByChapterIndexAsc(int novelId);

    @Query("select new Chapter(a.chapterId,a.novelId,a.chapterIndex,a.chapterName) from Chapter a where a.novelId = ?1 order by a.chapterIndex asc ")
    Page<Chapter> findByNovelIdOrderByChapterIndexAsc(int novelId, Pageable pageable);

    Chapter findByNovelIdAndChapterIndex(int novelId,int chapterId);

    @Query("select a from Chapter a where a.novelId = ?1 and a.chapterIndex < ?2 order by a.chapterIndex desc")
    Page<Chapter> findPreviousByNovelIdAndChapterIndex(int novelId,int chapterId,Pageable pageable);

    @Query("select a from Chapter a where a.novelId = ?1 and a.chapterIndex > ?2 order by a.chapterIndex asc")
    Page<Chapter> findNextByNovelIdAndChapterIndex(int novelId,int chapterId,Pageable pageable);
}
