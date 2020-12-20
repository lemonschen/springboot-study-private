package top.uninut.core.controller;

import org.springframework.web.bind.annotation.*;
import top.uninut.core.entity.NumberData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/number")
public class NumberController {

    @GetMapping
    public List<NumberData> find(){
        List<NumberData> dataList = new ArrayList<>();
        NumberData max = new NumberData();
        max.setS(Short.MAX_VALUE);
        max.setI(Integer.MAX_VALUE);
        max.setL(Long.MAX_VALUE);
        max.setF(Float.MAX_VALUE);
        max.setD(Double.MAX_VALUE);
        dataList.add(max);

        NumberData min = new NumberData();
        min.setS(Short.MIN_VALUE);
        min.setI(Integer.MIN_VALUE);
        min.setL(Long.MIN_VALUE);
        min.setF(Float.MIN_VALUE);
        min.setD(Double.MIN_VALUE);
        dataList.add(min);


        NumberData cus = new NumberData();
        cus.setS((short) 123);
        cus.setI(1000000000);
        cus.setL(123456789123456789L);
        cus.setF(123456789123456789.123456789f);
        cus.setD(123456789123456789.123456789);
        dataList.add(cus);

        return dataList;
    }

    @PostMapping
    public void save(@RequestBody NumberData data){
        System.out.println("==============");
        System.out.println(data.getS());
        System.out.println(data.getI());
        System.out.println(data.getL());
        System.out.println(data.getF());
        System.out.println(data.getD());
        System.out.println("--------------");
        System.out.println(new DecimalFormat("0").format(data.getS()));
        System.out.println(new DecimalFormat("0").format(data.getI()));
        System.out.println(new DecimalFormat("0").format(data.getL()));
        System.out.println(new DecimalFormat("0.00").format(data.getF()));
        System.out.println(new DecimalFormat("0.00").format(data.getD()));
        System.out.println("==============");
    }

}
