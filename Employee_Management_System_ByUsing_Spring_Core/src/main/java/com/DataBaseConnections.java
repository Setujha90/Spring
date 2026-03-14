package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages="com")
@PropertySource("com/application.properties")
public class DataBaseConnections {
	
	@Value("${mysqlurl}")   //${} use to convert the string into reference
	private String url;
	@Value("${mysqlpassword}")
	private String password;
	@Value("${mysqlusername}")
	private String username;
	@Value("${mysqlDriverClass}")
	private String driverClassName;
	
	public Connection mysqlDBConnection() {
		try {
			Class.forName(driverClassName);
			return DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void oracleDbConnection() {
		try {
			DriverManager.getConnection("urloracle","useroracle","passwordoracle");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "DataBaseConnections [url=" + url + ", password=" + password + ", username=" + username
				+ ", driverClassName=" + driverClassName + "]";
	}
	
	

}
