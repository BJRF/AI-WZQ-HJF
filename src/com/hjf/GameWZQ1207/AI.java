package com.hjf.GameWZQ1207;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.HashMap;

import javax.swing.JPanel;

public class AI extends MouseAdapter implements Config {
	private int maxi = 0, maxj = 0;
	private JPanel j;
	private Graphics g;
	private int[][] chessArray = new int[LINE + 2][LINE + 2]; // 保存棋子的二维数组
	private int[][] chessValue = new int[LINE + 2][LINE + 2]; // 保存权值的二维数组
	HashMap<String, Integer> hm = new HashMap<String, Integer>();

	public AI(Graphics g, int[][] chessArray, JPanel j) {
		this.g = g;
		this.chessArray = chessArray;
		this.j = j; // 设置不同情况时的权值

		hm.put("-1", 20);
		hm.put("-1-1", 400);
		hm.put("-1-1-1", 420);
		hm.put("-1-1-1-1", 3000);
		hm.put("-11", 4);
		hm.put("-1-11", 40);
		hm.put("-1-1-11", 400);
		hm.put("-1-1-1-11", 10000);
		hm.put("1-1-1-1-1", 10000);
		hm.put("1", 8);
		hm.put("11", 80);
		hm.put("111", 1000);
		hm.put("1111", 5000);
		hm.put("1111-1", 5000);
		hm.put("1111-1-1", 5000);
		hm.put("1-1", 6);
		hm.put("11-1", 60);
		hm.put("111-1", 600);
		hm.put("-11-1", 5);
		hm.put("-111-1", 5);
		hm.put("1-1-11", 5);
		hm.put("1-11", 5);
	}

	public int getmaxi() {
		return maxi;
	}

	public int getmaxj() {
		return maxj;
	}

	public void ai() {
		for (int i = 0; i < LINE; i++) {
			for (int j = 0; j < LINE; j++) {
				if (chessArray[i][j] == 0) {
					String code = "";
					int color = 0;
					// 向右
					for (int k = i + 1; k < 15; k++) {
						if (chessArray[Math.abs(k)][j] == 0) {
							break;
						} else {
							if (color == 0) { // 右边第一颗棋子
								color = chessArray[Math.abs(k)][j]; // 保存颜色
								code += chessArray[Math.abs(k)][j]; // 保存棋子相连情况
							} else if (chessArray[Math.abs(k)][j] == color) {
								code += chessArray[Math.abs(k)][j]; // 保存棋子相连情况
							} else {
								code += chessArray[Math.abs(k)][j]; // 保存棋子相连情况
								break;
							}
						}
						if (chessArray[i][j] != 0) {
							chessValue[i][j] = 0;
						}
					}
					Integer value = hm.get(code);
					if (value != null) {
						chessValue[i][j] += value;
					}
					if (value != null) {
						chessValue[i][j] += value;
					}
					// 向左
					code = "";
					color = 0;
					for (int k = i - 1; k >= 0; k--) {
						if (chessArray[Math.abs(k)][j] == 0) {
							break;
						} else {
							if (color == 0) { // 左边第一颗棋子
								color = chessArray[Math.abs(k)][j]; // 保存颜色
								code += chessArray[Math.abs(k)][j]; // 保存棋子相连情况
							} else if (chessArray[Math.abs(k)][j] == color) {
								code += chessArray[Math.abs(k)][j]; // 保存棋子相连情况
							} else {
								code += chessArray[Math.abs(k)][j]; // 保存棋子相连情况
								break;
							}
						}

					}
					value = hm.get(code);
					if (value != null) {
						chessValue[i][j] += value;
					}
					if (chessArray[i][j] != 0) {
						chessValue[i][j] = 0;
					}
					// 向上
					code = "";
					color = 0;
					for (int k = j - 1; k >= 0; k--) {
						if (chessArray[i][Math.abs(k)] == 0) {
							break;
						} else {
							if (color == 0) { // 左边第一颗棋子
								color = chessArray[i][Math.abs(k)]; // 保存颜色
								code += chessArray[i][Math.abs(k)]; // 保存棋子相连情况
							} else if (chessArray[i][Math.abs(k)] == color) {
								code += chessArray[i][Math.abs(k)]; // 保存棋子相连情况
							} else {
								code += chessArray[i][Math.abs(k)]; // 保存棋子相连情况
								break;
							}
						}

					}
					value = hm.get(code);
					if (value != null) {
						chessValue[i][j] += value;
					}
					if (chessArray[i][j] != 0) {
						chessValue[i][j] = 0;
					}
					// 向下
					code = "";
					color = 0;
					for (int k = j + 1; k < LINE; k++) {
						if (chessArray[i][Math.abs(k)] == 0) {
							break;
						} else {
							if (color == 0) { // 左边第一颗棋子
								color = chessArray[i][Math.abs(k)]; // 保存颜色
								code += chessArray[i][Math.abs(k)]; // 保存棋子相连情况
							} else if (chessArray[i][Math.abs(k)] == color) {
								code += chessArray[i][Math.abs(k)]; // 保存棋子相连情况
							} else {
								code += chessArray[i][Math.abs(k)]; // 保存棋子相连情况
								break;
							}
						}

					}
					value = hm.get(code);
					if (value != null) {
						chessValue[i][j] += value;
					}
					if (chessArray[i][j] != 0) {
						chessValue[i][j] = 0;
					}
					// 右下
					code = "";
					color = 0;
					for (int k = i + 1, l = j + 1; k < LINE || l < LINE; k++, l++) {
						if (chessArray[Math.abs(k)][Math.abs(l)] == 0) {
							break;
						} else {
							if (color == 0) { // 左边第一颗棋子
								color = chessArray[Math.abs(k)][Math.abs(l)]; // 保存颜色
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
							} else if (chessArray[Math.abs(k)][Math.abs(l)] == color) {
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
							} else {
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
								break;
							}
						}

					}
					value = hm.get(code);
					if (value != null) {
						chessValue[i][j] += value;
					}
					if (chessArray[i][j] != 0) {
						chessValue[i][j] = 0;
					}
					// 右上
					code = "";
					color = 0;
					for (int k = i + 1, l = j - 1; k < LINE || l >= 0; k++, l--) {
						if (chessArray[Math.abs(k)][Math.abs(l)] == 0) {
							break;
						} else {
							if (color == 0) { // 左边第一颗棋子
								color = chessArray[Math.abs(k)][Math.abs(l)]; // 保存颜色
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
							} else if (chessArray[Math.abs(k)][Math.abs(l)] == color) {
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
							} else {
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
								break;
							}
						}

					}
					value = hm.get(code);
					if (value != null) {
						chessValue[i][j] += value;
					}
					if (chessArray[i][j] != 0) {
						chessValue[i][j] = 0;
					}
					// 左上
					code = "";
					color = 0;
					for (int k = i - 1, l = j - 1; k >= 0 || l >= 0; k--, l--) {
						if (chessArray[Math.abs(k)][Math.abs(l)] == 0) {
							break;
						} else {
							if (color == 0) { // 左边第一颗棋子
								color = chessArray[Math.abs(k)][Math.abs(l)]; // 保存颜色
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
							} else if (chessArray[Math.abs(k)][Math.abs(l)] == color) {
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
							} else {
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
								break;
							}
						}

					}
					value = hm.get(code);
					if (value != null) {
						chessValue[i][j] += value;
					}
					if (chessArray[i][j] != 0) {
						chessValue[i][j] = 0;
					}
					// 左下
					code = "";
					color = 0;
					for (int k = i - 1, l = j + 1; k >= 0 || l < LINE; k--, l++) {
						if (chessArray[Math.abs(k)][Math.abs(l)] == 0) {
							break;
						} else {
							if (color == 0) { // 左边第一颗棋子
								color = chessArray[Math.abs(k)][Math.abs(l)]; // 保存颜色
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
							} else if (chessArray[Math.abs(k)][Math.abs(l)] == color) {
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
							} else {
								code += chessArray[Math.abs(k)][Math.abs(l)]; // 保存棋子相连情况
								break;
							}
						}

					}
					value = hm.get(code);
					if (value != null) {
						chessValue[i][j] += value;
					}
					if (chessArray[i][j] != 0) {
						chessValue[i][j] = 0;
					}
				}
			}
		}

		for (int j = 0; j < LINE; j++) {
			for (int i = 0; i < LINE; i++) {
				System.out.print(chessValue[i][j] + "  ");
			}
			System.out.println();
		}
		for (int j = 0; j < LINE; j++) {
			for (int i = 0; i < LINE; i++) {
				System.out.print(chessArray[i][j] + "  ");
			}
			System.out.println();
		}
		// 判断权值最大的位置，并在该位置下棋。
		int maxv = 0;
		for (int i = 0; i < LINE; i++) {
			for (int j = 0; j < LINE; j++) {
				if (maxv < chessValue[i][j]) {
					maxv = chessValue[i][j];
					maxi = i;
					maxj = j;
				}
			}
		}
		//画白棋
		g.setColor(Color.WHITE);
		g.fillOval(maxi * SIZE + X - CHESS / 2, maxj * SIZE + Y - CHESS / 2,CHESS, CHESS);
		chessArray[maxi][maxj] = 1;
		System.out.println("x" + maxi + "y" + maxj);
		for (int i = 0; i < LINE; i++) {
			for (int j = 0; j < LINE; j++) {
				chessValue[i][j] = 0;
			}
		}
	}
}
