package guguanjia;

import com.chen.GuguanjiaApplication;
import com.chen.dao.AppVersionMapper;
import com.chen.entity.AppVersion;
import com.chen.service.AppVersionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.java2d.pipe.ValidatePipe;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest(classes = GuguanjiaApplication.class)
class GuguanjiaApplicationTests {

    @Resource
    DataSource dataSource;

    @Autowired
    AppVersionService<AppVersion,Long> appVersionService;
    @Resource
    AppVersionMapper mapper;
    @Test
    void contextLoads() {
    }

    @Test
    void test() throws SQLException {
        System.out.println(dataSource.getConnection());
        System.out.println(dataSource);
    }

    @Test
    void test1(){
        List<AppVersion> appVersions = mapper.selectAll();
        for (AppVersion appVersion : appVersions) {
            System.out.println(appVersion);
        }
    }
    @Test
    void test2(){
        AppVersion appVersion = mapper.selectByPrimaryKey((long) 14);
        appVersion.setSize(null);
//        int i = mapper.updateByPrimaryKey(appVersion);
        int i = mapper.updateByPrimaryKeySelective(appVersion);
        System.out.println(i);
    }
}
