package xyz.moss.designpatterns;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * 将启动完整的Spring应用程序上下文，但没有服务器。
 * @author zhangshipeng
 * @date 2021/1/26
 */
@SpringBootTest
@AutoConfigureMockMvc
class OkControllerTest2 {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void ok() throws Exception {
        this.mockMvc.perform(get("/ok")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("ok")));
    }
}