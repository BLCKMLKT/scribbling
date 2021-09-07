package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.dbmanager.DBManager;
import com.company.dto.UserDto;

public class UDao {
	public UDao() {}
	public int user_search(UserDto udto) {
		DBManager db = new DBManager(); Connection conn = null; 
		PreparedStatement pstmt = null; ResultSet rset = null; int uno = 0;
		String sql = "select uno from userinfo where uemail=?";
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, udto.getUemail());
			rset = pstmt.executeQuery();
			if(rset.next()) { 
				uno = rset.getInt("uno");
			}
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(rset!=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return uno;
	}
	public String upassword_search(UserDto udto) {
		DBManager db = new DBManager(); Connection conn = null; 
		PreparedStatement pstmt = null; ResultSet rset = null; String upassword = null;
		String sql = "select upassword from userinfo where uno=?";
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, udto.getUno());
			rset = pstmt.executeQuery();
			if(rset.next()) { 
				upassword = rset.getString("upassword");
			}
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(rset!=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return upassword;
	}
	public int upassword_change(UserDto udto) {
		DBManager db = new DBManager(); Connection conn = null; 
		PreparedStatement pstmt = null; int result = 0;
		String sql = "update userinfo set upassword=? where uno=?";
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, udto.getUpassword()); pstmt.setInt(2, udto.getUno());
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	public int edit_userinfo(UserDto udto) {
		DBManager db = new DBManager(); Connection conn = null; 
		PreparedStatement pstmt = null; int result = 0;
		String sql = "update userinfo set ubirth=?, ugender=?, upostcode=?, uaddress=? where uno=?";
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, udto.getUbirth()); pstmt.setString(2, udto.getUgender());
			pstmt.setString(3, udto.getUpostcode()); pstmt.setString(4, udto.getUaddress()); 
			pstmt.setInt(5, udto.getUno());
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	public UserDto login(UserDto udto) {
		DBManager db = new DBManager(); Connection conn = null; 
		PreparedStatement pstmt = null; ResultSet rset = null; UserDto user = null;
		String sql = "select uno, uname from userinfo where uemail=? and upassword=?";
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, udto.getUemail()); pstmt.setString(2, udto.getUpassword());
			rset = pstmt.executeQuery();
			if(rset.next()) { 
				user = new UserDto(); user.setUno(rset.getInt("uno"));
				user.setUname(rset.getString("uname"));
			}
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(rset!=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return user;
	}
	public UserDto userinfo(UserDto udto) {
		DBManager db = new DBManager(); Connection conn = null; 
		PreparedStatement pstmt = null; ResultSet rset = null; UserDto user = null;
		String sql = "select * from userinfo where uno=?";
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, udto.getUno());
			rset = pstmt.executeQuery();
			if(rset.next()) { 
				user = new UserDto(
						rset.getInt("uno"), rset.getString("uemail"), rset.getString("upassword"),
						rset.getString("uname"), rset.getString("ubirth"), rset.getString("ugender"),
						rset.getString("uphone"), rset.getString("upostcode"), rset.getString("uaddress"),
						rset.getString("utype"), rset.getString("usubs"), rset.getString("udate"),
						rset.getString("uip")
				);
			}
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(rset!=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return user;
	}
	public int join(UserDto udto) {
		DBManager db = new DBManager(); Connection conn = null; 
		PreparedStatement pstmt = null; int result = 0;
		String sql = "insert into userinfo (uemail, upassword, uname, ubirth, ugender, upostcode, uaddress, uip)"
				   + " values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, udto.getUemail()); pstmt.setString(2, udto.getUpassword());
			pstmt.setString(3, udto.getUname()); pstmt.setString(4, udto.getUbirth());
			pstmt.setString(5, udto.getUgender()); 
			pstmt.setString(6, udto.getUpostcode()); 
			pstmt.setString(7, udto.getUaddress()); pstmt.setString(8, udto.getUip());
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	public int deactivate(UserDto udto) {
		DBManager db = new DBManager(); Connection conn = null; 
		PreparedStatement pstmt = null; int result = 0;
		String sql = "delete from userinfo where uno=? and uemail=? and upassword=?";
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, udto.getUno());
			pstmt.setString(2, udto.getUemail()); 
			pstmt.setString(3, udto.getUpassword());
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
}
