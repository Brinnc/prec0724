package com.home.prec0724.openAPI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class OpenFrame extends JFrame {
	JPanel p_north;
	JButton bt;
	JTextField t_url;
	JTable table;
	JScrollPane scroll;
	MyStoreModel model; //JTable에 정보를 제공해줄 컨트롤러

	public OpenFrame() {
		p_north = new JPanel();
		bt = new JButton("Load");
		t_url = new JTextField(90);
		table = new JTable(model=new MyStoreModel());
		scroll = new JScrollPane(table);

		p_north.add(bt);
		p_north.add(t_url);

		add(p_north, BorderLayout.NORTH);
		add(scroll);

		setSize(1000, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 오픈 api를 이용한 데이터를 공유하는 웹서버에 요청을 시도함
				//requestURL();

			}
		});
	}

	public void requestURL() {
		//URL
		try {
			URL url=new URL("https://api.odcloud.kr/api/15052408/v1/uddi:611c5470-ad94-49e8-8f72-973732c56304?page=1&perPage=10&serviceKey=DJvG2j0PyxMb5ipZJE8QorQlpni%2BvxJOATGwSU7tssZ1S3Va5HBhjVnHvLizdPgin09spAt2j5V3cKmaMBB5HA%3D%3D");
			URLConnection ucon=url.openConnection();
			
			//웹 서버에 요청을 시도할 수 있는 객체
			HttpURLConnection con=(HttpURLConnection)ucon;
			//HTTP 프로토콜에서 정해진 규칙 중 서버로부터 데이터를 가져올 때 사용하는 방식을 Get방식이라고 함
			con.setRequestMethod("GET");
			InputStream is=con.getInputStream();
			BufferedReader buffr=new BufferedReader(new InputStreamReader(is));
			
			String data=null;
			while(true) {
				data=buffr.readLine();
				if(data==null) break;
				System.out.println(data);
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		new OpenFrame();
	}
}
