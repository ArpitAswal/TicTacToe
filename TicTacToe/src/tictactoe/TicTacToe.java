/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author KakasHi
 */
import java.util.*;
import java.io.*;

class TicTacToe
{
static HashSet<Integer> user_set=new HashSet<Integer>();
static HashSet<Integer> comp_set=new HashSet<Integer>();
public static void main(String args[])
{
char [][] g_board={
           {' ',' ','|',' ',' ','|',' ',' '},
           {'-','-','|','-','-','|','-','-'},
           {' ',' ','|',' ',' ','|',' ',' '},
           {'-','-','|','-','-','|','-','-'},
           {' ',' ','|',' ',' ','|',' ',' '},
        };

Scanner sc=new Scanner(System.in);
while(true){
System.out.print("Enter the value from 1-9: ");
int user_pos=sc.nextInt();
while(user_set.contains(user_pos) || comp_set.contains(user_pos)){
System.out.println();
System.out.print("Retry Enter the value from 1-9");
user_pos=sc.nextInt();
}
filling(g_board,user_pos,"You");

String res=winner();
if(res.length()>0){
System.out.println(res);
break;
}
int comp_pos=get_random();
while(user_set.contains(comp_pos) || comp_set.contains(comp_pos)){
comp_pos=get_random();
}
filling(g_board,comp_pos,"Comp");
res=winner();
if(res.length()>0){
System.out.println(res);
break;
}
}
}
static void print_board(char [][]g_board){
for(int x=0;x<g_board.length;x++){
for(int y=0;y<g_board[0].length;y++){
System.out.print(g_board[x][y]);}
System.out.println();
}
}
static void filling(char [][]g_board,int pos,String user){
char symb='O';
if(user.equals("You")){
symb='O';
user_set.add(pos);
}
else if(user.equals("Comp")){
symb='X';
comp_set.add(pos);
}
switch(pos){
case 1:
g_board[0][1]=symb;
break;
case 2:
g_board[0][4]=symb;
break;
case 3:
g_board[0][7]=symb;
break;
case 4:
g_board[2][1]=symb;
break;
case 5:
g_board[2][4]=symb;
break;
case 6:
g_board[2][7]=symb;
break;
case 7:
g_board[4][1]=symb;
break;
case 8:
g_board[0][4]=symb;
break;
case 9:
g_board[4][7]=symb;
break;

default:
System.out.println("Invalid Input");
}
System.out.println();
print_board(g_board);
}
static int get_random(){
int max=9;
int min=1;
int range=max-min+1;
int res= (int) (Math.random()*range)+min;
return res;
}
static String winner(){
HashSet<Integer> r1=new HashSet<Integer>();
r1.add(1);r1.add(2);r1.add(3);
HashSet<Integer> r2=new HashSet<Integer>();
r2.add(4);r2.add(5);r2.add(6);
HashSet<Integer> r3=new HashSet<Integer>();
r3.add(7);r3.add(8);r3.add(9);
HashSet<Integer> c1=new HashSet<Integer>();
c1.add(1);c1.add(4);c1.add(7);
HashSet<Integer> c2=new HashSet<Integer>();
c2.add(2);c2.add(5);c2.add(8);
HashSet<Integer> c3=new HashSet<Integer>();
c3.add(3);c3.add(6);c3.add(9);
HashSet<Integer> d1=new HashSet<Integer>();
d1.add(1);d1.add(5);d1.add(9);
HashSet<Integer> d2=new HashSet<Integer>();
d2.add(3);d2.add(5);d2.add(7);

HashSet<HashSet> set=new HashSet<HashSet>();
set.add(r1);set.add(r2);set.add(r3);
set.add(c1);set.add(c2);set.add(c3);
set.add(d1);set.add(d2);

for(HashSet h:set){
if(user_set.containsAll(h))
return "You WON";
else if(comp_set.containsAll(h))
return "You Lose";
}
if(user_set.size()+comp_set.size()==9)
return "Draw";
else
return "";
}
}