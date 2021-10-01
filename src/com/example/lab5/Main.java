package com.example.lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			//SQlite JDBC check
			Class.forName("org.sqlite.JDBC");
			
			// file connect
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			// data find
			System.out.println("\n*** 데이터 조회 ***");
			Statement st = con.createStatement();
			String sql = "select * from g_artists";
			ResultSet r = st.executeQuery(sql);
			
			while (r.next()) {
				String id = r.getString("id");
				String name = r.getString("name");
				String regdate = r.getString("regdate");
				System.out.println(id + " " + name + " " + regdate);
				// 내용 추가 가능...
				
			} 
			st.close();
			/*
			// 데이터 추가하기
			System.out.println("\n*** 새 데이터 추가 ***");
			Statement st1 = con.createStatement();
			String sql1 = "insert into g_artists (name, a_type, a_year, debut, regdate)" 
				+ " values ('방탄소년단', '남성', '2010년대', '2013년', datetime('now', 'localtime'));";
			int cnt = st1.executeUpdate(sql1);
			if (cnt > 0) {
				System.out.println("새로운 데이터가 추가되었습니다.");
			}
			else {
				System.out.println("[Error] 데이터 추가 오류!");
			}
			st1.close();
			*/
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					
				}
			}
		}

	}

}
