package com.fivechess.view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.naming.InitialContext;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

/**
 * 登录页面
 * 选择人机对战还是人人对战
 * @author admin
 *
 */
public class SelectMenu extends JFrame implements MouseListener{
	public static void main(String[] args) throws LineUnavailableException, MalformedURLException {   //创建空的音乐
		URL url = null;//定位资源
		AudioClip ac; //新建一个音频播放接口
		File f1 = new File("FiveChess/src/com/fivechess/view/高山流水.wav");
		try {
			url= f1.toURL(); //定位音乐文件
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		ac= Applet.newAudioClip(url);
		ac.play();//播放
		new SelectMenu();
	}
	public SelectMenu() {
		setVisible(true);
		setLayout(null); //取消原来布局
		setBounds(580,185,536,803);
		setResizable(false);
		paintBg(); //页面
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
	}
	
	/**
	 * 添加背景图片，设置位置
	 */
	private void paintBg() {
		// TODO Auto-generated method stub
		ImageIcon image = new ImageIcon(this.getClass().getResource("棋盘背景1.jpg"));
		image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
        JLabel la = new JLabel(image);
        la.setBounds(0, 0, this.getWidth(), this.getHeight());//添加图片，设置图片大小为窗口的大小。
        this.getLayeredPane().add(la, new Integer(Integer.MAX_VALUE)); //将JLabel加入到面板容器的最上层
	}

	/**
	 * 点击页面触发事件
	 * @param e 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//日志
		Logger logger = Logger.getLogger("菜单");
		//获取点击坐标
		int x=e.getX();
		int y=e.getY();
		//System.out.println(x+" "+y);
		if(x>=200 && x<=360 && y>=490&& y<=600)
		{
			// 加载人机对战页
			dispose();
			logger.info("用户选择人机对战页面");
			new ChooseLevel();
		}
		else if(x>=200 && x<=360 && y>=340 && y<=450)
		{
			//加载人人对战页面
			dispose();
			logger.info("用户选择人人对战页面");
			new PPMainBoard();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
