package top.uninut.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.uninut.core.common.RestResult;
import top.uninut.core.entity.File;
import top.uninut.core.service.FileService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService service;

    @Autowired
    public FileController(FileService service) {
        this.service = service;
    }

    @PostMapping
    public RestResult<?> save(@RequestBody File file) {
        service.save(file);
        return new RestResult<>().success();
    }

    @DeleteMapping("/{id}")
    public RestResult<?> delete(@PathVariable long id) {
        service.delete(id);
        return new RestResult<>().success();
    }

    @GetMapping("/all")
    public RestResult<File> findAll(
            @RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam(required = false) String fileName,
            @RequestParam(required = false) String sortColumn, @RequestParam(required = false) String sortDirection
    ) {
        return new RestResult<File>().pageSuccess(service.findAll(pageIndex,pageSize,fileName,sortColumn,sortDirection));
    }

    public static void main(String[] args) {
        Map map = new HashMap();
    }
}
