package top.uninut.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.uninut.core.entity.Novel;

public interface NovelRepository extends JpaRepository<Novel,Integer> {
}
