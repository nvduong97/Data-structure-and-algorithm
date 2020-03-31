package luyende;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* false testcase thu 3. Vừa xong thì fix lỗi arrayindexoutof, giờ thì lỗi logic
 * ý tưởng: for hết mảng mảng 2 chiều rồi backTrack trong đó tại 1 đỉnh bất kỳ rồi tìm ra số đỉnh đi được nhiều nhất
 */
public class Jogging {
 Scanner sc = new Scanner(System.in);
 int t, n, k, st, en, output;
 int map[][];

 void init() {
  output = 0;
  map = new int[n][n];
 }

 int NangLuongCan(int x, int y, int dai, int rong) {
  int check = 0;
  // sang phai
  int cnt = rong;
  while (cnt != 0) {
   y++;
   if (map[x][y] > map[x][y - 1]) {
    check += (map[x][y] - map[x][y - 1]) * (map[x][y] - map[x][y - 1]) * 2 + 1;
   } else if (map[x][y] < map[x][y - 1]) {
    check += (map[x][y] - map[x][y - 1]) * (map[x][y] - map[x][y - 1]) + 1;
   } else {
    check += 1;
   }
   cnt--;
  }
  // xuong
  cnt = dai;
  while (cnt != 0) {
   x++;
   if (map[x][y] > map[x - 1][y]) {
    check += (map[x][y] - map[x - 1][y]) * (map[x][y] - map[x - 1][y]) * 2 + 1;
   } else if (map[x][y] < map[x - 1][y]) {
    check += (map[x][y] - map[x - 1][y]) * (map[x][y] - map[x - 1][y]) + 1;
   } else {
    check += 1;
   }
   cnt--;
  }
  // sang trai
  cnt = rong;
  while (cnt != 0) {
   y--;
   if (map[x][y] > map[x][y + 1]) {
    check += (map[x][y] - map[x][y + 1]) * (map[x][y] - map[x][y + 1]) * 2 + 1;
   } else if (map[x][y] < map[x][y + 1]) {
    check += (map[x][y] - map[x][y + 1]) * (map[x][y] - map[x][y + 1]) + 1;
   } else {
    check += 1;
   }
   cnt--;
  }
  // len
  cnt = dai;
  while (cnt != 0) {
   x--;
   // mình vừa bị sai logic ở chỗ if chỗ này (chỗ tọa độ) còn
   // arrindexoutof thì bị chỗ + -
   if (map[x][y] > map[x + 1][y]) {
    check += (map[x][y] - map[x + 1][y]) * (map[x][y] - map[x + 1][y]) * 2 + 1;
   } else if (map[x][y] < map[x + 1][y]) {
    check += (map[x][y] - map[x + 1][y]) * (map[x][y] - map[x + 1][y]) + 1;
   } else {
    check += 1;
   }
   cnt--;
  }
  return check;

 }

 int NangLuongNguoc(int x, int y, int dai, int rong) {
  int check = 0;

  int cnt = rong;
  // xuong
  cnt = dai;
  while (cnt != 0) {
   x++;
   if (map[x][y] > map[x - 1][y]) {
    check += (map[x][y] - map[x - 1][y]) * (map[x][y] - map[x - 1][y]) * 2 + 1;
   } else if (map[x][y] < map[x - 1][y]) {
    check += (map[x][y] - map[x - 1][y]) * (map[x][y] - map[x - 1][y]) + 1;
   } else {
    check += 1;
   }
   cnt--;
  }
  // sang phai
  cnt = rong;
  while (cnt != 0) {
   y++;
   if (map[x][y] > map[x][y - 1]) {
    check += (map[x][y] - map[x][y - 1]) * (map[x][y] - map[x][y - 1]) * 2 + 1;
   } else if (map[x][y] < map[x][y - 1]) {
    check += (map[x][y] - map[x][y - 1]) * (map[x][y] - map[x][y - 1]) + 1;
   } else {
    check += 1;
   }
   cnt--;
  }
  // len
  cnt = dai;
  while (cnt != 0) {
   x--;
   // mình vừa bị sai logic ở chỗ if chỗ này (chỗ tọa độ) còn
   // arrindexoutof thì bị chỗ + -
   if (map[x][y] > map[x + 1][y]) {
    check += (map[x][y] - map[x + 1][y]) * (map[x][y] - map[x + 1][y]) * 2 + 1;
   } else if (map[x][y] < map[x + 1][y]) {
    check += (map[x][y] - map[x + 1][y]) * (map[x][y] - map[x + 1][y]) + 1;
   } else {
    check += 1;
   }
   cnt--;
  }
  // sang trai
  cnt = rong;
  while (cnt != 0) {
   y--;
   if (map[x][y] > map[x][y + 1]) {
    check += (map[x][y] - map[x][y + 1]) * (map[x][y] - map[x][y + 1]) * 2 + 1;
   } else if (map[x][y] < map[x][y + 1]) {
    check += (map[x][y] - map[x][y + 1]) * (map[x][y] - map[x][y + 1]) + 1;
   } else {
    check += 1;
   }
   cnt--;
  }

  return check;
 }

 void solution() {
  t = sc.nextInt();
  for (int tc = 1; tc <= t; tc++) {
   n = sc.nextInt();
   k = sc.nextInt();
   init();
   for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
     map[i][j] = sc.nextInt();
    }
   }
   for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1; j++) {
     int dai, rong;
     for (dai = 1; dai < n; dai++) {
      for (rong = 1; rong < n; rong++) {
       // ko để (i + dai <= n && j + rong <= n) được vì giả sử chạy từ (0,1) thì chạy max tới n-1, (độ dài hìn
h chữ nhật max nhất là n (từ 0 tới (n-1) độ dài là n)
       if (i + dai < n && j + rong < n) {
        int ans;
        ans = NangLuongCan(i, j, dai, rong);
        if (ans <= k) {
         if ((dai + rong) * 2 > output) {
          output = (dai + rong) * 2;
         }
        }
        ans = NangLuongNguoc(i, j, dai, rong);
        if (ans <= k) {
         if ((dai + rong) * 2 > output) {
          output = (dai + rong) * 2;
         }
        }
       }
      }
     }
    }
   }
   System.out.println("#" + tc + " " + output);
  }
 }

 public static void main(String[] args) throws Exception {
  System.setIn(new FileInputStream("Jogging.txt"));
  Jogging j = new Jogging();
  j.solution();
 }

}