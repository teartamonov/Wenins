#include <cmath>
#include <iostream>
#include <string>

using namespace std;

struct product{
    string name;
    float price;
    int amount;
    product *next;
};

product *first = NULL;


//=======================================CHECK===========================================
int checkAmount(){
cout << "Enter the amount of the adding product: "; int amount; cin >> amount;
while (amount < 0) {cout << "Entered incorrect value. Try again.\n"; cin >> amount;}
return amount;}

int checkPrice(){
cout << "Enter the price of the adding product: "; int price; cin >> price;
while (price < 0) {cout << "Entered incorrect value. Try again.\n"; cin >> price;}
return price;}

//========================================FIRST========================================
void addFirst(){
    product *tmp = new product;
    cout << "Enter the name of the product adding to the beginning of the list: ";
    cin >> tmp->name;
    tmp->price = checkPrice();
    tmp->amount = checkAmount();
    tmp->next = first;
    first = tmp;
}

//========================================LAST========================================
void addLast(){
    product *tmp = first;
    if(first==NULL) addFirst();
    else{
    while (tmp->next != NULL) tmp = tmp->next;
    tmp->next = new product;
    tmp = tmp->next;
    string name;
    float price;
    int amount;
    cout << "Enter the name of the product adding to the end of the list: "; 
    cin >> tmp->name;
    tmp->price = checkPrice();
    tmp->amount = checkAmount();
    tmp->next = NULL;
}}

//========================================DELETE========================================
void deleteItem(){
    if (first==NULL) cout << "Your list is empty";
else{
    string name;
    cout << "Enter the name of the deleting product: "; cin >> name;
    product *tmp = first;
    if (tmp->name == name) {first = tmp->next; delete tmp;}
else{
    while(tmp->next!=NULL && tmp->next->name!=name) tmp = tmp->next;
    if(tmp->next == NULL) cout << "There isn't product with this name\n";
    else{
        product *deleting_product = tmp->next;
        tmp->next = deleting_product->next;
        delete deleting_product;
}}}}

//========================================PRINT=========================================
void printList(){
    product *tmp = first;
    cout << "List of products\n---\n";
    while(tmp != NULL){
        cout << "Name of the product: " << tmp->name << "\n";
        cout << "Price of the product: " << tmp->price << "\n";
        cout << "Amount of the product: " << tmp->amount << "\n\n";
        tmp = tmp->next;
}}

//========================================AFTER=========================================
void addAfter(){
if (first==NULL) cout << "Your list is empty";
else{
product *tmp = first;
string name;
cout << "Enter the name of the product after which you want to add another: "; cin >> name;
while(tmp!=NULL && tmp->name!=name) tmp = tmp->next; 
if (tmp == NULL) cout << "There isn't product with this name\n";
else{
    product *vtmp = tmp->next;
    tmp->next = new product;
    tmp = tmp->next;
    string name;
    float price;
    int amount;
    cout << "Enter the name of the adding product: ";
    cin >> tmp->name;
    tmp->price = checkPrice();
    tmp->amount = checkAmount();
    tmp->next = vtmp;
}}}

//========================================BEFORE========================================
void addBefore(){
product *tmp = first;
if (first==NULL) cout << "Your list is empty";
else{
string name;
cout << "Enter the name of the product before which you want to add another: "; cin >> name;
if (tmp->name == name) addFirst();
else{
while(tmp->next!=NULL && tmp->next->name!=name) tmp = tmp->next; 
if (tmp->next == NULL || first==NULL) cout << "There isn't product with this name\n";
else{
    product *vtmp = tmp->next;
    tmp->next = new product;
    tmp = tmp->next;
    string name;
    float price;
    int amount;
    cout << "Enter the name of the adding product: ";   
    cin >> tmp->name;
    tmp->price = checkPrice();
    tmp->amount = checkAmount();
    tmp->next = vtmp;
}}}}



//========================================MAIN===========================================
int main(){
mark1:
char n;
while (true){
cout << "Enter 'F' if you want to add a product in the beginnig of the list\n";
cout << "Enter 'L' if you want to add a product in the end of the list\n";
cout << "Enter 'A' if you want to add a product after another product of the list\n";
cout << "Enter 'B' if you want to add a product before another product of the list\n";
cout << "Enter 'D' if you want to delete a product from the list\n";
cout << "Enter 'P' if you want to print list of the products\n";
cout << "Or Enter '0' if you want to stop adding products in the list\n"; cin >> n;
switch(n){
case 'F':
    addFirst();
    break;
case 'L':
    addLast();
    break;
case 'A':
    addAfter();
    break;
case 'B':
    addBefore();
    break;
case 'D':
    deleteItem();
    break;
case 'P':
    printList();
    break;
case '0':
    return 0;
default:
cout << "Entered incorrect value. Try again.\n";
goto mark1;
}
    cout<<"\n";
}
    return 0;
}