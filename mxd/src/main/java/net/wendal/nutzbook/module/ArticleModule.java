package net.wendal.nutzbook.module;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;
import org.nutz.mvc.upload.FieldMeta;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import com.huilan.eps.webservice.service.Article;
import com.huilan.eps.webservice.service.ArticleFile;
import com.huilan.eps.webservice.service.Article.ResultMap;
import com.huilan.eps.webservice.service.Article.ResultMap.Entry;
import com.huilan.eps.webservice.service.ArticlePage;
import com.huilan.eps.webservice.service.ArticleService;
import com.huilan.eps.webservice.service.LoginProperty;
import com.huilan.eps.webservice.service.MapConvertor;
import com.huilan.eps.webservice.service.MapEntry;
import com.huilan.eps.webservice.service.impl.ArticleServiceImplService;

import net.wendal.nutzbook.bean.User;
import net.wendal.nutzbook.util.Utils;

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
		// User user = dao.fetch(User.class, Cnd.where("id", "=", me));
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

		// User user = dao.fetch(User.class, Cnd.where("id", "=", me));
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
	// @Ok("jsp:jsp.web.show")
	public Object getArticle(@Param("columnId") String columnId, @Param("key") String key, @Attr("me") User me) {

		// User user = dao.fetch(User.class, Cnd.where("id", "=", me));
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
			@Param("title") String title, @Param("content") String content, @Param("entityType") String entityType,
			@Param("entieyUrl") String entieyUrl, @Param("infosummary") String infosummary,
			@Param("filepath") String filepath, @Param("optType") String optType, @Param("key") String key,
			@Param("siteEnname") String siteEnname, @Attr("me") User me) {

		// User user = dao.fetch(User.class, Cnd.where("id", "=", me));
		LoginProperty property = new LoginProperty(me.getName(), me.getPassword()); // 登陆验证
		ResultMap rm = new ResultMap();// 文章表单中字段名及值放到这个map中，字段名要跟表单中字段名大小写一致

		/*
		 * if(entityType.equals("ATTACHMENT")) {//保存附件 //同过上传zip包来添加文章 先不用
		 * System.out.print("-----------------------filepath=="+filepath); DataSource
		 * source = new FileDataSource(new File(filepath)); ArticleFile articleFile =
		 * new ArticleFile(); articleFile.setArticleZip(new DataHandler(source));
		 * Article article = articleService.addArticleByAttachment(property, columnId,
		 * status, articleFile); return article;
		 * 
		 * }
		 */

		Entry EDITOR_ID = new Entry("EDITOR_ID", me.getUserId());
		Entry ENTITY_TYPE = new Entry("ENTITY_TYPE", entityType);
		Entry TITLE = new Entry("TITLE", title);// 标题
		Entry INFOSUMMARY = new Entry("INFOSUMMARY", infosummary);// 摘要
		if (entityType.equals("HTML")) {
			Entry CONTENT = new Entry("CONTENT", content); // 内容
			rm.getEntry().add(CONTENT);
		}
		System.out.println("------------------------------siteEnname== "+siteEnname);
		if (entityType.equals("ATTACHMENT")) {
			/**
			 * 将文件移动到web目录/upload 直接访问xxx/mxd/upload/filename 这就是附件的web地址
			 * 如果我的tomcat和crm在同一个服务器上 直接将文件移动到crm的目录里面 设置文章属性： ARTICLE_DYNIAMIC_URL
			 * /eportal/fileDir/testchild/resource/cms/article/595014/595150/2017102115532425834.zip
			 * TITLE_ATTACHMENT_URL
			 * fileDir/testchild/resource/cms/article/595014/595150/2017102115532425834.zip
			 * ARTICLE_STATIC_URL
			 * /eportal/fileDir/testchild/resource/cms/article/595014/595150/2017102115532425834.zip
			 * 
			 * 经测试 接口会自动在ARTICLE_DYNIAMIC_URL和 ARTICLE_STATIC_URL 路径前加上/eportal/fileDir
			 */

			// 移动文件
			//String ss = .getSession().getServletContext().getRealPath("") ;
			String ss = Mvcs.getServletContext().getRealPath("/");
			System.out.println("------------------------ss===="+ss);
			String cmsBase = "C:/work/easysite-tomcat-6.0.48/webapps/eportal/fileDir" + File.separator + siteEnname
					+ File.separator + "resource" + File.separator + "cms" + File.separator + "article"+File.separator+columnId;

			System.out.println("------------filepath"+filepath);
			String sourcePath = filepath;
			//String houzui=filepath.split(".")[1];
			String prefix=filepath.substring(filepath.lastIndexOf(".")+1); //后缀名
			String newFileName = Utils.getRandomFileName()+"."+prefix;
			String distPath = cmsBase + File.separator;
			Utils.moveTotherFolders(sourcePath, distPath, newFileName);
			
			String fileaaa = "/testchild/resource/cms/article/"+columnId+"/"+newFileName;
			
			Entry ARTICLE_DYNIAMIC_URL = new Entry("ARTICLE_DYNIAMIC_URL", fileaaa);
			Entry TITLE_ATTACHMENT_URL = new Entry("TITLE_ATTACHMENT_URL", "fileDir" + fileaaa);
			Entry ARTICLE_STATIC_URL = new Entry("ARTICLE_STATIC_URL", fileaaa);
			rm.getEntry().add(ARTICLE_DYNIAMIC_URL);
			rm.getEntry().add(TITLE_ATTACHMENT_URL);
			rm.getEntry().add(ARTICLE_STATIC_URL);

		}
		if (entityType.equals("URL")) {
			Entry ENTITY_URL = new Entry("ENTITY_URL", entieyUrl); // 内容
			rm.getEntry().add(ENTITY_URL);
		}
		// rm.getEntry().add(PAGE_KEY);
		// rm.getEntry().add(FORM_KEY);
		rm.getEntry().add(EDITOR_ID);
		rm.getEntry().add(ENTITY_TYPE);
		rm.getEntry().add(TITLE);
		rm.getEntry().add(INFOSUMMARY);

		Article article = new Article(rm, "", "");
		Article art = null;
		if ("add".equals(optType)) {
			art = articleService.addArticle(property, columnId, status, article);
		} else if ("update".equals(optType)) {
			art = articleService.updateArticle(property, columnId, status, article, "KEY", key);
		}
		System.out.println("-----------------------------------------" + art.getStatus());
		return art;

	}

	@At("/upload")
	@AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
	public Object uploadFile(@Param("fileToUpload") TempFile tf, @Attr("me") User me) {
		File f = tf.getFile(); // 这个是保存的临时文件
		FieldMeta meta = tf.getMeta(); // 这个原本的文件信息
		String oldName = meta.getFileLocalName();
		System.out.println(tf.getFile().getAbsolutePath() + " " + "&" + tf.getFile());
		System.out.println("----------------------------------path==" + oldName);

		return tf.getFile().getAbsolutePath();

	}
}
