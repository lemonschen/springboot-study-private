package top.uninut.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "novel")
public class Novel {
    @Id
    @Column(name = "novel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int novelId;

    @Basic
    @Column(name = "novel_name")
    private String novelName;

    @Basic
    @Column(name = "author")
    private String author;

    @Basic
    @Column(name = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();

    @Basic
    @Column(name = "cover_image")
    private String coverImage;
}
