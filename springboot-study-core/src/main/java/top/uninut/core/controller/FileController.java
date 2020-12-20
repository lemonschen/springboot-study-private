package top.uninut.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import top.uninut.core.entity.File;
import top.uninut.core.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService service;

    @Autowired
    public FileController(FileService service) {
        this.service = service;
    }

    @RequestMapping("/test")
    public void test(){

    }

    @RequestMapping("/testException")
    public void testException(){
        throw new RuntimeException("你错了！！！");
    }

    @PostMapping
    public void save(@RequestBody File file) {
        service.save(file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @GetMapping("/all")
    public Page<File> findAll(
            @RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam(required = false) String fileName,
            @RequestParam(required = false) String sortColumn, @RequestParam(required = false) String sortDirection
    ) {
        return service.findAll(pageIndex,pageSize,fileName,sortColumn,sortDirection);
    }
}
