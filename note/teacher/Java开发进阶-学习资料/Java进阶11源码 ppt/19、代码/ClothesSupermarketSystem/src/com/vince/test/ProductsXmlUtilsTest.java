package com.vince.test;

import com.vince.bean.Clothes;
import com.vince.utils.ProductsXmlUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vince on 2017/7/20.
 */
public class ProductsXmlUtilsTest {

    @Test
    public void test(){
        List<Clothes> clothes = ProductsXmlUtils.parserProductFormXml();
        System.out.println(Arrays.toString(clothes.toArray()));
    }
}
