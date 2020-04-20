package com.example.weatherking.comment.controller;

import com.example.weatherking.BaseBeanTest;
import com.example.weatherking.comment.data.Comment;
import com.example.weatherking.comment.service.CommentService;
import com.example.weatherking.util.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class CommentControllerTest extends BaseBeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CommentService commentService;

    private MockMvc mockMvc;

    @BeforeEach
    public void beforeEach() {
        mockMvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) applicationContext).build();
    }

    @Test
    public void testCreateComment() throws Exception {
        Comment comment = commentService.createComment("TEST");
        long commentId = comment.getCommentId();

        String testMessage = "TESTTEST~! NEW!";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/comments/").param("message", testMessage))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assertions.assertNotNull(result);

        // DB 검증
        Assertions.assertEquals(commentId + 1, commentService.getCommentLastOne().getCommentId());
    }

    @Test
    public void testGetComment() throws Exception {
        String testMessage = "TESTTEST~!";
        Comment comment = commentService.createComment(testMessage);
        long commentId = comment.getCommentId();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/comments/" + commentId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assertions.assertNotNull(result);

        Comment commentDeserialized = commentService.deserializeComment(result.getResponse().getContentAsString());
        Assertions.assertNotNull(commentDeserialized);
        Assertions.assertEquals(testMessage, StringUtil.trimDoubleQuotes(commentDeserialized.getMessage())); // TODO : 헐... RESULT 뭔가로 감싸야하나...
        logger.info("[TEST_REQUESET] {}", commentDeserialized.toString());
    }

    @Test
    public void testGetCommentList() throws Exception {
        List<Long> expectedCommentIdList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String testMessage = "TESTTEST~!";
            Comment comment = commentService.createComment(testMessage);
            expectedCommentIdList.add(comment.getCommentId());
        }

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/comments/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assertions.assertNotNull(result);

        Comment commentDeserialized = commentService.deserializeComment(result.getRequest().getContentAsString());
        Assertions.assertNotNull(commentDeserialized);
        logger.info("[TEST_REQUESET] {}", commentDeserialized.toString());
    }

    @Test
    public void testUpdComment() throws Exception {
        String testMessage = "TESTTEST~!";
        Comment comment = commentService.createComment(testMessage);
        long commentId = comment.getCommentId();

        String expectedMessage = "ASDF";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/comments/" + commentId).param("message", expectedMessage))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assertions.assertNotNull(result);

        Comment commentDeserialized = commentService.deserializeComment(result.getResponse().getContentAsString());
        Assertions.assertNotNull(commentDeserialized);
        Assertions.assertEquals(expectedMessage, StringUtil.trimDoubleQuotes(commentDeserialized.getMessage())); // TODO : 헐... RESULT 뭔가로 감싸야하나...
        logger.info("[TEST_REQUESET] {}", commentDeserialized.toString());
    }

    @Test
    public void testDelComment() throws Exception {
        String testMessage = "TESTTEST~!";
        Comment comment = commentService.createComment(testMessage);
        long commentId = comment.getCommentId();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/comments/" + commentId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assertions.assertNotNull(result);
        logger.info("[TEST_REQUESET] {}", result.getResponse().getContentAsString());

        // DB 검증
        Assertions.assertNull(commentService.getCommentForUpdate(commentId));
    }
}
