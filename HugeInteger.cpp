#include <iostream>
#include <string>
using namespace std;
class HugeInteger {
public:
    HugeInteger() {
        ptr = new int[size];
        init();
    }
    HugeInteger(string str) {
        ptr = new int[size];
        init();
        int s = str.length();
        int index = size - s;
        for (int i = index, j = 0; i < size; i++, j++) {
            ptr[i] = str[j] - 48;
        }
    }
    void init() {
        for (int i = 0; i < size; ++i) {
            ptr[i] = 0;
        }
    }

    void display() {
        for (int i = 0; i < size; ++i) {
            if (ptr[i] != 0)
                cout << ptr[i];
        }
    }

    HugeInteger add(HugeInteger h) {
        HugeInteger result ;
        for (int i = 0; i < size; i++) {
            result.ptr[i] = this->ptr[i] + h.ptr[i];
        }
        return result;
    }

    HugeInteger subtract(HugeInteger h) {
        HugeInteger result;
        for (int i = 0; i < size; i++) {
            result.ptr[i] = this->ptr[i] - h.ptr[i];
        }
        return result;
    }

    int equalto(HugeInteger h) {
        HugeInteger result;
        int x=0;
        for (int i = 0; i < size; i++) {
            if (this->ptr[i] != h.ptr[i]) {
                x = 1;
            }
            else {
                x = 0;
            }
        }
        //cout << "ASDASd" << x;
        return x;
    }

    bool notequalto(HugeInteger h) {
        HugeInteger result;
        bool x = true;
        for (int i = 0; i < size; i++) {
            if (this->ptr[i] = h.ptr[i]) {
                x = true;
            }
            else {
                x = false;
            }
        }
        return x;
    }

    bool greaterthan(HugeInteger h) {
        HugeInteger result;
        bool x = true;
        for (int i = 0; i < size; i++) {
            if (this->ptr[i] > h.ptr[i]) {
                x = true;
            }
            else {
                x = false;
            }
        }
        return x;
    }

    bool greaterthanequalto(HugeInteger h) {
        HugeInteger result;
        bool x = true;
        for (int i = 0; i < size; i++) {
            if (this->ptr[i] <= h.ptr[i]) {
                x = true;
            }
            else {
                x = false;
            }
        }
        return x;
    }

    bool lessthan(HugeInteger h) {
        HugeInteger result;
        bool x = true;
        for (int i = 0; i < size; i++) {
            if (this->ptr[i] < h.ptr[i]) {
                x = true;
            }
            else {
                x = false;
            }
        }
        return x;
    }

    bool lessthanequalto(const HugeInteger& h)const {
        bool x;
        for (int i = 0; i < size; i++) {
            if (this->ptr[i] == h.ptr[i]) {
                
            }
            else if (this->ptr[i] > h.ptr[i]) {
               x = false;
            }

            else if (this->ptr[i] == h.ptr[i]) {
                x = true;
            }

        }
        return x;
    }

private:
    int size = 40;
    int* ptr;
};
int main() {
    
    HugeInteger hugeInteger3;
    HugeInteger hugeInteger1("668899");
    HugeInteger hugeInteger2("223344");
    hugeInteger1.display();
    cout << endl;
    hugeInteger2.display();
    hugeInteger3 = hugeInteger1.add(hugeInteger2); //Addition
    cout << "\n\nAddition : "; 
    hugeInteger3.display();
   
    HugeInteger hugeInteger4;
    hugeInteger4 = hugeInteger1.subtract(hugeInteger2); //Subtract
    cout << "\n\nSubtraction  : ";
    hugeInteger4.display();
    cout << "\nIf Subtraction = 0, then it will display empty string";

    int y = hugeInteger1.equalto(hugeInteger2); //EqualTo ?
    if (y == 1) {
        cout << "\n\nBoth are equal : False" ;
    }
    else{// if(y == 0){
        cout << "\n\nBoth are equal : True";
    }

    bool z = hugeInteger1.notequalto(hugeInteger2); //NotEqualTo ?
    if (z == 0) {
        cout << "\n\nBoth are not equal : False";
    }
    else if (z == 1) {
        cout << "\n\nBoth are not equal : True";
    }

    bool a = hugeInteger1.greaterthan(hugeInteger2); //GreaterThan ?
    if (a == 1) {
        cout << "\n\nHugeInteger1 is greater than HugeInteger2 : True";
    }
    else if (a == 0) {
        cout << "\n\nHugeInteger1 is greater than HugeInteger2 : False";
    }

    bool b = hugeInteger1.lessthan(hugeInteger2); //LessThan ?
    if (b == 1) {
        cout << "\n\nHugeInteger1 is less than HugeInteger2 : True";
    }
    else if (b == 0) {
        cout << "\n\nHugeInteger1 is less than HugeInteger2 : False";
    }

    bool c = hugeInteger1.greaterthanequalto(hugeInteger2); //GreaterThanEqualTo ?
    if (c == 1) {
        cout << "\n\nHugeInteger1 is greater than or equal to HugeInteger2 : True";
    }
    else if (c == 0) {
        cout << "\n\nHugeInteger1 is greater than or equal to HugeInteger2 : False";
    }

    bool d = hugeInteger1.lessthanequalto(hugeInteger2); //LessThanEqualTo ?
    if (d == 1) {
        cout << "\n\nHugeInteger1 is less than or equal to HugeInteger2 : True";
    }
    else if (d == 0) {
        cout << "\n\nHugeInteger1 is less than or equal to HugeInteger2 : False"<<endl<<endl;
    }

return 0;
}