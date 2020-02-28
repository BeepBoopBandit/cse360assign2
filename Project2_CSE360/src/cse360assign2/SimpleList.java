/* Name: ATTICUS LEE
 * Class ID: 101
 * Assignment 2
 * Description: An update to the last program that includes append, first, last, and size functions
 * The program creates a simpleList and tests various functionalities of that simpleList.
*/
package cse360assign2;

import java.util.Arrays;

public class SimpleList {
	
private int[] list;
private int count;

public SimpleList() {
count=0;
list= new int[10];
}
public void add(int userVal) {
	int newSizeOfList;
	int sizeOfList=size();
	
	for(int iterator = (count - 1); iterator >= 0; iterator--){
		list[iterator + 1] = list[iterator];
	}
	if(count<sizeOfList) {
		count++;
	}
	else if (count>=sizeOfList) {
		newSizeOfList=(int) (count+(count*0.5));
		int[] copyOfList= Arrays.copyOf(list,newSizeOfList);
		list = new int[newSizeOfList];
		list= Arrays.copyOf(copyOfList, newSizeOfList);
		count++;
	}
	list[0]=userVal;
}
public void remove(int userVal) {
	int checkingValue= -1;
	int sizeCheck= size();
	int iterator=0;
	int fourthOfList;
	int newSizeOfList;
	boolean checkZero= true;
	boolean isEmpty = false;

	
	while(iterator < count) {
		if(list[iterator]==userVal) {
			checkingValue=iterator;
		}
		iterator++;
	}
	if(checkingValue != -1) {
		while(checkingValue<sizeCheck) {
			list[checkingValue]= list[checkingValue+1];
		checkingValue++;
		}
		list[sizeCheck]=0;
		count--;
	}
	fourthOfList= (int) (sizeCheck/4);
	int lastFourthOfList= fourthOfList*3;

	while(lastFourthOfList<=sizeCheck) {
		if(list[lastFourthOfList]==0) {
			checkZero=true;
		}
		else {
			checkZero=false;
		}
		if(checkZero=false) {
			isEmpty=false;
		}
		lastFourthOfList++;
	}
	if(isEmpty) {
		int iterator2=0;
		newSizeOfList=(int) (sizeCheck-fourthOfList);
		int[] copyOfList= new int[newSizeOfList];
		
		while(iterator2<newSizeOfList) {
			copyOfList[iterator2]= list[iterator2];
		list = new int[newSizeOfList];
		list = Arrays.copyOf(copyOfList, newSizeOfList);	
		}
	}
}
public int count() {
	return count;
}
public String toString() {
return list[0]+ " " +list[1]+ " "+ list[2] + " " + list[3] + " " + list[4] + " " +
		list[5] + " " + list[6] + " " + list[7] + " " + list[8] + " " + list[9]; 
}
public int search(int searchVal) {
	int iterator=0;
	int checkValue=-1;
	while(iterator<9) {
		if(list[iterator]==searchVal) {
			checkValue=iterator;
		}
	}
	return checkValue;
}
public int first() {
	int firstValue;
	if(size()==0) {
		firstValue=-1;
	}
	else {
		firstValue=list[0];
	}
	return firstValue;
}
public void append(int userVal) {
	int iterator=0;
	int newSizeOfList;
	if(count<size()) {
		while(list[iterator]!=0) {
			iterator++;
		}
		list[iterator]=userVal;
	}
	else {
		newSizeOfList=(int) (count+(count*0.5));
		int[] copyOfList= Arrays.copyOf(list,newSizeOfList);
		list = new int[newSizeOfList];
		list= Arrays.copyOf(copyOfList, newSizeOfList);
		while(list[iterator]!=0) {
			iterator++;
		}
		list[iterator]=userVal;
		count++;
	}
}
public int last() {
	int lastValue;
	if(size()==0) {
		lastValue=-1;
	}
	else {
		lastValue= list[size()-1];
	}
	return lastValue;
}
public int size() {
	return list.length;
}
}

