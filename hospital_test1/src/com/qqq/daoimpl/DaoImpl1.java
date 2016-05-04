package com.qqq.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qqq.bean.Longterm_Ordermgt;
import com.qqq.bean.Shortterm_Ordermgt;
import com.qqq.bean.V_orders;
import com.qqq.connect.ConnectDistance;
import com.qqq.connect.ConnectSource;

public class DaoImpl1 {
	private Connection connectSource;
	private Connection connectDistance;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	/***提取视图中所有数据***/
	public List<V_orders> selectSourceAll() {
		List<V_orders> list = new ArrayList<V_orders>();
		String sql = "select * from V_orders";
		connectSource = ConnectSource.connect();
		try {
			pstmt = connectSource.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				V_orders vo = new V_orders(rs.getString("patient_id"),
						rs.getString("repeat_indicator"),
						rs.getString("order_text"), rs.getString("order_code"),
						rs.getString("dosage"), rs.getString("dosage_units"),
						rs.getString("administration"),
						rs.getString("start_date_time"), rs.getString("doctor"));
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			connectSource.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public String getLastDate() {
		String date = "2000-1-1 00:00:00";
		String date1 = "";
		String date2 = "";
		String sql1 = "select lgord_dateord,lgord_timeord from longterm_ordermgt";
		String sql2 = "select shord_dateord,shord_timeord from shortterm_ordermgt";
		connectDistance = ConnectDistance.connect();
		try {
			pstmt = connectDistance.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rs.last();
				date1 = rs.getString(1) + " " + rs.getString(2);
			} else {
				date1 = date;
			}
			//System.out.println(date1);
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pstmt = connectDistance.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rs.last();
				date2 = rs.getString(1) + " " + rs.getString(2);
			} else {
				date2 = date;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d = df.parse(date);
			Date d1 = df.parse(date1);
			Date d2 = df.parse(date2);
			if (d1.getTime() > d.getTime()) {
				d = d1;
			}
			if (d2.getTime() > d.getTime()) {
				d = d2;
			}
			date = df.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connectDistance.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/***长期医嘱输入***/
	public void insert(Longterm_Ordermgt lo) {
		String sql = "insert into longterm_ordermgt values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		connectDistance = ConnectDistance.connect();
		try {
			pstmt = connectDistance.prepareStatement(sql);
			pstmt.setString(1, lo.getLgord_patic());
			pstmt.setString(2, lo.getLgord_dateord());
			pstmt.setString(3, lo.getLgord_timeord());
			pstmt.setString(4, lo.getLgord_usr1());
			pstmt.setString(5, lo.getLgord_drug());
			pstmt.setString(6, lo.getLgord_actst());
			pstmt.setString(7, lo.getLgord_dtactst());
			pstmt.setString(8, lo.getLgord_usr2());
			pstmt.setString(9, lo.getLgord_comment());
			pstmt.setString(10, lo.getLgord_intake());
			pstmt.setString(11, lo.getLgord_freq());
			pstmt.setString(12, lo.getLgord_nurs());
			pstmt.setString(13, lo.getLgord_timest());
			pstmt.setString(14, lo.getLgord_medway());
			pstmt.executeUpdate();
			pstmt.close();
			connectDistance.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***短期医嘱输入***/
	public void insert(Shortterm_Ordermgt so) {
		String sql = "insert into shortterm_ordermgt values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		connectDistance = ConnectDistance.connect();
		try {
			pstmt = connectDistance.prepareStatement(sql);
			pstmt.setString(1, so.getShord_patic());
			pstmt.setString(2, so.getShord_dateord());
			pstmt.setString(3, so.getShord_timeord());
			pstmt.setString(4, so.getShord_usr1());
			pstmt.setString(5, so.getShord_drug());
			pstmt.setString(6, so.getShord_actst());
			pstmt.setString(7, so.getShord_dtactst());
			pstmt.setString(8, so.getShord_usr2());
			pstmt.setString(9, so.getShord_comment());
			pstmt.setString(10, so.getShord_intake());
			pstmt.setString(11, so.getShord_freq());
			pstmt.setString(12, so.getShord_nurs());
			pstmt.setString(13, so.getShord_medway());
			pstmt.executeUpdate();
			pstmt.close();
			connectDistance.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
