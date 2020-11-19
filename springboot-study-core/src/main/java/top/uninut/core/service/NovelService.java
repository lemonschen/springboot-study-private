package top.uninut.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.uninut.core.entity.Novel;
import top.uninut.core.repository.NovelRepository;

@Service
public class NovelService {

    private final NovelRepository repository;

    @Autowired
    public NovelService(NovelRepository repository){
        this.repository = repository;
    }

    public Page<Novel> find(Pageable pageable){
        return repository.findAll(pageable);
    }
}
