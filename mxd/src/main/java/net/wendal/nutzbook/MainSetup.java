package net.wendal.nutzbook;

import java.util.Date;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.mvc.view.UTF8JsonView;

import net.wendal.nutzbook.bean.User;

public class MainSetup implements Setup{

	public void destroy(NutConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	// 特别留意一下,是init方法,不是destroy方法!!!!!
	public void init(NutConfig nc) {
		
		UTF8JsonView.CT = "text/plain";//防止在ie中返回json数据显示下载
		
        Ioc ioc = nc.getIoc();
        Dao dao = ioc.get(Dao.class);
        // 如果没有createTablesInPackage,请检查nutz版本
        Daos.createTablesInPackage(dao, "net.wendal.nutzbook", false);
        
     // 初始化默认根用户
        if (dao.count(User.class) == 0) {
            User user = new User();
            user.setName("admin");
            user.setPassword("admin");
            user.setUserId("1");
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            dao.insert(user);
        }
    }

}
