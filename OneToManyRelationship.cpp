#include <iostream>
#include <string>
using namespace std;

class Address {
public:
    Address(){
        detail = "";
        area = city = country = "";
        cout << "Constructor is called ............." << endl;
    }
    Address(string detail, string area, string city, string country) {
        this->detail = detail;
        this->area = area;
        this->city = city;
        this->country = country;
        cout << "Address Overloaded Constructor is called ............." << endl;
    }
    int getDetail() const{
        return detail;
    }
private:
    string detail;
    string area, city, country;

};

int main()
{
    Address a;
}
