/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

// import com.zaxxer.hikari.HikariConfig;
// import com.zaxxer.hikari.HikariDataSource;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;

// import javax.sql.DataSource;
// import java.sql.Connection;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
// import java.util.Map;

public class Main {

  public static void main(String[] args) {
    // final Properties properties = new Properties();
    // try {
    //   properties.load(new FileInputStream("../resources/application.properties"));
    //   System.out.println(properties.getProperty("server.port"));
    // } catch (FileNotFoundException e1) {
    //   // TODO Auto-generated catch block
    //   e1.printStackTrace();
    // } catch (IOException e1) {
    //   // TODO Auto-generated catch block
    //   e1.printStackTrace();
    // }
    
    
      int port = Integer.parseInt (System.getenv("PORT"));
      for(int i = 0; i < 10; i++){  
      System.out.println(port);
      }
          final Jetty jetty = new Jetty(port);
          try{ 
              jetty.start();
              Thread.sleep(500);
              if (false == jetty.isStarted()) {
                  throw new Exception("Cannot start jetty server");
              }
          } catch(Exception e)  { }
  }
}

