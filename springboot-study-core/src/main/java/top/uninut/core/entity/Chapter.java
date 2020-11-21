package top.uninut.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chapter")
public class Chapter {

    @Id
    @Column(name = "chapter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chapterId;

    @Basic
    @Column(name = "novel_id")
    private int novelId;

    @Basic
    @Column(name = "chapter_index")
    private int chapterIndex;

    @Basic
    @Column(name = "chapter_name")
    private String chapterName;

    @Basic
    @Lob
    @Column(length = 100000)
    private String content;

    public Chapter(long chapterId,int novelId,int chapterIndex,String chapterName){
        this.chapterId = chapterId;
        this.novelId = novelId;
        this.chapterIndex = chapterIndex;
        this.chapterName = chapterName;
    }
}
