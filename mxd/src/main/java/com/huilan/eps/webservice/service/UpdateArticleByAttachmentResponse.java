
package com.huilan.eps.webservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>updateArticleByAttachmentResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="updateArticleByAttachmentResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleResult" type="{http://service.webservice.eps.huilan.com/}article" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateArticleByAttachmentResponse", propOrder = {
    "articleResult"
})
public class UpdateArticleByAttachmentResponse {

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
