package controller;

import model.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import service.SpittleService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by admin on 2017/5/18.
 */
public class TestSpittleController {

    @Test
    public void testSpittle() throws Exception {
        List<Spittle> list = createSpittleList(20);
        SpittleService service = Mockito.mock(SpittleService.class);
        Mockito.when(service.findSpittle(Long.MAX_VALUE, 20))
                .thenReturn(list);
        SpittleController controller = new SpittleController(service);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittle.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittle/showTwenty"))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList", hasItems(list.toArray())));
    }

    @Test
    public void testSpittlesByPage() throws Exception {
        long top = 2000;
        int count = 20;
        List<Spittle> list = createSpittleList(count);
        SpittleService service = Mockito.mock(SpittleService.class);
        Mockito.when(service.findSpittle(top, count))
                .thenReturn(list);
        SpittleController controller = new SpittleController(service);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittle.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittle?top=" + top + "&count=" + count))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList", hasItems(list.toArray())));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Spittle("msg" + i, new Date()));
        }
        return list;
    }
}
