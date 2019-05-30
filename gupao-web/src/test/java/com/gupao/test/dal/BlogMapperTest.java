package com.gupao.test.dal;

import com.gupao.dal.dao.Blog;
import com.gupao.dal.dao.BlogMapper;
import com.gupao.dal.dao.Posts;
import com.gupao.dal.resultmap.BlogPostsResultMap;
import com.gupao.dal.resultmap.BlogResultMap;
import com.gupao.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by James
 * on 16/8/16.
 * Description:
 */
public class BlogMapperTest extends BaseTest {
    private final static Logger log = LoggerFactory.getLogger(BlogMapperTest.class);
    @Autowired
    private BlogMapper mapper;

    @Test
    public void selectBlogAuthor() {//one to one 嵌套结果
        BlogResultMap resultMap = mapper.selectBlogAuthor(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectByBlogId() {
        List<Posts> resultMap = mapper.selectByBlogId(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectBlogPosts嵌套结果() {//one to many 嵌套结果
        BlogPostsResultMap resultMap = mapper.selectBlogPosts2(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectBlogPosts嵌套查询() throws InterruptedException {//one to many 嵌套查询
        BlogPostsResultMap resultMap = mapper.selectBlogPosts(1);
        System.out.println(resultMap.getName());
        Thread.sleep(5000);
        System.out.println(resultMap.getPosts().get(0).getBlogId());
    }

    @Test
    public void selectByAuthorId嵌套查询() {//one to one 嵌套查询
        BlogResultMap resultMap = mapper.selectBlogAuthor(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectByAuthorId2() {//one to one 嵌套结果
        BlogResultMap resultMap = mapper.selectBlogAuthor2(1);
        System.out.println(resultMap);
    }

}
