package top.uninut.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.uninut.core.entity.Chapter;
import top.uninut.core.entity.Novel;
import top.uninut.core.repository.ChapterRepository;
import top.uninut.core.repository.NovelRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

@Service
public class NovelService {

    Logger logger = LoggerFactory.getLogger(NovelService.class);

    private final NovelRepository repository;
    private final ChapterRepository chapterRepository;

    @Autowired
    public NovelService(NovelRepository repository,ChapterRepository chapterRepository){
        this.repository = repository;
        this.chapterRepository = chapterRepository;
    }

    public Page<Novel> find(Pageable pageable){
        return repository.findAll(pageable);
    }

    public void saveNovel(String novelPath) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(novelPath); Scanner sc = new Scanner(inputStream, "UTF-8")) {
            Novel novel = null;
            Chapter chapter = new Chapter();
            StringBuilder chapterContent = new StringBuilder();
            int chapterIndex = 0;
            boolean line0 = true;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                //标题
                if(line0){
                    novel = new Novel();
                    novel.setNovelName(line.replace("《","").replace("》",""));
                    novel = repository.save(novel);
                    logger.info("创建小说: "+novel.getNovelName());
                    line0 = false;
                }
                //正文
                else {
                    if(line.startsWith("正文 ")){
                        line = line.substring(2);
                    }
                    if(line.startsWith("    ")){
                        if(chapterContent.length()>0)chapterContent.append("\n");
                        chapterContent.append(line.replaceFirst(" {4}","       "));
                    }else if(line.startsWith(" ")){
                        //第一章节
                        if(StringUtils.isEmpty(chapter.getChapterName())){
                            chapter.setChapterName(line);
                        }else {
                            chapter.setContent(chapterContent.toString());
                            chapter.setChapterIndex(chapterIndex);
                            chapter.setNovelId(novel.getNovelId());
                            chapterRepository.save(chapter);
                            logger.info("创建小说章节: "+chapter.getChapterName()+" ["+chapterIndex+"]");
                            chapter = new Chapter();
                            chapterContent.delete(0,chapterContent.length());
                            chapter.setChapterName(line);
                            chapterIndex ++;
                        }
                    }
                }
                if(!sc.hasNext()){
                    chapter.setContent(chapterContent.toString());
                    chapter.setChapterIndex(chapterIndex);
                    chapter.setNovelId(novel.getNovelId());
                    chapterRepository.save(chapter);
                    logger.info("创建小说章节: "+chapter.getChapterName()+" ["+chapterIndex+"]");
                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
