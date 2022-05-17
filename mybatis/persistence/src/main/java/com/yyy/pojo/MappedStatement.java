package com.yyy.pojo;

/**
 * @author yxs
 * @date 2022/5/17 19:16
 * @note
 */
public class MappedStatement {

  private String id;

  /**
   * 返回结果类型
   */
  private String resultType;

  /**
   * 参数类型
   */
  private String parameterType;

  /**
   * sql语句
   */
  private String sql;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResultType() {
    return resultType;
  }

  public void setResultType(String resultType) {
    this.resultType = resultType;
  }

  public String getParameterType() {
    return parameterType;
  }

  public void setParameterType(String parameterType) {
    this.parameterType = parameterType;
  }

  public String getSql() {
    return sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }
}
