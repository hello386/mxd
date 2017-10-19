
package com.huilan.eps.webservice.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.huilan.eps.webservice.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    
    private final static QName _AddArticle_QNAME = new QName("http://service.webservice.eps.huilan.com/", "addArticle");
    private final static QName _AddArticleByAttachment_QNAME = new QName("http://service.webservice.eps.huilan.com/", "addArticleByAttachment");
    private final static QName _AddArticleByAttachmentResponse_QNAME = new QName("http://service.webservice.eps.huilan.com/", "addArticleByAttachmentResponse");
    private final static QName _AddArticleResponse_QNAME = new QName("http://service.webservice.eps.huilan.com/", "addArticleResponse");
    private final static QName _DeleteArticle_QNAME = new QName("http://service.webservice.eps.huilan.com/", "deleteArticle");
    private final static QName _DeleteArticleResponse_QNAME = new QName("http://service.webservice.eps.huilan.com/", "deleteArticleResponse");
    private final static QName _GetArticleByKey_QNAME = new QName("http://service.webservice.eps.huilan.com/", "getArticleByKey");
    private final static QName _GetArticleByKeyResponse_QNAME = new QName("http://service.webservice.eps.huilan.com/", "getArticleByKeyResponse");
    private final static QName _GetArticleByPage_QNAME = new QName("http://service.webservice.eps.huilan.com/", "getArticleByPage");
    private final static QName _GetArticleByPageResponse_QNAME = new QName("http://service.webservice.eps.huilan.com/", "getArticleByPageResponse");
    private final static QName _UpdateArticle_QNAME = new QName("http://service.webservice.eps.huilan.com/", "updateArticle");
    private final static QName _UpdateArticleByAttachment_QNAME = new QName("http://service.webservice.eps.huilan.com/", "updateArticleByAttachment");
    private final static QName _UpdateArticleByAttachmentResponse_QNAME = new QName("http://service.webservice.eps.huilan.com/", "updateArticleByAttachmentResponse");
    private final static QName _UpdateArticleResponse_QNAME = new QName("http://service.webservice.eps.huilan.com/", "updateArticleResponse");

    private final static QName _GetSiteByUser_QNAME = new QName("http://service.webservice.eps.huilan.com/", "getSiteByUser");
    private final static QName _GetSiteByUserResponse_QNAME = new QName("http://service.webservice.eps.huilan.com/", "getSiteByUserResponse");

    private final static QName _GetPageTreeNode_QNAME = new QName("http://service.webservice.eps.huilan.com/", "getPageTreeNode");
    private final static QName _GetPageTreeNodeResponse_QNAME = new QName("http://service.webservice.eps.huilan.com/", "getPageTreeNodeResponse");

    private final static QName _Login_QNAME = new QName("http://service.webservice.eps.huilan.com/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://service.webservice.eps.huilan.com/", "loginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.huilan.eps.webservice.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    public Article createArticle() {
        return new Article();
    }

    /**
     * Create an instance of {@link Article.ResultMap }
     * 
     */
    public Article.ResultMap createArticleResultMap() {
        return new Article.ResultMap();
    }

    /**
     * Create an instance of {@link AddArticle }
     * 
     */
    public AddArticle createAddArticle() {
        return new AddArticle();
    }

    /**
     * Create an instance of {@link AddArticleByAttachment }
     * 
     */
    public AddArticleByAttachment createAddArticleByAttachment() {
        return new AddArticleByAttachment();
    }

    /**
     * Create an instance of {@link AddArticleByAttachmentResponse }
     * 
     */
    public AddArticleByAttachmentResponse createAddArticleByAttachmentResponse() {
        return new AddArticleByAttachmentResponse();
    }

    /**
     * Create an instance of {@link AddArticleResponse }
     * 
     */
    public AddArticleResponse createAddArticleResponse() {
        return new AddArticleResponse();
    }

    /**
     * Create an instance of {@link DeleteArticle }
     * 
     */
    public DeleteArticle createDeleteArticle() {
        return new DeleteArticle();
    }

    /**
     * Create an instance of {@link DeleteArticleResponse }
     * 
     */
    public DeleteArticleResponse createDeleteArticleResponse() {
        return new DeleteArticleResponse();
    }

    /**
     * Create an instance of {@link GetArticleByKey }
     * 
     */
    public GetArticleByKey createGetArticleByKey() {
        return new GetArticleByKey();
    }

    /**
     * Create an instance of {@link GetArticleByKeyResponse }
     * 
     */
    public GetArticleByKeyResponse createGetArticleByKeyResponse() {
        return new GetArticleByKeyResponse();
    }

    /**
     * Create an instance of {@link GetArticleByPage }
     * 
     */
    public GetArticleByPage createGetArticleByPage() {
        return new GetArticleByPage();
    }

    /**
     * Create an instance of {@link GetArticleByPageResponse }
     * 
     */
    public GetArticleByPageResponse createGetArticleByPageResponse() {
        return new GetArticleByPageResponse();
    }

    /**
     * Create an instance of {@link UpdateArticle }
     * 
     */
    public UpdateArticle createUpdateArticle() {
        return new UpdateArticle();
    }

    /**
     * Create an instance of {@link UpdateArticleByAttachment }
     * 
     */
    public UpdateArticleByAttachment createUpdateArticleByAttachment() {
        return new UpdateArticleByAttachment();
    }

    /**
     * Create an instance of {@link UpdateArticleByAttachmentResponse }
     * 
     */
    public UpdateArticleByAttachmentResponse createUpdateArticleByAttachmentResponse() {
        return new UpdateArticleByAttachmentResponse();
    }

    /**
     * Create an instance of {@link UpdateArticleResponse }
     * 
     */
    public UpdateArticleResponse createUpdateArticleResponse() {
        return new UpdateArticleResponse();
    }

    /**
     * Create an instance of {@link LoginProperty }
     * 
     */
    public LoginProperty createLoginProperty() {
        return new LoginProperty();
    }

    /**
     * Create an instance of {@link ArticleFile }
     * 
     */
    public ArticleFile createArticleFile() {
        return new ArticleFile();
    }

    /**
     * Create an instance of {@link Attachment }
     * 
     */
    public Attachment createAttachment() {
        return new Attachment();
    }

    /**
     * Create an instance of {@link ArticlePage }
     * 
     */
    public ArticlePage createArticlePage() {
        return new ArticlePage();
    }

    /**
     * Create an instance of {@link MapConvertor }
     * 
     */
    public MapConvertor createMapConvertor() {
        return new MapConvertor();
    }

    /**
     * Create an instance of {@link MapEntry }
     * 
     */
    public MapEntry createMapEntry() {
        return new MapEntry();
    }

    /**
     * Create an instance of {@link Article.ResultMap.Entry }
     * 
     */
    public Article.ResultMap.Entry createArticleResultMapEntry() {
        return new Article.ResultMap.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "addArticle")
    public JAXBElement<AddArticle> createAddArticle(AddArticle value) {
        return new JAXBElement<AddArticle>(_AddArticle_QNAME, AddArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArticleByAttachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "addArticleByAttachment")
    public JAXBElement<AddArticleByAttachment> createAddArticleByAttachment(AddArticleByAttachment value) {
        return new JAXBElement<AddArticleByAttachment>(_AddArticleByAttachment_QNAME, AddArticleByAttachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArticleByAttachmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "addArticleByAttachmentResponse")
    public JAXBElement<AddArticleByAttachmentResponse> createAddArticleByAttachmentResponse(AddArticleByAttachmentResponse value) {
        return new JAXBElement<AddArticleByAttachmentResponse>(_AddArticleByAttachmentResponse_QNAME, AddArticleByAttachmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "addArticleResponse")
    public JAXBElement<AddArticleResponse> createAddArticleResponse(AddArticleResponse value) {
        return new JAXBElement<AddArticleResponse>(_AddArticleResponse_QNAME, AddArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "deleteArticle")
    public JAXBElement<DeleteArticle> createDeleteArticle(DeleteArticle value) {
        return new JAXBElement<DeleteArticle>(_DeleteArticle_QNAME, DeleteArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "deleteArticleResponse")
    public JAXBElement<DeleteArticleResponse> createDeleteArticleResponse(DeleteArticleResponse value) {
        return new JAXBElement<DeleteArticleResponse>(_DeleteArticleResponse_QNAME, DeleteArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArticleByKey }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "getArticleByKey")
    public JAXBElement<GetArticleByKey> createGetArticleByKey(GetArticleByKey value) {
        return new JAXBElement<GetArticleByKey>(_GetArticleByKey_QNAME, GetArticleByKey.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArticleByKeyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "getArticleByKeyResponse")
    public JAXBElement<GetArticleByKeyResponse> createGetArticleByKeyResponse(GetArticleByKeyResponse value) {
        return new JAXBElement<GetArticleByKeyResponse>(_GetArticleByKeyResponse_QNAME, GetArticleByKeyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArticleByPage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "getArticleByPage")
    public JAXBElement<GetArticleByPage> createGetArticleByPage(GetArticleByPage value) {
        return new JAXBElement<GetArticleByPage>(_GetArticleByPage_QNAME, GetArticleByPage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArticleByPageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "getArticleByPageResponse")
    public JAXBElement<GetArticleByPageResponse> createGetArticleByPageResponse(GetArticleByPageResponse value) {
        return new JAXBElement<GetArticleByPageResponse>(_GetArticleByPageResponse_QNAME, GetArticleByPageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "updateArticle")
    public JAXBElement<UpdateArticle> createUpdateArticle(UpdateArticle value) {
        return new JAXBElement<UpdateArticle>(_UpdateArticle_QNAME, UpdateArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateArticleByAttachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "updateArticleByAttachment")
    public JAXBElement<UpdateArticleByAttachment> createUpdateArticleByAttachment(UpdateArticleByAttachment value) {
        return new JAXBElement<UpdateArticleByAttachment>(_UpdateArticleByAttachment_QNAME, UpdateArticleByAttachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateArticleByAttachmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "updateArticleByAttachmentResponse")
    public JAXBElement<UpdateArticleByAttachmentResponse> createUpdateArticleByAttachmentResponse(UpdateArticleByAttachmentResponse value) {
        return new JAXBElement<UpdateArticleByAttachmentResponse>(_UpdateArticleByAttachmentResponse_QNAME, UpdateArticleByAttachmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "updateArticleResponse")
    public JAXBElement<UpdateArticleResponse> createUpdateArticleResponse(UpdateArticleResponse value) {
        return new JAXBElement<UpdateArticleResponse>(_UpdateArticleResponse_QNAME, UpdateArticleResponse.class, null, value);
    }
    
    /**
     * Create an instance of {@link GetSiteByUser }
     * 
     */
    public GetSiteByUser createGetSiteByUser() {
        return new GetSiteByUser();
    }

    /**
     * Create an instance of {@link GetSiteByUserResponse }
     * 
     */
    public GetSiteByUserResponse createGetSiteByUserResponse() {
        return new GetSiteByUserResponse();
    }
    /**
     * Create an instance of {@link SiteInfos }
     * 
     */
    public SiteInfos createSiteInfos() {
        return new SiteInfos();
    }

    /**
     * Create an instance of {@link UserMgrSite }
     * 
     */
    public UserMgrSite createUserMgrSite() {
        return new UserMgrSite();
    }

    /**
     * Create an instance of {@link IdEntity }
     * 
     */
    public IdEntity createIdEntity() {
        return new IdEntity();
    }
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSiteByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "getSiteByUser")
    public JAXBElement<GetSiteByUser> createGetSiteByUser(GetSiteByUser value) {
        return new JAXBElement<GetSiteByUser>(_GetSiteByUser_QNAME, GetSiteByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSiteByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "getSiteByUserResponse")
    public JAXBElement<GetSiteByUserResponse> createGetSiteByUserResponse(GetSiteByUserResponse value) {
        return new JAXBElement<GetSiteByUserResponse>(_GetSiteByUserResponse_QNAME, GetSiteByUserResponse.class, null, value);
    }
    
    /**
     * Create an instance of {@link GetPageTreeNode }
     * 
     */
    public GetPageTreeNode createGetPageTreeNode() {
        return new GetPageTreeNode();
    }

    /**
     * Create an instance of {@link GetPageTreeNodeResponse }
     * 
     */
    public GetPageTreeNodeResponse createGetPageTreeNodeResponse() {
        return new GetPageTreeNodeResponse();
    }
    
    /**
     * Create an instance of {@link VoCommonPage }
     * 
     */
    public VoCommonPage createVoCommonPage() {
        return new VoCommonPage();
    }

    /**
     * Create an instance of {@link CommonPagePowerOpType }
     * 
     */
    public CommonPagePowerOpType createCommonPagePowerOpType() {
        return new CommonPagePowerOpType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPageTreeNode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "getPageTreeNode")
    public JAXBElement<GetPageTreeNode> createGetPageTreeNode(GetPageTreeNode value) {
        return new JAXBElement<GetPageTreeNode>(_GetPageTreeNode_QNAME, GetPageTreeNode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPageTreeNodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "getPageTreeNodeResponse")
    public JAXBElement<GetPageTreeNodeResponse> createGetPageTreeNodeResponse(GetPageTreeNodeResponse value) {
        return new JAXBElement<GetPageTreeNodeResponse>(_GetPageTreeNodeResponse_QNAME, GetPageTreeNodeResponse.class, null, value);
    }
    
    /**
     * Create an instance of {@link UserInfo }
     * 
     */
    public UserInfo createUserInfo() {
        return new UserInfo();
    }

    /**
     * Create an instance of {@link UserInfo.UserUrlResourceMap }
     * 
     */
    public UserInfo.UserUrlResourceMap createUserInfoUserUrlResourceMap() {
        return new UserInfo.UserUrlResourceMap();
    }

    /**
     * Create an instance of {@link UserInfo.UserMap }
     * 
     */
    public UserInfo.UserMap createUserInfoUserMap() {
        return new UserInfo.UserMap();
    }
    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link Login.Param }
     * 
     */
    public Login.Param createLoginParam() {
        return new Login.Param();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

  

    /**
     * Create an instance of {@link UserInfos }
     * 
     */
    public UserInfos createUserInfos() {
        return new UserInfos();
    }

    

    /**
     * Create an instance of {@link LdapUserInfo }
     * 
     */
    public LdapUserInfo createLdapUserInfo() {
        return new LdapUserInfo();
    }

    /**
     * Create an instance of {@link EpsSection }
     * 
     */
    public EpsSection createEpsSection() {
        return new EpsSection();
    }

    /**
     * Create an instance of {@link UrlResource }
     * 
     */
    public UrlResource createUrlResource() {
        return new UrlResource();
    }

    /**
     * Create an instance of {@link UserInfo.UserUrlResourceMap.Entry }
     * 
     */
    public UserInfo.UserUrlResourceMap.Entry createUserInfoUserUrlResourceMapEntry() {
        return new UserInfo.UserUrlResourceMap.Entry();
    }

    /**
     * Create an instance of {@link UserInfo.UserMap.Entry }
     * 
     */
    public UserInfo.UserMap.Entry createUserInfoUserMapEntry() {
        return new UserInfo.UserMap.Entry();
    }

    /**
     * Create an instance of {@link Login.Param.Entry }
     * 
     */
    public Login.Param.Entry createLoginParamEntry() {
        return new Login.Param.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.eps.huilan.com/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }
}
