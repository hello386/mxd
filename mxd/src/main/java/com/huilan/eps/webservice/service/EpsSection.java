
package com.huilan.eps.webservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>epsSection complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="epsSection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="checked" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="externalJsUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extjsIconCls" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extjsModuleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extjsModuleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="imgSrc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="leaf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="linkPara" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="linkType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="linkUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mainClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="moduleIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="moduleLevel" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="moduleScope" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="moduleType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nameCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nameFirstSpell" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nameFullPin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orderby" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="realModule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sectionGroupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "epsSection", propOrder = {
    "checked",
    "code",
    "description",
    "externalJsUrl",
    "extjsIconCls",
    "extjsModuleId",
    "extjsModuleName",
    "height",
    "id",
    "imgSrc",
    "leaf",
    "linkPara",
    "linkType",
    "linkUrl",
    "mainClass",
    "moduleIndex",
    "moduleLevel",
    "moduleScope",
    "moduleType",
    "name",
    "nameCode",
    "nameFirstSpell",
    "nameFullPin",
    "orderby",
    "parentId",
    "parentName",
    "realModule",
    "sectionGroupId",
    "width"
})
public class EpsSection {

    protected boolean checked;
    protected String code;
    protected String description;
    protected String externalJsUrl;
    protected String extjsIconCls;
    protected String extjsModuleId;
    protected String extjsModuleName;
    protected int height;
    protected String id;
    protected String imgSrc;
    protected String leaf;
    protected String linkPara;
    protected String linkType;
    protected String linkUrl;
    protected String mainClass;
    protected String moduleIndex;
    protected int moduleLevel;
    protected String moduleScope;
    protected String moduleType;
    protected String name;
    protected String nameCode;
    protected String nameFirstSpell;
    protected String nameFullPin;
    protected Long orderby;
    protected String parentId;
    protected String parentName;
    protected String realModule;
    protected String sectionGroupId;
    protected int width;

    /**
     * ��ȡchecked���Ե�ֵ��
     * 
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * ����checked���Ե�ֵ��
     * 
     */
    public void setChecked(boolean value) {
        this.checked = value;
    }

    /**
     * ��ȡcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * ����code���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * ��ȡdescription���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * ����description���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * ��ȡexternalJsUrl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalJsUrl() {
        return externalJsUrl;
    }

    /**
     * ����externalJsUrl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalJsUrl(String value) {
        this.externalJsUrl = value;
    }

    /**
     * ��ȡextjsIconCls���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtjsIconCls() {
        return extjsIconCls;
    }

    /**
     * ����extjsIconCls���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtjsIconCls(String value) {
        this.extjsIconCls = value;
    }

    /**
     * ��ȡextjsModuleId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtjsModuleId() {
        return extjsModuleId;
    }

    /**
     * ����extjsModuleId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtjsModuleId(String value) {
        this.extjsModuleId = value;
    }

    /**
     * ��ȡextjsModuleName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtjsModuleName() {
        return extjsModuleName;
    }

    /**
     * ����extjsModuleName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtjsModuleName(String value) {
        this.extjsModuleName = value;
    }

    /**
     * ��ȡheight���Ե�ֵ��
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * ����height���Ե�ֵ��
     * 
     */
    public void setHeight(int value) {
        this.height = value;
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
     * ��ȡimgSrc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgSrc() {
        return imgSrc;
    }

    /**
     * ����imgSrc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgSrc(String value) {
        this.imgSrc = value;
    }

    /**
     * ��ȡleaf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeaf() {
        return leaf;
    }

    /**
     * ����leaf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeaf(String value) {
        this.leaf = value;
    }

    /**
     * ��ȡlinkPara���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkPara() {
        return linkPara;
    }

    /**
     * ����linkPara���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkPara(String value) {
        this.linkPara = value;
    }

    /**
     * ��ȡlinkType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkType() {
        return linkType;
    }

    /**
     * ����linkType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkType(String value) {
        this.linkType = value;
    }

    /**
     * ��ȡlinkUrl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * ����linkUrl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkUrl(String value) {
        this.linkUrl = value;
    }

    /**
     * ��ȡmainClass���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainClass() {
        return mainClass;
    }

    /**
     * ����mainClass���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainClass(String value) {
        this.mainClass = value;
    }

    /**
     * ��ȡmoduleIndex���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleIndex() {
        return moduleIndex;
    }

    /**
     * ����moduleIndex���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleIndex(String value) {
        this.moduleIndex = value;
    }

    /**
     * ��ȡmoduleLevel���Ե�ֵ��
     * 
     */
    public int getModuleLevel() {
        return moduleLevel;
    }

    /**
     * ����moduleLevel���Ե�ֵ��
     * 
     */
    public void setModuleLevel(int value) {
        this.moduleLevel = value;
    }

    /**
     * ��ȡmoduleScope���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleScope() {
        return moduleScope;
    }

    /**
     * ����moduleScope���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleScope(String value) {
        this.moduleScope = value;
    }

    /**
     * ��ȡmoduleType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleType() {
        return moduleType;
    }

    /**
     * ����moduleType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleType(String value) {
        this.moduleType = value;
    }

    /**
     * ��ȡname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * ����name���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * ��ȡnameCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameCode() {
        return nameCode;
    }

    /**
     * ����nameCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameCode(String value) {
        this.nameCode = value;
    }

    /**
     * ��ȡnameFirstSpell���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameFirstSpell() {
        return nameFirstSpell;
    }

    /**
     * ����nameFirstSpell���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameFirstSpell(String value) {
        this.nameFirstSpell = value;
    }

    /**
     * ��ȡnameFullPin���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameFullPin() {
        return nameFullPin;
    }

    /**
     * ����nameFullPin���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameFullPin(String value) {
        this.nameFullPin = value;
    }

    /**
     * ��ȡorderby���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrderby() {
        return orderby;
    }

    /**
     * ����orderby���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrderby(Long value) {
        this.orderby = value;
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
     * ��ȡparentName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * ����parentName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentName(String value) {
        this.parentName = value;
    }

    /**
     * ��ȡrealModule���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealModule() {
        return realModule;
    }

    /**
     * ����realModule���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealModule(String value) {
        this.realModule = value;
    }

    /**
     * ��ȡsectionGroupId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSectionGroupId() {
        return sectionGroupId;
    }

    /**
     * ����sectionGroupId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSectionGroupId(String value) {
        this.sectionGroupId = value;
    }

    /**
     * ��ȡwidth���Ե�ֵ��
     * 
     */
    public int getWidth() {
        return width;
    }

    /**
     * ����width���Ե�ֵ��
     * 
     */
    public void setWidth(int value) {
        this.width = value;
    }

}
