package xyz.moss.designpatterns;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import xyz.moss.designpatterns.demo.UserDao;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @see @WebMvcTest
 * @author zhangshipeng
 * @date 2021/1/26
 */
@WebMvcTest
class OkControllerTest4 {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserDao userDao;

    @Test
    void ok() throws Exception {
        when(userDao.getUser()).thenReturn("z");
        this.mockMvc.perform(get("/user")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("z")));
    }
}