package net.wendal.nutzbook.module;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.huilan.eps.webservice.service.LoginProperty;
import com.huilan.eps.webservice.service.PageWSService;
import com.huilan.eps.webservice.service.SiteInfos;
import com.huilan.eps.webservice.service.SiteWSService;
import com.huilan.eps.webservice.service.UserMgrSite;
import com.huilan.eps.webservice.service.UserWSService;
import com.huilan.eps.webservice.service.VoCommonPage;
import com.huilan.eps.webservice.service.impl.PageWSServiceImplService;
import com.huilan.eps.webservice.service.impl.SiteWSServiceImplService;
import com.huilan.eps.webservice.service.impl.UserWSServiceImplService;

import net.wendal.nutzbook.bean.ColumnMenu;
import net.wendal.nutzbook.bean.SiteMenu;
import net.wendal.nutzbook.bean.User;


@IocBean
@At("/service")
@Ok("json")
@Fail("http:500")
@Filters(@By(type=CheckSession.class, args={"me", "/"}))
public class WebServiceModule {
	@Inject
    protected Dao dao;
	
	//获取站点树服务
	static SiteWSServiceImplService service=new SiteWSServiceImplService();
	static SiteWSService siteService=service.getSiteWSServiceImplPort();
	//获取栏目树服务
	static PageWSServiceImplService pageService=new PageWSServiceImplService();
	static PageWSService pageWSService=pageService.getPageWSServiceImplPort();
	//登陆服务
	static UserWSServiceImplService userService=new UserWSServiceImplService();
	static UserWSService userLoginService=userService.getUserWSServiceImplPort();
	
	@At("/")
    @Ok("jsp:jsp.web.index")
    public void index() {
		
    }
	
	/**
	 * 获取站点树菜单
	 * @param me
	 * @return
	 */
	@At
    public Object userMgrSite(@Attr("me")int me) {
		 User user = dao.fetch(User.class, Cnd.where("id", "=", me));
		 
		   NutMap re = new NutMap();
		    
		   LoginProperty property = new LoginProperty(user.getName(),user.getPassword()); //登陆验证
			SiteInfos siteInfos = siteService.getSiteByUser(property, "-1");
			
			List<UserMgrSite> ums =  siteInfos.getSiteList();
			// 最后的结果
			List<SiteMenu> menuList  = new ArrayList<SiteMenu>();
			// 先找到所有的一级站点菜单
			for (UserMgrSite siteMenu : ums) {
				//if(siteMenu.getActive().equals("1")) {//正常使用的
					SiteMenu sm = new SiteMenu();
					sm.setId(siteMenu.getId());
					sm.setParentId("-1");
					sm.setText("站点-"+siteMenu.getSiteName());
					sm.setLeaf(siteMenu.getLeaf());
					sm.setUserMgrSite(siteMenu);
					menuList.add(sm);
				//}
				
			}
			// 为一级菜单设置子菜单，getChild是递归调用的
			 for (SiteMenu menu : menuList) {
				 if(menu.getLeaf().equals("0")) {//不是叶子 有子节点
					 menu.setChildren(getChild(menu.getId(),user));
				 }
			  }
			 
			/* Map<String,Object> jsonMap = new HashMap<String,Object>();
			 jsonMap.put("menu", menuList);*/
		 
		// return re.setv("ok", true).setv("siteInfos", siteInfos);
			 //return re.setv("menu", menuList);
			 return menuList;
    }
	
	/**
	 * 递归查找子菜单
	 * 
	 * @param id
	 *            当前菜单id
	 * @param rootMenu
	 *            要查找的列表
	 * @return
	 */
	private List<SiteMenu> getChild(String parentId,User user) {
		
		/* SiteWSServiceImplService service=new SiteWSServiceImplService();
			SiteWSService siteService=service.getSiteWSServiceImplPort();*/
			LoginProperty property = new LoginProperty(user.getName(),user.getPassword()); //登陆验证
			
			SiteInfos siteInfos = siteService.getSiteByUser(property, parentId);
			List<UserMgrSite> ums =  siteInfos.getSiteList();
			
		
		// 子菜单
	    List<SiteMenu> childList = new ArrayList<SiteMenu>();
	    
	    for (UserMgrSite siteMenu : ums) {
	    	//if(siteMenu.getActive().equals("1")) {
	    		SiteMenu sm = new SiteMenu();
				sm.setId(siteMenu.getId());
				sm.setParentId(parentId);
				sm.setText(siteMenu.getSiteName());
				sm.setLeaf(siteMenu.getLeaf());
				sm.setUserMgrSite(siteMenu);
				childList.add(sm);
	    	//}
			
		}
	 // 把子菜单的子菜单再循环一遍
	    for (SiteMenu menu : childList) {
			 if(menu.getLeaf().equals("0")) {//不是叶子 有子节点
				 menu.setChildren(getChild(menu.getId(),user));
			 }
		       
		    }
	 // 递归退出条件
	    if (childList.size() == 0) {
	        return null;
	    }
	    return childList;
	    
	}
	
	/**
	 * 通过web service 验证用户名 获取 cms 用户id
	 * @param name
	 * @param pass
	 * @return  用户id;
	 */
	protected String getUserId(User user ) {
		 /*LoginProperty property = new LoginProperty(user.getName(),user.getPassword()); //登陆验证
		 UserInfos  userinfos=   userLoginService.login(property, param);
		String userid =  userinfos.getUserInfo().getId();*/
		   return user.getId()+"";
	}
	
	//-------------------------------------
	/**
	 * 获取站点下栏目树
	 * parentId: 父站点编号
	 * siteId: 站点id
	 */
	
	@At
	public Object getPageTreeNode(@Param("parentId") String parentId,@Param("siteId") String siteId,@Attr("me")int me) {
		
		   User user = dao.fetch(User.class, Cnd.where("id", "=", me));
		  
		   LoginProperty property = new LoginProperty(user.getName(),user.getPassword()); //登陆验证
		   String userId = getUserId(user);
		   //pageWSService.getPageTreeNode(property, parentId, siteId, user.getId());
		   List<VoCommonPage> voCommonPage=   pageWSService.getPageTreeNode(property, parentId, siteId, userId);
		System.out.println("-----------------------------"+voCommonPage.size());
		
		       // 最后的结果
					List<ColumnMenu> menuList  = new ArrayList<ColumnMenu>();
					// 先找到所有的一级站点菜单
					for (VoCommonPage voPage : voCommonPage) {
						ColumnMenu sm = new ColumnMenu();
							sm.setId(voPage.getId());
							sm.setParentId("-1");
							sm.setText("栏目-"+voPage.getText());
							sm.setLeaf(voPage.isLeaf());
							sm.setVoCommonPage(voPage);
							menuList.add(sm);
						
					}
					
					// 为一级菜单设置子菜单，getChild是递归调用的
					 for (ColumnMenu menu : menuList) {
						 if(!menu.isLeaf()) {//不是叶子 有子节点
							 menu.setChildren(getColumnChild(menu.getId(),siteId,user));
						 }
					  }
					 return menuList;
	}
	
	/**
	 * 递归查找子菜单
	 * 
	 * @param id
	 *            当前菜单id
	 * @param rootMenu
	 *            要查找的列表
	 * @return
	 */
	private List<ColumnMenu> getColumnChild(String parentId,String siteId, User user) {
		
			LoginProperty property = new LoginProperty(user.getName(),user.getPassword()); //登陆验证
			String userId = getUserId(user);
			   //pageWSService.getPageTreeNode(property, parentId, siteId, user.getId());
	       List<VoCommonPage> voCommonPage=   pageWSService.getPageTreeNode(property, parentId, siteId, userId);
			
		
		// 子菜单
	    List<ColumnMenu> childList = new ArrayList<ColumnMenu>();
	    
	    for (VoCommonPage voPage : voCommonPage) {
			ColumnMenu sm = new ColumnMenu();
				sm.setId(voPage.getId());
				sm.setParentId(parentId);
				sm.setText("栏目-"+voPage.getText());
				sm.setLeaf(voPage.isLeaf());
				sm.setVoCommonPage(voPage);
				childList.add(sm);
			
		}
	    
	 // 把子菜单的子菜单再循环一遍
	    for (ColumnMenu menu : childList) {
			 if(!menu.isLeaf()) {//不是叶子 有子节点
				 menu.setChildren(getColumnChild(menu.getId(),siteId,user));
			 }
		       
		    }
	 // 递归退出条件
	    if (childList.size() == 0) {
	        return null;
	    }
	    return childList;
	    
	}
	
}
