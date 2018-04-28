package com.hjf.GameWZQ1207;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameUI implements Config {
	// 保存棋子的二维数组
	private int[][] chessArray = new int[LINE+2][LINE+2]; 
	
	public void showUI() {
		// 窗体对象,JFrame默认是边框布局
		JFrame jf = new JFrame();
		jf.setTitle("五子棋1.0");
		jf.setSize(800, 700);
		// 设置退出进程的方法
		jf.setDefaultCloseOperation(3);
		// 设置居中显示
		jf.setLocationRelativeTo(null);
		GamePanel gp = new GamePanel(chessArray);
		//设置棋盘背景色
		gp.setBackground(new Color(139,139,122));
		jf.add(gp,BorderLayout.CENTER);
		//设置东边的属性
		JPanel jp=new JPanel();
		jp.setBackground(new Color(245,245,245));
		jf.add(jp,BorderLayout.EAST);
		//设置东边流式布局的属性
		java.awt.FlowLayout fl=new java.awt.FlowLayout(5,5,60);
		jp.setLayout(fl);
		Dimension di=new Dimension(120,0);
		jp.setPreferredSize(di);
		//设置东边的按钮及按钮的属性
		javax.swing.JButton jbu1=new javax.swing.JButton("开始游戏");
		Dimension di1=new Dimension(100,60);
		jbu1.setPreferredSize(di1);
		jp.add(jbu1);
		javax.swing.JButton jbu2=new javax.swing.JButton("人人对战");
		Dimension di2=new Dimension(100,60);
		jbu2.setPreferredSize(di2);
		jp.add(jbu2);
		javax.swing.JButton jbu3=new javax.swing.JButton("人机对战");
		Dimension di3=new Dimension(100,60);
		jbu3.setPreferredSize(di3);
		jp.add(jbu3);
		javax.swing.JButton jbu4=new javax.swing.JButton("悔棋");
		Dimension di4=new Dimension(100,60);
		jbu4.setPreferredSize(di4);
		jp.add(jbu4);
		javax.swing.JButton jbu5=new javax.swing.JButton("重新开始");
		Dimension di5=new Dimension(100,60);
		jbu5.setPreferredSize(di5);
		jp.add(jbu5);
		jf.setVisible(true);
		//设置棋盘的画笔
		Graphics g = gp.getGraphics();
		GameMouse mouse = new GameMouse(g,chessArray,gp);
		
		//设置按钮的动作监听器
		jbu1.addActionListener(mouse);
		jbu2.addActionListener(mouse);
		jbu3.addActionListener(mouse);
		jbu4.addActionListener(mouse);
		jbu5.addActionListener(mouse);
		
	}
	
	public static void main(String[] args) {
		GameUI ui = new GameUI();
		ui.showUI();
	}

}
