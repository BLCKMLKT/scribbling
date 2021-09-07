package com.company.dao;

import java.net.InetAddress;
import java.sql.*;
import java.util.*;

import com.company.dbmanager.DBManager;
import com.company.dto.BDto;

public class BDao {
	public BDao() {}
	public ArrayList<BDto> list(int page, int onepageLimit) { //---------------------------- list
		DBManager db = new DBManager(); Connection conn = null; 
		PreparedStatement pstmt = null; ResultSet rset = null;
		ArrayList<BDto> list = new ArrayList<BDto>();
		String sql = "select * from mvcboard4 order by bno desc limit ?, ?";
		int start = (page-1)*onepageLimit;
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start); pstmt.setInt(2, onepageLimit);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new BDto(
						rset.getInt("bno"), rset.getString("bname"), rset.getString("bpass"), rset.getString("btitle"), 
						rset.getString("bcontent"), rset.getString("bdate"), rset.getInt("bhit"), rset.getString("bip"),
						rset.getString("bimg")
					));
			}
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(rset!=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
	}
	public int datacnt() {
		DBManager db = new DBManager(); Connection conn = null; int datacnt = 0; 
		PreparedStatement pstmt = null; ResultSet rset = null;
		String sql = "select count(*) datacnt from mvcboard4";
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) { datacnt = rset.getInt("datacnt"); }
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(rset!=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return datacnt;
	}
	public int writeNoImg(BDto dto) { //---------------------------- write
		DBManager db = new DBManager(); Connection conn = null; PreparedStatement pstmt = null;
		String sql = "insert into mvcboard4 (bname, bpass, btitle, bcontent, bip)"
				+ " values (?, ?, ?, ?, ?)";
		int result = 0;
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname()); pstmt.setString(2, dto.getBpass());
			pstmt.setString(3, dto.getBtitle()); pstmt.setString(4, dto.getBcontent());
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	public int write(BDto dto) { //---------------------------- write
		DBManager db = new DBManager(); Connection conn = null; PreparedStatement pstmt = null;
		String sql = "insert into mvcboard4 (bname, bpass, btitle, bcontent, bip, bimg)"
				+ " values (?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname()); pstmt.setString(2, dto.getBpass());
			pstmt.setString(3, dto.getBtitle()); pstmt.setString(4, dto.getBcontent());
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(6, dto.getBimg());
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	public int bhit(BDto dto) { //---------------------------- detail bhit
		DBManager db = new DBManager(); Connection conn = null; PreparedStatement pstmt = null;
		String sql = "update mvcboard4 set bhit=bhit+1 where bno=?"; int result = 0;
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql); pstmt.setInt(1, dto.getBno());
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	public BDto detail(BDto dto) { //---------------------------- detail/edit form
		DBManager db = new DBManager(); Connection conn = null; 
		PreparedStatement pstmt = null; ResultSet rset = null;
		String sql = "select * from mvcboard4 where bno=?";
		BDto selected = new BDto();
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBno());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				selected.setBno(rset.getInt("bno")); selected.setBname(rset.getString("bname"));
				selected.setBpass(rset.getString("bpass")); selected.setBtitle(rset.getString("btitle"));
				selected.setBcontent(rset.getString("bcontent")); selected.setBhit(rset.getInt("bhit"));
				selected.setBdate(rset.getString("bdate")); selected.setBip(rset.getString("bip"));
				selected.setBimg(rset.getString("bimg"));
			}
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(rset!=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return selected;
	}
	public int updateNoImg(BDto dto) { //---------------------------- edit
		DBManager db = new DBManager(); Connection conn = null; PreparedStatement pstmt = null;
		String sql = "update mvcboard4 set btitle=?, bcontent=? where bno=? and bpass=?"; 
		int result = 0;
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, dto.getBtitle()); pstmt.setString(2, dto.getBcontent());
			pstmt.setInt(3, dto.getBno()); pstmt.setString(4, dto.getBpass());
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	public int update(BDto dto) { //---------------------------- edit
		DBManager db = new DBManager(); Connection conn = null; PreparedStatement pstmt = null;
		String sql = "update mvcboard4 set btitle=?, bcontent=?, bimg=? where bno=? and bpass=?"; 
		int result = 0;
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, dto.getBtitle()); pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getBimg()); pstmt.setInt(4, dto.getBno()); 
			pstmt.setString(5, dto.getBpass());
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
	public int delete(BDto dto) {
		DBManager db = new DBManager(); Connection conn = null; PreparedStatement pstmt = null;
		String sql = "delete from mvcboard4 where bno=? and bpass=?"; int result = 0;
		try {
			conn = db.connection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, dto.getBno()); pstmt.setString(2, dto.getBpass());
			result = pstmt.executeUpdate();
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			if(pstmt!=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn!=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	}
}
