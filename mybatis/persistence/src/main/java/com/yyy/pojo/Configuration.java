package com.yyy.pojo;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

/**
 * @author yxs
 * @date 2022/5/17 19:13
 * @note 面向对象的思想，将配置文件流转换成对象
 * 建造者模式构建对象
 */
public class Configuration {



  /**
   * 数据源，创建connection
   */
  private DataSource dataSource;

  /**
   * 用来存储每一条sql对象
   * key又叫做statementId,由namespace.id组成，用来定位唯一sql
   */
  Map<String,MappedStatement> mappedStatementMap = new HashMap<>();

  public DataSource getDataSource() {
    return dataSource;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Map<String, MappedStatement> getMappedStatementMap() {
    return mappedStatementMap;
  }

  public void setMappedStatementMap(
      Map<String, MappedStatement> mappedStatementMap) {
    this.mappedStatementMap = mappedStatementMap;
  }
}
