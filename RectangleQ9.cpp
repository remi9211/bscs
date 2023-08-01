#include <iostream>
#include <string>
using namespace std;

class RectangleQ {
private:
	float px1, px2, px3, px4, py1, py2, py3, py4, length, width;
public:
	RectangleQ() {
		length = width = px1 = px2 = px3 = px4 = py1 = py2 = py3 = py4 = 0.0;
	}
	RectangleQ(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
		px1 = x1; px2 = x2; px3 = x3; px4 = x4;
		py1 = y1; py2 = y2; py3 = y3; py4 = y4;
	}
	void setL(float l, float w) {
		length = l;
		width = w;
	}
	void display() {
		float a;
		cout << "P1(" << px1 << "," << py1 << ")" << endl;
		cout << "P2(" << px2 << "," << py2 << ")" << endl;
		cout << "P3(" << px3 << "," << py3 << ")" << endl;
		cout << "P4(" << px4 << "," << py4 << ")" << endl;
		length = px2 - px1;
		width = py1 - py4;
		if (length < width) {
			a = length;
			length = width;
			width = a;
		}
		cout << "\nLength :" << length << endl;
		cout << "Width : " << width << endl;
		draw(length,width);
	}
	void area() {
		cout << "\nArea :";
		cout << length * width;
	}
	void perimeter() {
		cout << "\nPerimeter :";
		cout << 2 * (length + width) << endl;
	}
	void compute() {
		while (px1 > 20.0 || px2 > 20.0 || px3 > 20.0 || px4 > 20.0 || py1 > 20.0 || py2 > 20.0 || py3 > 20.0 || py4 > 20.0) {
			if (px1 > 20.0) {
				cout << "Your value of x1 exceeds the limit which is 20.0 : ";
				cin >> px1;
			}
			else if (px2 > 20.0) {
				cout << "Your value of x2 exceeds the limit which is 20.0 : ";
				cin >> px2;
			}
			else if (px3 > 20.0) {
				cout << "Your value of x3 exceeds the limit which is 20.0 : ";
				cin >> px3;
			}
			else if (px4 > 20.0) {
				cout << "Your value of x4 exceeds the limit which is 20.0 : ";
				cin >> px4;
			}
			else if (py1 > 20.0) {
				cout << "Your value of y1 exceeds the limit which is 20.0 : ";
				cin >> py1;
			}
			else if (py2 > 20.0) {
				cout << "Your value of y2 exceeds the limit which is 20.0 : ";
				cin >> py2;
			}
			else if (py3 > 20.0) {
				cout << "Your value of y3 exceeds the limit which is 20.0 : ";
				cin >> py3;
			}
			else if (py4 > 20.0) {
				cout << "Your value of y4 exceeds the limit which is 20.0 : ";
				cin >> py4;
			}
			compute();
		}
	}
	void isitrect() {
		if (px1 == px4 && py1 == py2 && px2 == px3 && py3 == py4) {
			cout << "---- It is a rectangle ----" << endl;
		}
		else {
			cout << "It is not a rectangle " << endl;
			cout << "\nThe conditions for it to be a rectangle are : " << endl;
			cout << "1. x1 should be equal to x4 \n2. y1 should be equal to y2 \n3. x2 should be equal to x3\n4. y3 should be equal to y4" << endl << endl;
			rect();
		}
	}
	void rect() {
		while (px1 != px4 || py1 != py2 || px2 != px3 || py3 != py4) {
			cout << "Enter all the values again " << endl;
			cout << "x1:";
			cin >> px1;
			cout << "y1:";
			cin >> py1;
			cout << "x2:";
			cin >> px2;
			cout << "y2:";
			cin >> py2;
			cout << "x3:";
			cin >> px3;
			cout << "y3:";
			cin >> py3;
			cout << "x4:";
			cin >> px4;
			cout << "y4:";
			cin >> py4;
			cout << endl;
			isitrect();
		}
	}
	void draw(int length,int width) {
		cout << endl;
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < length; j++) {
					cout << "+";
				}
				cout << endl;
			}
	}
};
int main() {
	RectangleQ rq(10, 10, 17, 10, 17, 5, 10, 5);
	rq.isitrect();
	rq.compute();
	rq.display();
	rq.area();
	rq.perimeter();
	return 0;
}