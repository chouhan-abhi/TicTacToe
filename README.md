# TicTacToe
A Simple Tic Tac Toe game on java

Its a Simple cli based 3 x 3 board, 2 Player game.

The Player in turns are promt to select a valid cell to keep the game running.
The game ends when either all the cells are consumed (In case of Draw) or one of the player won.

The outline of the game is as below.
class 
* TicTacToe

Properties
* board
* turn

Methods
* main
* printBoard
* checkWinner


Rule to win
Assume a board of 3 * 3
      1 2 3
      4 5 6
      7 8 9
cell 5 can be expressed in co-ordinates ("1,1");
to check if a player won.
after every turn we check if co-ordinate in diagonal, horizontal or vertical is of the current player token.
if yes then win else the game continues.
