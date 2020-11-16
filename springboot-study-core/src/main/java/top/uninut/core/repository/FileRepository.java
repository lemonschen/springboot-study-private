package top.uninut.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.uninut.core.entity.File;

public interface FileRepository extends JpaRepository<File,Long>, JpaSpecificationExecutor<File> {
}
