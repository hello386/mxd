
package com.huilan.eps.webservice.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>voCommonPage complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="voCommonPage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="leaf" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="opTypes" type="{http://service.webservice.eps.huilan.com/}commonPagePowerOpType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="pageIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voCommonPage", propOrder = {
    "active",
    "id",
    "leaf",
    "opTypes",
    "pageIndex",
    "parentId",
    "text"
})
public class VoCommonPage {

    protected boolean active;
    protected String id;
    protected boolean leaf;
    @XmlElement(nillable = true)
    protected List<CommonPagePowerOpType> opTypes;
    protected String pageIndex;
    protected String parentId;
    protected String text;

    /**
     * ��ȡactive���Ե�ֵ��
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * ����active���Ե�ֵ��
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * ��ȡleaf���Ե�ֵ��
     * 
     */
    public boolean isLeaf() {
        return leaf;
    }

    /**
     * ����leaf���Ե�ֵ��
     * 
     */
    public void setLeaf(boolean value) {
        this.leaf = value;
    }

    /**
     * Gets the value of the opTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommonPagePowerOpType }
     * 
     * 
     */
    public List<CommonPagePowerOpType> getOpTypes() {
        if (opTypes == null) {
            opTypes = new ArrayList<CommonPagePowerOpType>();
        }
        return this.opTypes;
    }

    /**
     * ��ȡpageIndex���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageIndex() {
        return pageIndex;
    }

    /**
     * ����pageIndex���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageIndex(String value) {
        this.pageIndex = value;
    }

    /**
     * ��ȡparentId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * ����parentId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentId(String value) {
        this.parentId = value;
    }

    /**
     * ��ȡtext���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * ����text���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

}
