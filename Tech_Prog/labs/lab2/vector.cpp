#include <cmath>
#include <iostream>
#include <string>

using namespace std;

class Vector{

private:

int id;
int dimension;
struct point{
point *next;
float value;

};
point *first;

public:
static int amount_of_vectors;
//===================================DES\CONSTRUCTORS=============================
Vector(){}

Vector(float n){
point *coord = new point;
first = coord;
first->value = n;
this->id = amount_of_vectors + 1;
amount_of_vectors++;
first->next = NULL;
}

~Vector(){}
//========================================NEW===============================
void setVector(){

first = NULL;
cout << "Enter size "; cin >> this->dimension;
cout << "Enter points ";

point *coord = new point;
first = coord;

cin >> first->value;
first->next = NULL;
coord = first;

for (int i = 1; i < this->dimension; i++){
while(coord->next != NULL) coord = coord->next;
coord->next = new point;
coord = coord->next;
cin >> coord->value;

}
this->id = amount_of_vectors + 1;
coord->next = NULL;
amount_of_vectors++;
}
//====================================PRINT====================================
void getVector(){
if (id / 1000 == 0) cout << "Id is " << id << "\n";
else cout << "Id is 0\n";
cout << "Coords is ( ";
point *tmp = first;
while(tmp->next != NULL){
cout << tmp->value << ", ";
tmp = tmp->next;
}
cout << tmp->value << " )" << "\n\n";
}
//========================================ADD===========================================
void addPoint(){
//if vec
point *tmp = first;
while(tmp->next != NULL) tmp = tmp->next;
tmp->next = new point;
tmp = tmp->next;
cout << "Enter a new point "; cin >> tmp->value;
tmp->next = NULL;
this->dimension++;
}

//========================================PUSH=====================================
void pushBack(int number){
point *tmp = first;
while(tmp->next != NULL) tmp = tmp->next;
point *p1 = new point;
tmp->next = p1;
tmp = tmp->next;
tmp->value = number;
tmp->next = NULL;
this->dimension++;
}
//===================================== =ASSIGNMENT= ======================================
void operator = (Vector &right){
point *t1 = this->first;
point *t2 = right.first;

while (this->dimension < right.dimension) this->pushBack(0); 
for (int i = 0; i < right.dimension; i++){
t1->value = t2->value;
t1 = t1->next; t2 = t2->next;
}
while (t1->next != NULL) {
point *deleting = t1->next;
t1->next = deleting->next;
delete deleting;
t1 = t1->next;
}}    
//===================================== +SUM+ ==============================================
Vector operator + (Vector &right){
Vector result = *this;
if (result.dimension < right.dimension){ while(result.dimension < right.dimension) result.pushBack(0); }
else { while(result.dimension > right.dimension) right.pushBack(0); }
point *t1 = result.first;
point *t2 = right.first;
Vector res;
point *newVec = new point;
res.first = newVec;
res.first->next = NULL;
for (int i = 1; i < right.dimension; i++) res.pushBack(0);
for (int i = 0; i < right.dimension; i++){
newVec->value = t1->value + t2->value;
t1 = t1->next; t2 = t2->next; newVec = newVec->next;
}
return res;
}

//===================================== *COMPSCAL* ==============================================
Vector operator * (float scalar){
point *t1 = this->first;
Vector res;
point *newVec = new point;
res.first = newVec;
res.first->next = NULL;
for (int i = 1; i < this->dimension; i++) res.pushBack(0);
for (int i = 0; i < this->dimension; i++){
newVec->value = t1->value * scalar;
t1 = t1->next; newVec = newVec->next;
}
return res;
}

//================================== -DIFF- =========================================================   
Vector operator - (Vector &right){
Vector result = *this;
if (result.dimension < right.dimension){ while(result.dimension < right.dimension) result.pushBack(0); }
else { while(result.dimension > right.dimension) right.pushBack(0);}
point *t1 = result.first;
point *t2 = right.first;
Vector res;
point *newVec = new point;
res.first = newVec;
res.first->next = NULL;
for (int i = 1; i < right.dimension; i++) res.pushBack(0);
for (int i = 0; i < right.dimension; i++){
newVec->value = t1->value - t2->value;
t1 = t1->next; t2 = t2->next; newVec = newVec->next;
}
return res;
}
//=================================== -UNO- ==============================================================    
Vector operator - (){
Vector result = *this;
point *t1 = result.first;
for (int i = 0; i < result.dimension; i++){
t1->value = -t1->value;
t1 = t1->next;
}
return result;
}
//======================================(SCALAR)=============================================================
float scalarCompos (Vector &right){
Vector &left = *this;
float result;
int n; if (left.dimension < right.dimension) n = left.dimension; else n = right.dimension;
point *t1 = left.first;
point *t2 = right.first;
for (int i = 0; i < n; i++){
result += t1->value * t2->value;
t1 = t1->next; t2 = t2->next;
}
return result;
}

//==========================================LENGTH========================================================
float length(){
float result;    
point *t1 = this->first;

for (int i = 0; i < this->dimension; i++){
result += (t1->value * t1->value);

t1 = t1->next;
}
result = sqrt(result);
return result;
}};
int Vector::amount_of_vectors = 0;
//========================================MAIN=============================================================
int main(){
Vector v1, v2;
v1.setVector(); v2.setVector();
v1.getVector(); v2.getVector();
Vector v3 = v1 + v2;
v3.getVector();
Vector v4 = v1 - v2;
v4.getVector();
Vector v5 = v1 * 5;
v5.getVector();
v1.addPoint();
v1.getVector();


return 0;
}