package top.uninut.core.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageData {
    private Object result;
    @JSONField(ordinal = 1)
    private int pageIndex;
    @JSONField(ordinal = 2)
    private int pageSizes;
    @JSONField(ordinal = 3)
    private int totalPages;
    @JSONField(ordinal = 4)
    private long totalSizes;
}
