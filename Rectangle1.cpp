#include <iostream>
#include <string>
using namespace std;

class Rectangle {
private:
	float length, width;
public:
	Rectangle() {
		length = width = 1.0;
	}
	Rectangle(float l,float w) {
		length = l;
		width = w;
	}
	/*void setL(float l) {
		length = l;
	}
	float getL() {
		return length;
	}
	void setW(float w) {
		width = w;
	}
	float getW() {
		return width;
	}*/
	void display() {
		cout << "\nLength : " << length << endl;
		cout << "Width : " << width << endl;
	}
	void area() {
		cout << "\nArea :" << length * width << endl;
	}
	void perimeter() {
		cout << "\nPerimeter : " << 2 * (length + width) << endl;
	}
	void compute() {
		while (length >= 20.0 || length <= 0.0 || width >= 20.0 || width <= 0.0) {
			if (length >= 20.0 ) {
				cout << "\nMax length can be 19.0 " << endl;
				cout << "Enter the length again : ";
				cin >> length;
				compute();
			}
			else if ( width >= 20.0) {
				cout << "\nMax width can be 19.0 " << endl;
				cout << "Enter the width again : ";
				cin >> width;
				compute();
			}
			if (length <= 0.0) {
				cout << "\nMin length can be 1.0 " << endl;
				cout << "Enter the length again : ";
				cin >> length;
				compute();
			}
			else if (width <= 0.0) {
				cout << "\nMin width can be 1.0 " << endl;
				cout << "Enter the width again : ";
				cin >> width;
				compute();
			}
		}
	}
};

int main() {
	Rectangle r(2, 4);
	r.compute();
	r.display();
	r.area();
	r.perimeter();
	return 0;
}