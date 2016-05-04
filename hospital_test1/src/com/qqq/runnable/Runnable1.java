package com.qqq.runnable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.qqq.bean.Longterm_Ordermgt;
import com.qqq.bean.Shortterm_Ordermgt;
import com.qqq.bean.V_orders;
import com.qqq.daoimpl.DaoImpl1;
import com.qqq.utils.Tools;

public class Runnable1 implements Runnable {
	private static Logger logger = Logger.getLogger(Runnable1.class);

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		long delay = 0;
		while (true) {
			System.out.println(i++);
			Date now = new Date();
			// System.out.println(now);
			System.out.println(now);
			logger.debug(now);
			DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// System.out.println(df2.format(now));
			Date d1 = null;
			Date d = null;
			DaoImpl1 di1 = new DaoImpl1();
			try {
				// d1 = df2.parse(di1.getLastDate());
				d1 = df2.parse(Tools.loadTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			List<V_orders> listV = di1.selectSourceAll();
			for (V_orders vo : listV) {
				String date = vo.getStart_date_time();
				try {
					d = df1.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (d.getTime() > d1.getTime()) {
					if (vo.getRepeat_indicator().equals("1")) {
						Longterm_Ordermgt lo = new Longterm_Ordermgt();
						lo.setLgord_patic(vo.getPatient_id());
						String start_date_time = null;
						try {
							start_date_time = df2.format(df1.parse(vo
									.getStart_date_time()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						lo.setLgord_dateord(Tools.formatDate(start_date_time));
						lo.setLgord_timeord(Tools.formatTime(start_date_time));
						lo.setLgord_usr1(vo.getDoctor());
						lo.setLgord_drug(vo.getOrder_code());
						lo.setLgord_medway(vo.getAdministration());
						di1.insert(lo);
					} else if (vo.getRepeat_indicator().equals("0")) {
						Shortterm_Ordermgt so = new Shortterm_Ordermgt();
						so.setShord_patic(vo.getPatient_id());
						String start_date_time = null;
						try {
							start_date_time = df2.format(df1.parse(vo
									.getStart_date_time()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						so.setShord_dateord(Tools.formatDate(start_date_time));
						so.setShord_timeord(Tools.formatTime(start_date_time));
						so.setShord_usr1(vo.getDoctor());
						so.setShord_drug(vo.getOrder_code());
						so.setShord_medway(vo.getAdministration());
						di1.insert(so);
					}
				}
			}
			delay = Tools.loadDelay();
			Tools.saveTime(df2.format(now), delay);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
