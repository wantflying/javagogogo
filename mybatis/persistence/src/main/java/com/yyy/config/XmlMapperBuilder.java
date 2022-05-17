package com.yyy.config;

import com.yyy.pojo.Configuration;
import com.yyy.pojo.MappedStatement;
import java.io.InputStream;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author yxs
 * @date 2022/5/17 19:48
 * @note
 */
public class XmlMapperBuilder {

  private Configuration configuration;

  public XmlMapperBuilder(Configuration configuration) {
    this.configuration = configuration;
  }

  /**
   * 解析每条sql,组装唯一key,sql
   * @param xmlMapperInputstream
   */
  public void parse(InputStream xmlMapperInputstream) throws Exception{
    Document document = new SAXReader().read(xmlMapperInputstream);
    Element rootElement = document.getRootElement();
    String namespace = rootElement.attributeValue("namespace");

    //此处以查询为例子，增删换不同标签处理就好了
    List<Element> list = rootElement.selectNodes("//select");
    for (Element element : list) {
      String id = element.attributeValue("id");
      String resultType = element.attributeValue("resultType");
      String paramterType = element.attributeValue("paramterType");
      String sqlText = element.getTextTrim();
      MappedStatement mappedStatement = new MappedStatement();
      mappedStatement.setId(id);
      mappedStatement.setResultType(resultType);
      mappedStatement.setSql(sqlText);
      mappedStatement.setParameterType(paramterType);
      String key = namespace + "." + id;
      configuration.getMappedStatementMap().put(key, mappedStatement);

    }


  }
}
