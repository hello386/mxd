
package com.huilan.eps.webservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getArticleByKey complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="getArticleByKey"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="loginProperty" type="{http://service.webservice.eps.huilan.com/}loginProperty" minOccurs="0"/&gt;
 *         &lt;element name="articleKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="columnId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getArticleByKey", propOrder = {
    "loginProperty",
    "articleKey",
    "columnId"
})
public class GetArticleByKey {

    protected LoginProperty loginProperty;
    protected String articleKey;
    protected String columnId;

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
     * ��ȡarticleKey���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleKey() {
        return articleKey;
    }

    /**
     * ����articleKey���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleKey(String value) {
        this.articleKey = value;
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

}
