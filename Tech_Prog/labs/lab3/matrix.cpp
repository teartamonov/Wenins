#include <cmath>
#include <iostream>
#include <string>
#include <map>

using namespace std;
class Matrix;
class Vector{

private:

int id;
int dimension;
struct point{
point *next;
float value;

};
point *first;
friend class Matrix;
public:
static int amount_of_vectors;
//===================================DES\CONSTRUCTORS=============================
Vector(){}

Vector(float n){
this->dimension=1;    
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
cout << tmp->value << " )" << "\n"; //<< this->dimension;
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



class Matrix {

private:
    friend class Vector;
    int id;
    int height, width;
    struct point {
        point* next;
        point* below;
        int value;
   
    };
    point* first;
    
public:
    static int amount_of_matrices;
    //===================================DES\CONSTRUCTORS=============================><><><><
    Matrix() {}

    Matrix(int height, int width) {
        this->height = height;
        this->width = width;
        point* coord = new point;
        first = coord;
        first->next = NULL;
        first->below = NULL;
        for (int j = 0; j < height; j++) {
            coord->value = 0;
            for (int i = 0; i < width - 1; i++) {
                while (coord->next != NULL) coord = coord->next;
                coord->next = new point;
                if (j != height - 1) { coord->below = new point; coord->below->below = NULL; }
                coord = coord->next;
                coord->value = 0;
                coord->next = NULL;
            }
            if (j != height - 1) {
                coord = first;
                while (coord->below != NULL) coord = coord->below;
                coord->next = NULL;
            }
        }
        this->id = amount_of_matrices + 1;
        amount_of_matrices++;
    }
    ~Matrix() {

    }
    //========================================NEW===============================><><><><
    void setMatrix() {
        cout << "Enter height of your matrix\n";cin >> this->height;
        cout << "Enter width of your matrix\n"; cin >> this->width;
        cout << "Enter points\n";

        point* coord = new point;
        first = coord;

        for (int j = 0; j < this->height; j++) {
            cin >> coord->value;
            if (this->width == 1) {
                coord->next=NULL; 
                if (j != this->height - 1) coord->below = new point;}
            for (int i = 0; i < this->width - 1; i++) {
                while (coord->next != NULL) coord = coord->next;
                coord->next = new point;
                if (j != this->height - 1) coord->below = new point;
                else coord->below = NULL;
                coord = coord->next;
                cin >> coord->value;
                coord->next = NULL;
            }
            if (j != this->height - 1) {
                coord = first;
                while (coord->below != NULL) coord = coord->below;
                coord->next = NULL;
            }
        }
        this->id = amount_of_matrices + 1;
        amount_of_matrices++;
    }
    //====================================PRINT====================================><><><><
    void getMatrix() {
        int k = 0;
        if (id / 1000 == 0) cout << "Id is " << id << "\n";
        else cout << "Id is 0\n";
        cout << "Your matrix is \n";
        point* tmp = first;
        for (int i = 0; i < this->height; i++) {
            cout << "[ ";
            while (tmp != NULL) {
                cout << tmp->value << " ";
                tmp = tmp->next;
            }
            cout << "]\n";
            tmp = first;
            k += 1;
            for (int j = 0; j < k; j++) tmp = tmp->below;
        } 
    }
    //====================================[(INDEXING)]====================================><><><><
    int& operator () (int height, int width) {
        point* tmp = this->first;
        for (int i = 0; i < height; i++) tmp = tmp->below;
        for (int i = 0; i < width; i++) tmp = tmp->next;
        return tmp->value;
    }
    //===================================== =ASSIGNMENT= ======================================><><><><
    void operator = (Matrix& right) {
    delete this;    
    Matrix res(right.height, right.width);
    *this = res;
    for (int i = 0; i < right.height; i++) {
    for (int j = 0; j < right.width; j++){
    res(i, j) = right(i, j);}}
        
    }
    //===================================== +SUM+ ==============================================><><><><
    Matrix operator + (Matrix &right){
    Matrix left = *this;
    Matrix res(right.height, right.width);//(this->height);
    point *coord = res.first;
    for (int i = 0; i < right.height; i++){
    for (int j = 0; j < right.width; j++){
    res(i, j) = left(i, j) + right(i, j);}}
    return res;
    }
    
    //================================== -DIFF- =========================================================><><><><   
    Matrix operator - (Matrix &right){
    Matrix left = *this;
    Matrix res(right.height, right.width);
    for (int i = 0; i < right.height; i++){
    for (int j = 0; j < right.width; j++){
    res(i, j) = left(i, j) - right(i, j);}}
    return res;
    }
    //=================================== -UNO- ==============================================================><><><><    
    Matrix operator - (){
    Matrix left = *this;
    Matrix res(left.height, left.width);
    for (int i = 0; i < left.height; i++){
    for (int j = 0; j < left.width; j++){
    res(i, j) = -left(i, j);}}
    return res;
    }
    //=================================== *COMP* ==============================================================><><><><    
    Matrix operator * (Matrix &right){
    Matrix left = *this;
    Matrix res(left.height, right.width);   
    for (int k = 0; k < res.height; k++){ 
    for (int i = 0; i < res.width; i++){  
    for (int j = 0; j < left.width; j++){ 
    res(k, i) += left(k, j) * right(j, i);
    }}}
    return res;
    }
    //=================================== *SCAL*COMP* ==============================================================><><><><    
    Matrix operator * (int value){
    Matrix left = *this;
    Matrix res(left.height, left.width); 
    for (int i = 0; i < res.width; i++){ 
    for (int j = 0; j < left.width; j++){
    res(i, j) += left(i, j) * value;
    }}
    return res;
    }
    //============================ *VECTOR * MATRIX * COMPOSITION * ================================================><><><><    
    Matrix operator * (Vector& vector){
    Matrix left = *this;
    Vector::point *tmp = vector.first;
    point *t = left.first;
    if (vector.dimension != left.height) {cout << "Impossible to compose these objects\n"; Matrix n(1,1); return n;}
    Matrix res(1, vector.dimension);
    for (int i = 0; i < vector.dimension; i++){
    res(0, i) = tmp->value; tmp = tmp->next;  }
    return res * left;
    }
};
//=====================================CHECK VECTOR ID================================================== 
int enterAndCheckIDV(){
    int id; cout << "Enter ID of your Vector\n"; cin >> id;
    while ((id < 1) || (id > Vector::amount_of_vectors)){
    cout << "Entered incorrect value. Try again\n"; cin >> id;
    }
    return id;
}
//=====================================CHECK MATRIX ID==================================================
int enterAndCheckIDM(){
    int id; cout << "Enter ID of your Matrix\n"; cin >> id;
    while ((id < 1) || (id > Matrix::amount_of_matrices)){
    cout << "Entered incorrect value. Try again\n"; cin >> id;
    }
    return id;
}

int Matrix::amount_of_matrices = 0;
int Vector::amount_of_vectors = 0;
//========================================MAIN=============================================================
int main() {
int q, p;
cout << "Enter amount of vectors in this session\n"; cin >> q;
cout << "Enter amount of matrices in this session\n"; cin >> p;
Vector arrVec[q];
Matrix arrMatr[p];
mark:
cout << "Enter 'V' if you want to add a new vector\n";
cout << "Enter 'M' if you want to add a new matrix\n";
cout << "Enter 'L' if you want to count length of the vector\n";
cout << "Enter 'P' if you want to see all vectors\n";
cout << "Enter 'I' if you want to see all matrices\n";
cout << "Enter 'S' if you want to count scalar composition of two vectors\n";
cout << "Enter 'A' if you want to add a new dimension to the vector\n";
cout << "Enter '+' if you want to sum two objects\n";
cout << "Enter '-' if you want to count a difference between two objects or do uno minus\n";
cout << "Enter '*' if you want to multiply two objects\n";
cout << "Enter '=' if you want to make a new object equal existing object\n";
cout << "Enter '0' if you want to stop the programm\n";
char n = 'd';
while (true){
cin >> n;    
switch(n){
    case 'V':{
    if (Vector::amount_of_vectors == q) {cout << "You were reach the limit of vectors in this session\n"; break;}
    arrVec[Vector::amount_of_vectors];
    arrVec[Vector::amount_of_vectors].setVector();
    arrVec[Vector::amount_of_vectors - 1].getVector();
    break;}
    case 'M':{
    if (Matrix::amount_of_matrices == p) {cout << "You were reach the limit of matrices in this session\n"; break;}
    arrMatr[Matrix::amount_of_matrices];
    arrMatr[Matrix::amount_of_matrices].setMatrix();
    arrMatr[Matrix::amount_of_matrices - 1].getMatrix();
    break;}  
    case 'L':{
    cout << "Enter ID of your vector\n";
    int id = enterAndCheckIDV();
    cout << arrVec[id - 1].length();
    break;}
    case 'P':
    for (int i = 0; i < Vector::amount_of_vectors; i++)
    arrVec[i].getVector();
    break;
    case 'S':{
    int id1 = enterAndCheckIDV();
    int id2 = enterAndCheckIDV();
    arrVec[id1-1].scalarCompos(arrVec[id2 - 1]);
    break;}
    case 'A':
    arrVec[enterAndCheckIDV()].addPoint();    
    break;
    case 'I':
    for (int i = 0; i < Matrix::amount_of_matrices; i++)
    arrMatr[i].getMatrix();
    break;
    case '+':{
    cout << "Enter type of objects:\nMatrices(M) or Vectors(V)?\n"; char w; cin >> w;
    while(w != 'M' && w != 'V'){cout << "Entered incorrect value\n"; cin >> w;}
    if (w == 'M') {
    int id1 = enterAndCheckIDM();    
    int id2 = enterAndCheckIDM();
    (arrMatr[id1 - 1] + arrMatr[id2 - 1]).getMatrix();}
    else {
    int id1 = enterAndCheckIDV();    
    int id2 = enterAndCheckIDV();
    (arrVec[id1 - 1] + arrVec[id2 - 1]).getVector();}
    break;}
    case '-':{
    cout << "Enter type of objects:\nMatrices(M) or Vectors(V)?\n"; char w; cin >> w;
    while(w != 'M' && w != 'V'){cout << "Entered incorrect value\n"; cin >> w;}
    if (w == 'M') {
    int id1 = enterAndCheckIDM();    
    int id2 = enterAndCheckIDM();
    (arrMatr[id1 - 1] - arrMatr[id2 - 1]).getMatrix();}
    else {
    int id1 = enterAndCheckIDV();    
    int id2 = enterAndCheckIDV();
    (arrVec[id1 - 1] - arrVec[id2 - 1]).getVector();}
    break;}
    case '*':{
    cout << "Enter type of first object:\nMatrix(M) or Vector(V)?\n"; char w; cin >> w;
    while(w != 'M' && w != 'V'){cout << "Entered incorrect value\n"; cin >> w;}
    if (w == 'M') {
    cout << "Enter type of second object:\nMatrix(M) or Integer(I)?\n"; char k; cin >> k;
    while(k != 'M' && k != 'I'){cout << "Entered incorrect value\n"; cin >> k;}
    if (k == 'M'){    
    int id1 = enterAndCheckIDM();    
    int id2 = enterAndCheckIDM();
    (arrMatr[id1 - 1] * arrMatr[id2 - 1]).getMatrix();}
    else{
    int id1 = enterAndCheckIDM(); 
    int value; cout << "Enter integer number\n"; cin >> value; 
    (arrMatr[id1 - 1] * value).getMatrix();
    }}
    else {
    cout << "Enter type of second object:\nMatrix(M) or Integer(I)?\n"; char k; cin >> k;
    while(k != 'V' && k != 'I'){cout << "Entered incorrect value\n"; cin >> k;}
    if(k == 'I'){
    int id1 = enterAndCheckIDV(); 
    int value; cout << "Enter integer number\n"; cin >> value; 
    (arrVec[id1 - 1] * value).getVector();
    }
    else{
    int id1 = enterAndCheckIDV();    
    int id2 = enterAndCheckIDM();
    (arrMatr[id2 - 1] * arrVec[id1 - 1]).getMatrix();
    }    
    }
    break;}
    case '=':{
    cout << "Matrix(M) or Vector(V)\n"; char k; cin >> k;
    while(k != 'V' && k != 'I'){cout << "Entered incorrect value\n"; cin >> k;}
    if (k == 'V') {
    int id = enterAndCheckIDV();    
    arrVec[Vector::amount_of_vectors];
    arrVec[Vector::amount_of_vectors] = arrVec[id - 1];
    arrVec[Vector::amount_of_vectors].getVector();
    }
    else{
    int id = enterAndCheckIDM();    
    arrMatr[Matrix::amount_of_matrices];
    arrMatr[Matrix::amount_of_matrices] = arrMatr[id - 1];
    arrMatr[Matrix::amount_of_matrices - 1].getMatrix();
    }
    break;}
    case '0':
    return 0;
    default:
    cout << "Entered incorrect value. Try again.\n"; goto mark;
}}
return 0;
}