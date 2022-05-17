package com.yyy.io;

import java.io.InputStream;

/**
 * @author yxs
 * @date 2022/5/17 19:09
 * @note
 */
public class Resource {

  /**
   * 根据配置文件的路径，将配置文件加载到内存中
   * @param path
   * @return
   */
    public static InputStream getResourceAsStream(String path){
      InputStream resourceAsStream = Resource.class.getClassLoader().getResourceAsStream(path);
      return resourceAsStream;
    }
}
