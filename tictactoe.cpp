#include <iostream>
#include <string>
using namespace std;

char hori[] = { ' ', ' ', '-', '+', '-', '+',  '-', ' ' };
class tictactoe {
private:
	char frame[3][3];
	int moves;
	char player;
public:
	tictactoe() {
		moves = 9;
		player = '1';
	}
	void display() {
	cout << "  ";
		for (int i = 0; i < 3; i++) {
			cout << i << " ";
		}
		cout << endl;
		for (int row = 0; row < 3; row++) {
			cout << row << " ";		
			for (int col = 0; col < 3; col++) {
				cout << frame[row][col];
				if (col < 2){
					cout << "|";
				}
			}
			cout << endl;
			if (row < 2){
				cout << hori << endl;
				}
		}
		cout << endl;
	}
	void init_board() {
		for (int row = 0; row < 3; row++)		
			for (int col = 0; col < 3; col++)
				frame[row][col] = ' ';
	}
	void move() {
		while (moves > 0)	
		{
			display();
			get_move();
			win();
			moves--;				
			player = (player == '1') ? '2' : '1';
		}
	}
	void get_move()
	{
		int	row;
		int	col;
		cout << "Move for player: " << player << endl;
		do {
			cout << "Row: ";
			cin >> row;
			if (row == -1)
				exit(0);				
			cout << "Col: ";
			cin >> col;
			if (col == -1)
				exit(0);				
			if (row == -1 && col == -1)
				exit(0);
		} while (frame[row][col] != ' ' || row < 0 || row > 3 || col < 0 || col > 3);
		frame[row][col] = player;
	}
	void win()
	{
		char result = test();
		if (result == '1' || result == '2')
		{
			display();
			cout << "Player "<< result << " wins!" << endl;
			exit(0);
		}
	}
	char test()
	{
		for (int row = 0; row < 3; row++)
		{
			if (frame[row][0] == ' ') {
				continue;
			}
			if (frame[row][0] == frame[row][1] && frame[row][1] == frame[row][2]){
				return frame[row][0];
			}
		}
		for (int col = 0; col < 3; col++)
		{
			if (frame[0][col] == ' '){
				continue;
			}
			if (frame[0][col] == frame[1][col] && frame[1][col] == frame[2][col]){
				return frame[0][col];
			}
		}
		if (frame[0][0] == frame[1][1] && frame[1][1] == frame[2][2]){
			return frame[0][0];			
		}
		if (frame[0][2] == frame[1][1] && frame[1][1] == frame[2][0]) {
			return frame[0][2];
		}
		return ' ';
	}
};
int main()
{
	cout << "-----This is game of Tic Tac Toe-----" << endl;
	tictactoe game;
	game.display();
	game.init_board();
	game.move();
	return 0;
}