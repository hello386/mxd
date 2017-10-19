
package com.huilan.eps.webservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getArticleByPage complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="getArticleByPage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="loginProperty" type="{http://service.webservice.eps.huilan.com/}loginProperty" minOccurs="0"/&gt;
 *         &lt;element name="columnId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pageNo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="queryContent" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="parameter" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getArticleByPage", propOrder = {
    "loginProperty",
    "columnId",
    "pageNo",
    "pageSize",
    "queryContent",
    "parameter"
})
public class GetArticleByPage {

    protected LoginProperty loginProperty;
    protected String columnId;
    protected int pageNo;
    protected int pageSize;
    protected boolean queryContent;
    protected Object parameter;

    /**
     * ��ȡloginProperty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link LoginProperty }
     *     
     */
    public LoginProperty getLoginProperty() {
        return loginProperty;
    }

    /**
     * ����loginProperty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link LoginProperty }
     *     
     */
    public void setLoginProperty(LoginProperty value) {
        this.loginProperty = value;
    }

    /**
     * ��ȡcolumnId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnId() {
        return columnId;
    }

    /**
     * ����columnId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnId(String value) {
        this.columnId = value;
    }

    /**
     * ��ȡpageNo���Ե�ֵ��
     * 
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * ����pageNo���Ե�ֵ��
     * 
     */
    public void setPageNo(int value) {
        this.pageNo = value;
    }

    /**
     * ��ȡpageSize���Ե�ֵ��
     * 
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * ����pageSize���Ե�ֵ��
     * 
     */
    public void setPageSize(int value) {
        this.pageSize = value;
    }

    /**
     * ��ȡqueryContent���Ե�ֵ��
     * 
     */
    public boolean isQueryContent() {
        return queryContent;
    }

    /**
     * ����queryContent���Ե�ֵ��
     * 
     */
    public void setQueryContent(boolean value) {
        this.queryContent = value;
    }

    /**
     * ��ȡparameter���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getParameter() {
        return parameter;
    }

    /**
     * ����parameter���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setParameter(Object value) {
        this.parameter = value;
    }

}
