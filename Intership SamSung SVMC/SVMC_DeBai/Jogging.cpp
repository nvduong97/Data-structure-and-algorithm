#include <iostream>

using namespace std;
int Arr[10][10];
int N;
int NangLuong;
int NangLuongCan(int x, int y, int dai1, int rong1){
 int check = 0;
 int hang = x;
 int cot = y;
 //sang phai
 int cnt = rong1;
 while (cnt)
 {
  cot++;
  if(Arr[hang][cot] > Arr[hang][cot-1])
   check = check +(Arr[hang][cot] - Arr[hang][cot-1])*(Arr[hang][cot] - Arr[hang][cot-1])*2 + 1;
   
  else if(Arr[hang][cot] < Arr[hang][cot-1])
   check = check +(Arr[hang][cot] - Arr[hang][cot-1])*(Arr[hang][cot] - Arr[hang][cot-1]) + 1;

  else 
   check = check + 1; 
  cnt--;
 }
 //xuong 
 cnt = dai1;
 while (cnt)
 {
  //cout << hang << "_" << cot << "->";
  hang++;
  if(Arr[hang][cot] > Arr[hang-1][cot])
   check = check +(Arr[hang][cot] - Arr[hang-1][cot])*(Arr[hang][cot] - Arr[hang-1][cot])*2 + 1;
   
  else if(Arr[hang][cot] < Arr[hang-1][cot])
   check = check +(Arr[hang][cot] - Arr[hang-1][cot])*(Arr[hang][cot] - Arr[hang-1][cot]) + 1;

  else 
   check = check + 1; 
  cnt--;
 }
 //sang trai
 cnt = rong1;
 while (cnt)
 {
  //cout << hang << "_" << cot << "->";
  cot--;
  if(Arr[hang][cot] > Arr[hang][cot+1])
   check = check +(Arr[hang][cot] - Arr[hang][cot+1])*(Arr[hang][cot] - Arr[hang][cot+1])*2 + 1;
   
  else if(Arr[hang][cot] < Arr[hang][cot+1])
   check = check +(Arr[hang][cot] - Arr[hang][cot+1])*(Arr[hang][cot] - Arr[hang][cot+1]) + 1;

  else 
   check = check + 1; 
  cnt--;
 }

 //len 
 cnt = dai1;
 while (cnt)
 {
  //cout << hang << "_" << cot << "->";
  hang--;
  if(Arr[hang][cot] > Arr[hang+1][cot])
   check = check +(Arr[hang][cot] - Arr[hang+1][cot])*(Arr[hang][cot] - Arr[hang+1][cot])*2 + 1;
   
  else if(Arr[hang][cot] < Arr[hang+1][cot])
   check = check +(Arr[hang][cot] - Arr[hang+1][cot])*(Arr[hang][cot] - Arr[hang+1][cot]) + 1;

  else 
   check = check + 1; 
  cnt--;
 }
 
 return check;
}
int NangLuongCanNguoc(int x, int y, int dai1, int rong1){
 int check = 0;
 int hang = x;
 int cot = y;
 int cnt;
 
 //xuong 
 cnt = dai1;
 while (cnt)
 {
  //cout << hang << "_" << cot << "->";
  hang++;
  if(Arr[hang][cot] > Arr[hang-1][cot])
   check = check +(Arr[hang][cot] - Arr[hang-1][cot])*(Arr[hang][cot] - Arr[hang-1][cot])*2 + 1;
   
  else if(Arr[hang][cot] < Arr[hang-1][cot])
   check = check +(Arr[hang][cot] - Arr[hang-1][cot])*(Arr[hang][cot] - Arr[hang-1][cot]) + 1;

  else 
   check = check + 1; 
  cnt--;
 }
 //sang phai
 cnt = rong1;
 while (cnt)
 {
  //cout << hang << "_" << cot << "->";
  cot++;
  if(Arr[hang][cot] > Arr[hang][cot-1])
   check = check +(Arr[hang][cot] - Arr[hang][cot-1])*(Arr[hang][cot] - Arr[hang][cot-1])*2 + 1;
   
  else if(Arr[hang][cot] < Arr[hang][cot-1])
   check = check +(Arr[hang][cot] - Arr[hang][cot-1])*(Arr[hang][cot] - Arr[hang][cot-1]) + 1;

  else 
   check = check + 1; 
  cnt--;
 }
 

 //len 
 cnt = dai1;
 while (cnt)
 {
  //cout << hang << "_" << cot << "->";
  hang--;
  if(Arr[hang][cot] > Arr[hang+1][cot])
   check = check +(Arr[hang][cot] - Arr[hang+1][cot])*(Arr[hang][cot] - Arr[hang+1][cot])*2 + 1;
   
  else if(Arr[hang][cot] < Arr[hang+1][cot])
   check = check +(Arr[hang][cot] - Arr[hang+1][cot])*(Arr[hang][cot] - Arr[hang+1][cot]) + 1;

  else 
   check = check + 1; 
  cnt--;
 }
 //sang trai
 cnt = rong1;
 while (cnt)
 {
  //cout << hang << "_" << cot << "->";
  cot--;
  if(Arr[hang][cot] > Arr[hang][cot+1])
   check = check +(Arr[hang][cot] - Arr[hang][cot+1])*(Arr[hang][cot] - Arr[hang][cot+1])*2 + 1;
   
  else if(Arr[hang][cot] < Arr[hang][cot+1])
   check = check +(Arr[hang][cot] - Arr[hang][cot+1])*(Arr[hang][cot] - Arr[hang][cot+1]) + 1;

  else 
   check = check + 1; 
  cnt--;
 }
 return check;
}
int main()
{
 int tc,TestCase, output = 0;

 freopen("Text.txt", "r", stdin);
 freopen("Text1.txt", "w", stdout);
 cin>>TestCase;
 
 for(tc=0; tc<TestCase; tc++)
 {
  output = 0;
  cin >> N >> NangLuong;
  for(int i = 0; i < N; i++){
   for(int j = 0; j < N; j++){
    cin >> Arr[i][j];
   }
  }
   
  for(int i = 0; i < N-1; i++){
   for(int j = 0; j < N-1; j++){
    int dai, rong;
    for(dai = 1; dai < N; dai++){
     for(rong = 1; rong < N; rong++){
      if(i+dai < N &&
j + rong < N){
       int Answer;
       Answer =  NangLuongCan(i,j,dai,rong);
       if(Answer <= NangLuong){
        if((dai+rong)*2 > output)
         output = (dai+rong)*2;
       }
       Answer =  NangLuongCanNguoc(i,j,dai,rong);
       if(Answer <= NangLuong){
        if((dai+rong)*2 > output)
         output = (dai+rong)*2;
       }
      }
     }
    }
   }
  }
   
  ////////////////////////////////
  
  ////////////////////////////////
  cout<< "#" << tc+1 <<" "<< output << endl;
 }

 return 0;
}