package com.yyy.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yyy.io.Resource;
import com.yyy.pojo.Configuration;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author yxs
 * @date 2022/5/17 19:28
 * @note
 */
public class XmlConfigBuilder {
  private Configuration configuration;

  public XmlConfigBuilder(Configuration configuration) {
    this.configuration = configuration;
  }

  /**
   * 使用dom4java对配置文件进行解析，构建Configruation
   * @param inputStream
   * @return
   * @throws Exception
   */
  public Configuration parseConfig(InputStream inputStream) throws Exception{
    Document document = new SAXReader().read(inputStream);
    //解析sqlMapConfig 所有property标签
    Element rootElement = document.getRootElement();
    List<Element> list = rootElement.selectNodes("//property");
    Properties properties = new Properties();
    for (Element element : list) {
      String name = element.attributeValue("name");
      String value = element.attributeValue("value");
      properties.setProperty(name,value);
    }

    //配置数据库连接池，c3p0或者durid都可
    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
    comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
    comboPooledDataSource.setPassword(properties.getProperty("password"));
    comboPooledDataSource.setUser(properties.getProperty("username"));
    configuration.setDataSource(comboPooledDataSource);

    //获取mapper.xml路径，解析每条sql
    List<Element> mapperlist = rootElement.selectNodes("resource");
    for (Element element : mapperlist) {
      String mapperPath = element.attributeValue("resource");
      InputStream xmlMapperInputstream = Resource.getResourceAsStream(mapperPath);
      XmlMapperBuilder xmlMapperBuilder = new XmlMapperBuilder(configuration);
      xmlMapperBuilder.parse(xmlMapperInputstream);
    }


    return configuration;
  }
}
