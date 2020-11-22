#include <iostream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
using namespace std;
int daysinmonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

class date {
private:
	int day, month, year;
public:
	date() {
		day = month = year = 0;
	}
	date(int d, int m,int y) {
		day = d;
		month = m;
		year = y;
		if (day >= daysinmonth[month-1]) {
			cout << "Please enter a valid number of days......"<<endl;
			dinm();
		}
	}
	void setDay(int d) {
		day = d;
	}
	int getDay() {
		return day;
	}
	void setMonth(int m) {
		month = m;
	}
	int getMonth() {
		return month;
	}
	void setYear(int y) {
		year = y;
	}
	int getYear() {
		return year;
	}
	void display() {
		cout << "Day : " << day << endl;
		cout << "Month : " << month << endl;
		cout << "Year : " << year << endl << endl;
	}
	void compute() {
		int nd;
		cout << "Enter the days you want to add : ";
		cin >> nd;
		cout << endl;
		for (int i = 1; i <= nd; i++) {
			day++;
			if (day > daysinmonth[month-1]) {
				day = 1;
				month++;
				if (month > 12) {
					month = 1;
					year++;
				}
			}
		
		display();
		}
		//display();
	}
	void dinm() {
		if (month == 2 ) {
			cout << "There can only be 28 days in this month" << endl;
		}
		else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			cout << "There can only be 31 days in this month" << endl;
		}
		else if (month == 4 || month == 6 || month == 9 || month == 11){
			cout << "There can only be 30 days in this month" << endl;
		}
	}

};
int main()
{
	date d1(18, 11, 2020);
	d1.display();
	d1.compute();
	return 0;
}
