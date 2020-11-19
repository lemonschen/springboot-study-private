package top.uninut.core.entity;

import javax.persistence.*;

@Entity
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
}
