package net.wendal.nutzbook.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.huilan.eps.webservice.service.ArticlePage;
import com.huilan.eps.webservice.service.ArticleService;
import com.huilan.eps.webservice.service.LoginProperty;
import com.huilan.eps.webservice.service.MapConvertor;
import com.huilan.eps.webservice.service.MapEntry;
import com.huilan.eps.webservice.service.impl.ArticleServiceImplService;

import net.wendal.nutzbook.bean.User;

@IocBean
@At("/article")
@Ok("json")
@Fail("http:500")
@Filters(@By(type = CheckSession.class, args = { "me", "/" }))
public class ArticleModule {
	@Inject
	protected Dao dao;

	// 文章webservice
	static ArticleServiceImplService service = new ArticleServiceImplService();
	static ArticleService articleService = service.getArticleServiceImplPort();

	/**
	 * 分页查询文章列表
	 * 
	 * @param columnId
	 * @param pageNo
	 * @param pageSize
	 * @param me
	 * @return
	 */
	@At
	public Object getArticleByPage(@Param("columnId") String columnId, @Param("pageNo") int pageNo,
			@Param("pageSize") int pageSize, @Attr("me") int me) {

		NutMap re = new NutMap();
		User user = dao.fetch(User.class, Cnd.where("id", "=", me));
		LoginProperty property = new LoginProperty(user.getName(), user.getPassword()); // 登陆验证

		ArticlePage articlePage = articleService.getArticleByPage(property, columnId, pageNo, pageSize, true, null);
		re.setv("columnId", articlePage.getColumnId()).setv("pageNo", articlePage.getPageNo()).setv("pageSize",
				articlePage.getPageSize()).setv("total", articlePage.getTotalCount()).setv("status", articlePage.getStatus()).setv("statusInfo", articlePage.getStatusInfo());

		//return articlePage;
		List<MapConvertor> articles = articlePage.getResultMapList();
		
		List<HashMap> retList = new ArrayList<HashMap>();
		for (MapConvertor mapConvertor : articles) {
			HashMap<String,Object> kvMap = new HashMap<String,Object>();
			List<MapEntry> entrys = mapConvertor.getEntries();
			for (MapEntry mapEntry : entrys) {
				kvMap.put(mapEntry.getKey(), mapEntry.getValue());
			}
			retList.add(kvMap);
		}
		re.setv("rows", retList);
		return re;
	}
}
