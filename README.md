# tic-tac-toe
This is the first game project created by me by using Java.In this , you play tic tac toe with the cpu as cpu generates random positions in the 3X3 tic tac toe table and keeps them as '0'. Player has to mark his places as 'X' and whoever makes a diagonal, horizontal or vertical line is made in the 3X3 tic tac toe table, that player wins.

#### Main
We have created an arraylist of player positions and cpu positions and stored them in playerPositions and cpuPositions respectively.
Then we have made character array for displaying the gameBoard and then print that array for showing our gameBoard by a method which we have named printGameBoard.
We have used infinite while loop so that our game runs. We have made an object of Scanner class and named it as sc and then we have asked position from the player using Scanner object. If the position is occupied, then the player is told that the position is taken and he/she should choose some other position to place his mark.
We have placed the piece in the gameboard at empty positions using placePiece method and then we check whether player won or not by checkWinner method and if someone wins, then the while loop is broken.
Similar work is done for the cpu but instead of scanner we have used random class now as cpu mark is randomly generated. As random generates a number starting from 0. So we have generated 9 random positions from 0 to 8 and then added 1 to make it 1-9.
And again placing the piece , printing the game board after placing the piece and checking if cpu won and if it does , then break the loop.

#### printGameBoard
It takes 2X2 char array and then prints that array.

#### placePiece
It takes game board array , position where the mark is to be inserted and the user of whom that mark is inserted as argument. If user is player, then it marks X on the tic tac toe table and if the user is cpu, it marks 0 on the tic tac toe table by using switch case.

#### checkWinner
It takes character array of game board as argument and converts each vertical , diagonal and horizontal line into  list entity.Then it adds those entities into a list which we have named winning. Then we check for each winning list, if player or cpu contains any of the list wholly , then that player wins and if whole of the game is over and no winning list entity is made, then it is a tie in the game and that is displayed.
