
package com.huilan.eps.webservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>updateArticleResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="updateArticleResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="articleResult" type="{http://service.webservice.eps.huilan.com/}article" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateArticleResponse", propOrder = {
    "articleResult"
})
public class UpdateArticleResponse {

    protected Article articleResult;

    /**
     * ��ȡarticleResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Article }
     *     
     */
    public Article getArticleResult() {
        return articleResult;
    }

    /**
     * ����articleResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Article }
     *     
     */
    public void setArticleResult(Article value) {
        this.articleResult = value;
    }

}
