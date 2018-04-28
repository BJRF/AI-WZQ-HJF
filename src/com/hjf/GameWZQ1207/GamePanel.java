package com.hjf.GameWZQ1207;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class GamePanel extends JPanel implements Config{
	private int[][] chessArray;
	
	public GamePanel(int[][] chessArray){
		this.chessArray = chessArray;
	}
	public void paint(Graphics g){
		super.paint(g);
		//÷ÿªÊ∆Â≈Ã
		//”≤±‡¬Î
		for(int i=0;i<LINE;i++){
			g.drawLine(X, Y+i*SIZE, (LINE-1)*SIZE+X, Y+i*SIZE);
			g.drawLine(X+i*SIZE, Y, X+i*SIZE, (LINE-1)*SIZE+Y);
		}
		paintChess(g);
	}
	/**
	 * ÷ÿªÊ∆Â◊”
	 * @param g
	 */
	public void paintChess(Graphics g){
		for(int i=0;i<chessArray.length;i++){
			for(int j=0;j<chessArray[i].length;j++){
				if(chessArray[i][j] == 1){
					g.setColor(Color.WHITE);
					g.fillOval(i * SIZE + X - CHESS / 2, j * SIZE + Y - CHESS / 2, CHESS, CHESS);
				}else if(chessArray[i][j] == -1){
					g.setColor(Color.BLACK);
					g.fillOval(i * SIZE + X - CHESS / 2, j * SIZE + Y - CHESS / 2, CHESS, CHESS);
				}
			}
		}
	}
}
