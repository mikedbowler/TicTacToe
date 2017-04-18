package com.example.michael.tictactoe;

public class Board {
	
	String[][] board;
	int turn; //0 = X's turn, 1 = O's turn
	String result;
	int[] lastMove;
	Player X,O;

	public Board(Player X, Player O)
	{
		this.board = new String[3][3];
		this.turn = 0;
		this.result = "";
		this.lastMove = new int[2];
		this.X = X;
		this.O = O;
		
		initializeBoard();
	}
	
	public boolean isWin()
	{
		int x = lastMove[0];
		int y = lastMove[1];
	    char symbol = turn==0 ? 'X' : 'O';
	    
	    if(checkRow(symbol, x) || checkColumn(symbol, y) || checkDiagonal(symbol))
	    {
	    	return true;
	    }
		
		return false;
	}
	
	public boolean checkRow(char symbol, int x)
	{
		String row = (board[x][0]+board[x][1]+board[x][2]).replaceAll(" ","");
		
		if(row.length()==3 && row.equals(""+symbol+symbol+symbol))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean checkColumn(char symbol, int y)
	{
		String col = (board[0][y]+board[1][y]+board[2][y]).replaceAll(" ","");
				
		if(col.length()==3 && col.equals(""+symbol+symbol+symbol))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean checkDiagonal(char symbol)
	{	
		String diag1 = (board[0][0]+board[1][1]+board[2][2]).replaceAll(" ","");
		String diag2 = (board[0][2]+board[1][1]+board[2][0]).replaceAll(" ","");
		
		if(diag1.length()==3 && diag1.equals(""+symbol+symbol+symbol))
		{
			return true;
		}
		else if(diag2.length()==3 && diag2.equals(""+symbol+symbol+symbol))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean move(int x, int y)
	{
		if((x<0 || x>2 || y<0 || y>2) || !board[x][y].equals("   "))
		{
			System.out.println("Illegal Move, Try Again!\n");
			drawBoard();
			return false;
		}
		
		String symbol = (turn==0 ? 'X' : 'O')+"";
		board[x][y] = " "+symbol+" ";
		
		lastMove[0] = x;
		lastMove[1] = y;
		
		drawBoard();
		
		if(isWin())
		{
			String winner = turn==0 ? X.name : O.name;
			System.out.println("\nCongratulations! "+winner+" wins!");
			System.exit(0);
		}
		
		return true;
	}
	
	public void initializeBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j] = "   ";
			}	
		}
	}
	
	public void drawBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j].equals("   "))
				{
					if(j<2)
					{
						System.out.print(board[i][j]+"|");
					}
					else
					{
						System.out.print(board[i][j]);
					}
				}
				else
				{
					if(j<2)
					{
						System.out.print(board[i][j]+"|");
					}
					else
					{
						System.out.print(board[i][j]);
					}
				}
			}
			
			if(i<2)
			{
				System.out.println("\n___________");
			}
			else
			{
				System.out.println();
			}
		}
	}
}
