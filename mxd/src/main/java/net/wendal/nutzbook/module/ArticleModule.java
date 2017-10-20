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

import com.huilan.eps.webservice.service.Article;
import com.huilan.eps.webservice.service.ArticlePage;
import com.huilan.eps.webservice.service.ArticleService;
import com.huilan.eps.webservice.service.LoginProperty;
import com.huilan.eps.webservice.service.MapConvertor;
import com.huilan.eps.webservice.service.MapEntry;
import com.huilan.eps.webservice.service.Article.ResultMap;
import com.huilan.eps.webservice.service.Article.ResultMap.Entry;
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
	public Object getArticleByPage(@Param("columnId") String columnId, @Param("page") int pageNo,
			@Param("rows") int pageSize, @Attr("me") User me) {

		NutMap re = new NutMap();
		//User user = dao.fetch(User.class, Cnd.where("id", "=", me));
		LoginProperty property = new LoginProperty(me.getName(), me.getPassword()); // 登陆验证

		ArticlePage articlePage = articleService.getArticleByPage(property, columnId, pageNo, pageSize, true, null);
		re.setv("columnId", articlePage.getColumnId()).setv("pageNo", articlePage.getPageNo())
				.setv("pageSize", articlePage.getPageSize()).setv("total", articlePage.getTotalCount())
				.setv("status", articlePage.getStatus()).setv("statusInfo", articlePage.getStatusInfo());

		// return articlePage;
		List<MapConvertor> articles = articlePage.getResultMapList();

		List<HashMap> retList = new ArrayList<HashMap>();
		for (MapConvertor mapConvertor : articles) {
			HashMap<String, Object> kvMap = new HashMap<String, Object>();
			List<MapEntry> entrys = mapConvertor.getEntries();
			for (MapEntry mapEntry : entrys) {
				kvMap.put(mapEntry.getKey(), mapEntry.getValue());
			}
			retList.add(kvMap);
		}
		re.setv("rows", retList);
		return re;
	}

	/**
	 * 删除一篇文章
	 * 
	 * @param columnId
	 * @param key
	 * @param me
	 * @return
	 */
	@At
	public Object delArticle(@Param("columnId") String columnId, @Param("key") String key, @Attr("me") User me) {

		//User user = dao.fetch(User.class, Cnd.where("id", "=", me));
		LoginProperty property = new LoginProperty(me.getName(), me.getPassword()); // 登陆验证
		ResultMap rm = new ResultMap();// 文章表单中字段名及值放到这个map中，字段名要跟表单中字段名大小写一致
		Article article = new Article(rm, "", "");
		Article art = articleService.deleteArticle(property, columnId, article, "KEY", key);

		return art;

	}

	/*
	 * 获取一篇文章
	 */
	@At
	@Ok("jsp:jsp.web.show")
	public Object getArticle(@Param("columnId") String columnId, @Param("key") String key, @Attr("me") User me) {

		//User user = dao.fetch(User.class, Cnd.where("id", "=", me));
		LoginProperty property = new LoginProperty(me.getName(), me.getPassword()); // 登陆验证
		ResultMap rm = new ResultMap();// 文章表单中字段名及值放到这个map中，字段名要跟表单中字段名大小写一致

		Article art = articleService.getArticleByKey(property, key, columnId);
		HashMap<String, Object> kvMap = new HashMap<String, Object>();
		rm = art.getResultMap();
		List<Entry> ents = rm.getEntry();
		for (Entry entry : ents) {
			kvMap.put(entry.getKey(), entry.getValue());
		}
		NutMap re = new NutMap();
		re.setv("attachment", art.getAttachment()).setv("key", art.getKey()).setv("status", art.getStatus())
				.setv("statusInfo", art.getStatusInfo()).setv("article", kvMap);

		return re;

	}

	@At
	public Object addArticle(@Param("columnId") String columnId, @Param("status") String status,
			@Param("title") String title, @Param("content") String content, 
			@Param("entityType") String entityType,@Param("entieyUrl") String entieyUrl, @Attr("me") User me) {
		//User user = dao.fetch(User.class, Cnd.where("id", "=", me));
		LoginProperty property = new LoginProperty(me.getName(), me.getPassword()); // 登陆验证
		ResultMap rm = new ResultMap();//文章表单中字段名及值放到这个map中，字段名要跟表单中字段名大小写一致
		
		Entry EDITOR_ID = new Entry("EDITOR_ID",me.getUserId());
		Entry ENTITY_TYPE = new Entry("ENTITY_TYPE",entityType);
		Entry TITLE = new Entry("TITLE", title);//标题
		if(entityType.equals("HTML")) {
			Entry CONTENT = new Entry("CONTENT", content);	//内容
			rm.getEntry().add(CONTENT);
		}
		if(entityType.equals("URL")) {
			Entry ENTITY_URL = new Entry("ENTITY_URL", entieyUrl);	//内容
			rm.getEntry().add(ENTITY_URL);
		}
		
		//rm.getEntry().add(PAGE_KEY);
		//rm.getEntry().add(FORM_KEY);
		rm.getEntry().add(EDITOR_ID);
		rm.getEntry().add(ENTITY_TYPE);
		rm.getEntry().add(TITLE);
		
		Article article = new Article(rm, "", "");
		Article art = articleService.addArticle(property, columnId, status, article);
		return art;
	}
}
