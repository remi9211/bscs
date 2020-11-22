#include <iostream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
using namespace std;
int daysinmonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

class DateAndTime {
private:
	int day, month, year;
	int sec, min, hour;
	string ampm;
public:
	DateAndTime() {
		day = month, year = sec = min = hour = 0;
		ampm = "";
	}
	DateAndTime(int h, int mi, int s, string t, int d,int m,int y ){
		day = d;
		month = m;
		year = y;
		sec = s;
		min = mi;
		hour = h;
		ampm = t;
	}
	int setHour(int h) {
		hour = h;
    }
	int getHour() {
        return hour;
    }
	int setMin(int m) {
		min = m;
    }
	int getMin() {
        return min;
    }
    int setSec(int s) {
        sec = s;
    }
	int getSec() {
		return sec;
    }
    string getAmpm() {
       return ampm;
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
		cout << "\nDay : Month : Year :-  " << day << " : " << month << " : " << year << endl;
		cout << "Hour : Minute : Seconds : Meridiem :-  " << hour <<" : " << min << " : " << sec << " : " << ampm << endl;
	}
	void tick() {
		int t;
		cout << "Enter seconds to add : ";
        cin >> t;
        for (int x = 1; x <= t; x++) {
		sec++;
			if (sec >= 60) {
				min++;
				sec = 0;
			}
			if (min >= 60) {
				hour++;
				min = 0;
			}
			if (hour > 12) {
				hour = 1;
			}
			if (ampm == "pm" && hour >= 12) {                    //ampm logic
				ampm = "am";
				day++;
			}
			else if (ampm == "am" && hour >= 12) {               //ampm logic
				ampm = "pm";
			}
		display();
        }
	//display();
	}
};
int main() {
	DateAndTime td(11, 59, 00, "pm", 16, 11, 2020);
	td.display();
	td.tick();
}





