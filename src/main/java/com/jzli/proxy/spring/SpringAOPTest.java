package com.jzli.proxy.spring;

import com.jzli.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//单元测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class SpringAOPTest {

    @Autowired
    private IPersonService personService;

    @Test
    public void testAction() {
        personService.action("hello world.");
    }
}