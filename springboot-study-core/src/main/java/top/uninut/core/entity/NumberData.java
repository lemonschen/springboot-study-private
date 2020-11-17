package top.uninut.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class NumberData {
    private int i;
    @JSONField(ordinal = 1)
    private short s;
    @JSONField(ordinal = 2)
    private long l;
    @JSONField(ordinal = 3)
    private float f;
    @JSONField(ordinal = 4)
    private double d;
}
