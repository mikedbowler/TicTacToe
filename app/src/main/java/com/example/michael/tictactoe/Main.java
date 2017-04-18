package com.example.michael.tictactoe;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String coordinates = "";
		boolean didMove = false;
		int numMoves=0;
		String name;
		
		
		System.out.println("Enter Player 1's name: ");
		name = br.readLine();
		Player x = new Player(name,'X');
		
		System.out.println("Enter Player 2's name: ");
		name = br.readLine();
		Player o = new Player(name,'O');
		
		Board board = new Board(x,o);
		
		while(board.result.equals(""))
		{
			if(board.turn==0)
			{
				System.out.println(x.name+", Enter coordinates: ");	
			}
			else
			{
				System.out.println(o.name+", Enter coordinates: ");
			}
			
			coordinates = br.readLine();
			
			didMove = board.move(coordinates.charAt(0)-'0', coordinates.charAt(1)-'0');
		
			if(didMove)
			{
				numMoves++;
				
				if(numMoves==9)
				{
					System.out.println("\nIt's a Draw!");
					break;
				}
				
				board.turn = (board.turn==0) ? 1 : 0;
			}
		}
		
		
		br.close();
	}

}
