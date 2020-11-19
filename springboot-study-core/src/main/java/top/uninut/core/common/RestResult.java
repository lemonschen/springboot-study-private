package top.uninut.core.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResult<T> {
    private int code;
    @JSONField(ordinal = 1,serialzeFeatures = SerializerFeature.WriteMapNullValue)
    private String msg;
    @JSONField(ordinal = 2,serialzeFeatures = SerializerFeature.WriteMapNullValue)
    private Object data;


    public RestResult<T> success(){
        this.code = 200;
        this.msg = "请求成功";
        return this;
    }


    public RestResult<T> success(Object data) {
        this.code = 200;
        this.msg = "请求成功";
        this.data = data;
        return this;
    }

    public RestResult<T> pageSuccess(Page<T> page){
        this.code = 200;
        this.msg = "请求成功";
        this.data = new PageData(
                page.getContent(),
                page.getPageable().getPageNumber(),
                page.getPageable().getPageSize(),
                page.getTotalPages(),
                page.getTotalElements()
        );
        return this;
    }
}
