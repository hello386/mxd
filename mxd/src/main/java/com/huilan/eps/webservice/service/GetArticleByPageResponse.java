
package com.huilan.eps.webservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getArticleByPageResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="getArticleByPageResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="article" type="{http://service.webservice.eps.huilan.com/}articlePage" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getArticleByPageResponse", propOrder = {
    "article"
})
public class GetArticleByPageResponse {

    protected ArticlePage article;

    /**
     * ��ȡarticle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArticlePage }
     *     
     */
    public ArticlePage getArticle() {
        return article;
    }

    /**
     * ����article���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArticlePage }
     *     
     */
    public void setArticle(ArticlePage value) {
        this.article = value;
    }

}
