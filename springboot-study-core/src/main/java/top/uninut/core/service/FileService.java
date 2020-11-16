package top.uninut.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.uninut.core.entity.File;
import top.uninut.core.repository.FileRepository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private final FileRepository repository;

    @Autowired
    public FileService(FileRepository repository){
        this.repository = repository;
    }

    public void save(File file){
        repository.save(file);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Page<File> findAll(int page, int pageSize, String fileName, String sortColumn, String sortDirection){
        List<Order> orderList = new ArrayList<>();
        if(!StringUtils.isEmpty(sortColumn) && !StringUtils.isEmpty(sortColumn.trim()))
            orderList.add(new Order(Sort.Direction.valueOf(sortDirection),sortColumn));
        else orderList.add(new Order(Sort.Direction.ASC,"fileId"));
        Sort sort = Sort.by(orderList);
        Pageable pageable = PageRequest.of(page - 1, pageSize, sort);
        Specification<File> spec = (root,criteriaQuery,criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            if(!StringUtils.isEmpty(fileName) && !StringUtils.isEmpty(fileName.trim()))
                predicates.add(criteriaBuilder.like(root.get("fileName"),fileName+"%"));
            return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        return repository.findAll(spec,pageable);
    }
}
