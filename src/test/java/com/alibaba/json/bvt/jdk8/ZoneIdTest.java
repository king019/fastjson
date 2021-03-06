package com.alibaba.json.bvt.jdk8;

import java.time.ZoneId;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.fastjson.JSON;

public class ZoneIdTest extends TestCase {

    public void test_for_issue() throws Exception {
        VO vo = new VO();
        vo.setDate(ZoneId.of("Europe/Paris"));
        
        String text = JSON.toJSONString(vo);
        System.out.println(text);
        
        VO vo1 = JSON.parseObject(text, VO.class);
        
        Assert.assertEquals(vo.getDate(), vo1.getDate());
    }

    public static class VO {

        private ZoneId date;

        public ZoneId getDate() {
            return date;
        }

        public void setDate(ZoneId date) {
            this.date = date;
        }

    }
}
