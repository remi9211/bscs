#include <iostream>
#include <string>
using namespace std;

class Time {
private:
    int hour, sec, min;
    string ampm;
public:
    Time() {
        hour = 0;
        sec = 0;
        min = 0;
        ampm = "p";
    }
    Time(int h, int m, int s, string t) {
        hour = h;
        sec = s;
        min = m;
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
    void display() {
        cout << "Hour  : " << hour << endl;
        cout << "Minute : " << min << endl;
        cout << "Second : " << sec << endl;
        cout << "Meridiem : " << ampm << endl;
        cout << endl << endl;
    }
    void compute() {
        while (hour > 12 || hour < 1) {
            if (hour > 12) {
                cout << "\nMax number of hours is 12 " << endl;
                cout << "Enter the number of hours : ";
                cin >> hour;
                cout << endl;
                compute();
            }
            else if (hour < 1) {
                cout << "\nMin number of hours is 1 " << endl;
                cout << "Enter the number of hours : ";
                cin >> hour;
                cout << endl;
                compute();
            }
        }
        while (min > 59 || min < 0) {
            if (min > 59) {
                cout << "\nMax number of minutes is 59 " << endl;
                cout << "Enter the number of minutes : ";
                cin >> min;
                cout << endl;
                compute();
            }
            else if (min < 0) {
                cout << "\nMin number of minutes is 0 " << endl;
                cout << "Enter the number of minutes : ";
                cin >> min;
                cout << endl;
                compute();
            }
        }
        while (sec > 59 || sec < 0) {
            if (sec > 59) {
                cout << "\nMax number of seconds is 59 " << endl;
                cout << "Enter the number of seconds : ";
                cin >> sec;
                cout << endl;
                compute();
            }
            else if (sec < 0) {
                cout << "\nMin number of seconds is 0 " << endl;
                cout << "Enter the number of seconds : ";
                cin >> sec;
                cout << endl;
                compute();
            }
        }
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
            if (ampm == "pm" && hour >= 12) {
                ampm = "am";
            }
            else if (ampm == "am" && hour >= 12) {
                ampm = "pm";
            }

            display();
        }
    }
};
int main()
{
    Time t1(12, 59, 00, "am");
    t1.compute();
    t1.display();
    t1.tick();
    return 0;
}
