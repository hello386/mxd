package net.wendal.nutzbook.module;

import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.filter.CheckSession;

import com.huilan.eps.webservice.service.LoginProperty;
import com.huilan.eps.webservice.service.SiteInfos;
import com.huilan.eps.webservice.service.SiteWSService;
import com.huilan.eps.webservice.service.UserMgrSite;
import com.huilan.eps.webservice.service.impl.SiteWSServiceImplService;


@IocBean
@At("/service")
@Ok("json")
@Fail("http:500")
@Filters(@By(type=CheckSession.class, args={"me", "/"}))
public class WebServiceModule {

	@At
    public Object test() {
		 NutMap re = new NutMap();
		    SiteWSServiceImplService service=new SiteWSServiceImplService();
			SiteWSService siteService=service.getSiteWSServiceImplPort();
			LoginProperty property = new LoginProperty("admin","admin"); //登陆验证
			SiteInfos siteInfos = siteService.getSiteByUser(property, "-1");
			System.out.println("----------getStatusInfo---"+siteInfos.getStatusInfo()+"--- getStatus:"+siteInfos.getStatus());
			List<UserMgrSite> ums =  siteInfos.getSiteList();
			
		 
		 return re.setv("ok", true).setv("UserMgrSite", ums);
    }
}
