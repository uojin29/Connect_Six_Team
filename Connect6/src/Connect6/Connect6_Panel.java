package Connect6;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.*;

public class Connect6_Panel extends JPanel {
	private Ellipse2D.Double ellipse[][] = new Ellipse2D.Double[19][19];
	private JLabel status = new JLabel();
	private int checkColor[][] = new int[19][19];
	private int clickCount = 0;
	private String[] cColor = { "", "흑돌", "백돌", "적돌" };
	private int winColor = 0;
	Color c;
	static ArrayList<List> list = new ArrayList<List>();

	Connect6_Panel() {

	}

	class List {
		Color c;
		Ellipse2D fill;

		public List(Color c, Ellipse2D fill) {
			this.c = c;
			this.fill = fill;
		}
	}

	public void createPanel() {
		Color b_color = new Color(204, 153, 0);
		this.setBounds(125, 0, 950, 950);
		status.setBounds(950, 650, 100, 100);
		this.add(status);
		this.setBackground(b_color);
		this.addMouseListener(new MyMouseListener());
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke((float) (2.0), BasicStroke.CAP_ROUND, 0));
		g2.setColor(Color.BLACK);
		for (int i = 0; i < 19; i++) {
			g2.drawLine(25 + 50 * i, 25, 25 + 50 * i, 925);// 세로선
			g2.drawLine(25, 25 + 50 * i, 925, 25 + 50 * i);// 가로선
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				ellipse[i][j] = new Ellipse2D.Double(50 - 25 + i * 900 / 18 - 50 / 2, 50 - 25 + j * 900 / 18 - 50 / 2, 50, 50);
			}
		}
		for (List c : list) {
			g2.setColor(c.c);
			g2.fill(c.fill);
		}

	}

	public int checkFinishGo(int x, int y) {
		if (checkHorizontal(x, y, checkColor[x][y]) >= 6) {
			return checkColor[x][y];
		} else if (checkVertical(x, y, checkColor[x][y]) >= 6) {
			return checkColor[x][y];
		} else if (checkLRDiagonal(x, y, checkColor[x][y]) >= 6) {
			return checkColor[x][y];
		} else if (checkRLDiagonal(x, y, checkColor[x][y]) >= 6) {
			return checkColor[x][y];
		}
		return 0;
	}

	private int checkHorizontal(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return checkLeft(row - 1, col, color) + 1 + checkRight(row + 1, col, color);
			}
		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkLeft(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return 1 + checkLeft(row - 1, col, color);
			}
		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkRight(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return 1 + checkRight(row + 1, col, color);
			}

		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkVertical(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return checkUp(row, col - 1, color) + 1 + checkDown(row, col + 1, color);
			}
		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkUp(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return 1 + checkUp(row, col - 1, color);
			}

		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkDown(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return 1 + checkDown(row, col + 1, color);
			}

		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkLRDiagonal(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return checkLU(row - 1, col - 1, color) + 1 + checkRD(row + 1, col + 1, color);
			}
		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkLU(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return 1 + checkLU(row - 1, col - 1, color);
			}

		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkRD(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return 1 + checkRD(row + 1, col + 1, color);
			}

		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkRLDiagonal(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return checkRU(row + 1, col - 1, color) + 1 + checkLD(row - 1, col + 1, color);
			}
		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkRU(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return 1 + checkRU(row + 1, col - 1, color);
			}

		} catch (StackOverflowError e) {
			return 0;
		}
	}

	private int checkLD(int row, int col, int color) {
		try {
			if (checkColor[row][col] != color)
				return 0;
			else {
				return 1 + checkLD(row - 1, col + 1, color);
			}

		} catch (StackOverflowError e) {
			return 0;
		}
	}

	class MyMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			for (int i = 0; i < 19; i++) {
				for (int j = 0; j < 19; j++) {
					for (List c : list) {
						if (c.fill.contains(e.getPoint())) {
							return;
						}
					}
					if (ellipse[i][j].contains(e.getPoint())) {
						if (MainFrame.noStart > list.size()) {
							c = Color.RED;
							checkColor[i][j] = 3;
						} else {
							if (clickCount == 0) {
								c = Color.BLACK;
								checkColor[i][j] = 1;
								clickCount++;
							} else {
								if (clickCount % 4 == 2 || clickCount % 4 == 3) {
									c = Color.WHITE;
									checkColor[i][j] = 2;
								} else {
									c = Color.BLACK;
									checkColor[i][j] = 1;
								}
							}
							clickCount++;
						}
						// 클릭되었을 때 승리했으면 승리했다고 표시할 것.
						list.add(new List(c, ellipse[i][j]));
						if (list.size() < MainFrame.noStart) status.setText("착수금지돌");
						else if (list.size() - MainFrame.noStart == 0) status.setText("흑돌");
						else if (list.size() - MainFrame.noStart == 1) status.setText("백돌");
						else if (((list.size() + 1 - MainFrame.noStart )/ 2) % 2 == 0) status.setText("흑돌");

						else status.setText("백돌");
						winColor = checkFinishGo(i, j);

						Connect6_Panel.this.repaint();
						if (winColor != 0) {
							JOptionPane.showMessageDialog(null, cColor[winColor] + " 승리", "Message", JOptionPane.PLAIN_MESSAGE);
						}
						break;
					}
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
}
