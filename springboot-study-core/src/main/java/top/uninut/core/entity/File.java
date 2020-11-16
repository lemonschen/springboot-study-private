package top.uninut.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table
public class File {
  @Id
  @Column(name = "file_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private long fileId;
  @Basic
  @Column(name = "file_name")
  private String fileName;
  @Basic
  @Column(name = "file_path")
  private String filePath;
  @Basic
  @Column(name = "file_size")
  private long fileSize;
  @Basic
  @Column(name = "file_type")
  private long fileType;
  @Basic
  @Column(name = "create_time")
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;
}
